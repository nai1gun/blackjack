package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;

import java.util.List;

/**
 *
 * Contains the game state variables and state check methods
 *
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface GameContext {

	/**
	 * Throw away all the data and restore the defaults
	 */
	void restart();

	int getTotalChips();

	void setTotalChips(int totalChips);

	int getBet();

	void setBet(int bet);

	List<Card> getPlayerCards();

	void setPlayerCards(List<Card> playerCards);

	List<Card> getDealerCards();

	void setDealerCards(List<Card> dealerCards);

	int getDealerPoints();

	int getPlayerPoints();

	/**
	 * @return true if dealer currently has more points than 21
	 */
	boolean isDealerBusted();

	/**
	 * @return true if player currently has more points than 21
	 */
	boolean isPlayerBusted();

	/**
	 * @return true if dealer currently has 'Blackjack' combination
	 */
	boolean isDealerBlackjack();

	/**
	 * @return true if dealer currently has 'Blackjack' combination
	 */
	boolean isPlayerBlackjack();

	/**
	 * @return the result of the shuffle according to current situation
	 */
	ShuffleResult getShuffleResult();

}
