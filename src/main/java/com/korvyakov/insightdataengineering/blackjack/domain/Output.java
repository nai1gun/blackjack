package com.korvyakov.insightdataengineering.blackjack.domain;

import java.util.Map;

/**
 * @author nailgun
 * @since 13.07.14
 */
public class Output {

    private String template;

    private Map<String, Object> templateModel;

    private Expect expect;

    private boolean exit;

    public Output(String template, Map<String, Object> templateModel, Expect expect, boolean exit) {
        this.template = template;
        this.templateModel = templateModel;
        this.expect = expect;
        this.exit = exit;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, Object> getTemplateModel() {
        return templateModel;
    }

    public void setTemplateModel(Map<String, Object> templateModel) {
        this.templateModel = templateModel;
    }

    public Expect getExpect() {
        return expect;
    }

    public void setExpect(Expect expect) {
        this.expect = expect;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
