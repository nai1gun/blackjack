package com.korvyakov.insightdataengineering.blackjack.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
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
public class TemplateEngine {

    public String render(String templateName, Map<String, Object> model) {
        Configuration templateCfg = new Configuration();
        templateCfg.setClassForTemplateLoading(this.getClass(), "");
        templateCfg.setDefaultEncoding("UTF-8");
        templateCfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        Template template;
        try {
            template = templateCfg.getTemplate(templateName + ".ftl");
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't load template with name '" + templateName + "'", e);
        }
        Writer resultWriter = new StringWriter();
        try {
            template.process(model, resultWriter);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Error while processing template '" + templateName + "'", e);
        }
        return resultWriter.toString();
    }

}
