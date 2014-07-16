package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;

/**
 *
 * Shoe holds one or multiple decks of playing cards.
 *
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 * @see com.korvyakov.insightdataengineering.blackjack.domain.Card
 */
public interface Shoe {

	/**
	 * @return the new card
	 */
	public Card takeCard();

	/**
	 * Creates the new fresh collection of cards
	 */
	public void reload();

}
