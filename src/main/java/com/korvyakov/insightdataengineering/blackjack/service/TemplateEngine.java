package com.korvyakov.insightdataengineering.blackjack.service;

import java.util.Map;

/**
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface TemplateEngine {

	String render(String templateName, Map<String, Object> model);

}
