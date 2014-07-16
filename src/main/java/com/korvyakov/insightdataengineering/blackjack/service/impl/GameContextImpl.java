package com.korvyakov.insightdataengineering.blackjack.service.impl;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;
import com.korvyakov.insightdataengineering.blackjack.service.GameContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class GameContextImpl implements GameContext {

    private static final int DEFAULT_CHIPS = 100;

    private static final int DEFAULT_BET = 1;

    private int totalChips;

    private int bet;

    private List<Card> playerCards;

    private List<Card> dealerCards;

    @Override public void restart() {
        totalChips = DEFAULT_CHIPS;
        bet = DEFAULT_BET;
        playerCards = null;
        dealerCards = null;
    }

    @Override public int getTotalChips() {
        return totalChips;
    }

    @Override public void setTotalChips(int totalChips) {
        this.totalChips = totalChips;
    }

    @Override public int getBet() {
        return bet;
    }

    @Override public void setBet(int bet) {
        this.bet = bet;
    }

    @Override public List<Card> getPlayerCards() {
        return playerCards;
    }

    @Override public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    @Override public List<Card> getDealerCards() {
        return dealerCards;
    }

    @Override public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }

    @Override public int getDealerPoints() {
        return getPoints(dealerCards);
    }

    @Override public int getPlayerPoints() {
        return getPoints(playerCards);
    }

    @Override public boolean isDealerBusted() {
        return getDealerPoints() > 21;
    }

    @Override public boolean isPlayerBusted() {
        return getPlayerPoints() > 21;
    }

    @Override public boolean isDealerBlackjack() {
        return dealerCards.size() == 2 && getDealerPoints() == 21;
    }

    @Override public boolean isPlayerBlackjack() {
        return playerCards.size() == 2 && getPlayerPoints() == 21;
    }

    @Override public ShuffleResult getShuffleResult() {
        if ((isPlayerBlackjack() && !isDealerBlackjack()) ||
                (!isPlayerBusted() && (isDealerBusted() || getPlayerPoints() > getDealerPoints()))) {
            return ShuffleResult.WIN;
        } else if ((isDealerBlackjack() && !isPlayerBlackjack()) ||
                (!isDealerBusted() && (isPlayerBusted() || getDealerPoints() > getPlayerPoints()))) {
            return ShuffleResult.LOOSE;
        }
        return ShuffleResult.PUSH;
    }

    private static int getPoints(Collection<Card> cards) {
        int sum = 0;
        for (Card card: cards) {
            if (card.getValue() != Card.Value.ACE) {
                sum += card.getValue().getPoints();
            }
        }
        List<Card> aces = new ArrayList<>();
        for (Card card: cards) {
            if (card.getValue() == Card.Value.ACE) {
                aces.add(card);
            }
        }
        if (aces.size() > 0) {
            sum += aces.size() - 1;
            if (sum + 11 <= 21) {
                sum += 11;
            } else {
                sum += 1;
            }
        }
        return sum;
    }
}
