package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Output;

/**
 * Responsible for the game states interaction and output model creation
 *
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface GameService {

	/**
	 * Starts the new game
	 * @return the result of the action as raw data
	 */
	Output newGame();

	/**
	 * Processes the input from user
	 * @param input the command (validated input) from UI
	 * @param <T> either String or Integer
	 * @return the result of the action as raw data
	 */
	@SuppressWarnings("unchecked")
	<T> Output action(T input);

}
