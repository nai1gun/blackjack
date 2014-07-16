package com.korvyakov.insightdataengineering.blackjack.service;

import java.util.Map;

/**
 * Generates the view text data for the UI
 *
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface TemplateEngine {

	/**
	 * Generate the text for the UI
	 * @param templateName name of the needed template file
	 * @param model the data to output
	 * @return the generated text
	 */
	String render(String templateName, Map<String, Object> model);

}
