package com.korvyakov.insightdataengineering.blackjack.service;

/**
 *
 * Works with requests from the UI and main
 *
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface Controller {

	/**
	 * Launches the application work
	 */
	void start();

	/**
	 * Validates and processes the input from UI
	 * @param input the raw input from UI
	 */
	void input(String input);

}
