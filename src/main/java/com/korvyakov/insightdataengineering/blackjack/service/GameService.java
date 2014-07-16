package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Output;

/**
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface GameService {

	Output newGame();

	@SuppressWarnings("unchecked")
	<T> Output action(T input);

}
