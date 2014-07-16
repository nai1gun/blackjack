package com.korvyakov.insightdataengineering.blackjack.service;

/**
 *
 * Handles console output.
 *
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface ConsoleEngine {

	/**
	 * Print the output
	 * @param output text to print
	 * @param exit true to quit application after printing
	 */
	void print(String output, boolean exit);

}
