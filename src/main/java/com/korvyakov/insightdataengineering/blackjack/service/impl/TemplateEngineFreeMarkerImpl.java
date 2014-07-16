package com.korvyakov.insightdataengineering.blackjack.service.impl;

import com.korvyakov.insightdataengineering.blackjack.service.TemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author nailgun
 * @since 12.07.14
 */
@Component
public class TemplateEngineFreeMarkerImpl implements TemplateEngine {

	private static final String TEMPLATE_DIR = "/com/korvyakov/insightdataengineering/blackjack/template";

	@Autowired private TemplateHelper templateHelper;

    @Override public String render(String templateName, Map<String, Object> model) {
	    model.put("h", templateHelper);
        Configuration templateCfg = new Configuration();
        templateCfg.setClassForTemplateLoading(this.getClass(), TEMPLATE_DIR);
        templateCfg.setDefaultEncoding("UTF-8");
        templateCfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        Template template;
        try {
            template = templateCfg.getTemplate(templateName + ".ftl");
        } catch (IOException e) {
            throw new IllegalStateException(String.format("Couldn't load template with name '%s'", templateName), e);
        }
        Writer resultWriter = new StringWriter();
        try {
            template.process(model, resultWriter);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException(String.format("Error while processing template '%s'", templateName), e);
        }
        return resultWriter.toString();
    }

}
