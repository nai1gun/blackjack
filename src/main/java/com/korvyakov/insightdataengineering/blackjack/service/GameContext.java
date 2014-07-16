package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;

import java.util.List;

/**
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
public interface GameContext {

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

	boolean isDealerBusted();

	boolean isPlayerBusted();

	boolean isDealerBlackjack();

	boolean isPlayerBlackjack();

	ShuffleResult getShuffleResult();

}
