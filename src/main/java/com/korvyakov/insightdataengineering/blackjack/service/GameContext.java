package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.Shoe;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class GameContext {

    private static final int DEFAULT_CHIPS = 100;

    private static final int DEFAULT_BET = 1;

    private int totalChips;

    private int bet;

    private Shoe shoe;

    private List<Card> playerCards;

    private List<Card> dealerCards;

    public void restart() {
        totalChips = DEFAULT_CHIPS;
        bet = DEFAULT_BET;
        shoe = null;
        playerCards = null;
        dealerCards = null;
    }

    public int getTotalChips() {
        return totalChips;
    }

    public void setTotalChips(int totalChips) {
        this.totalChips = totalChips;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }

    public int getDealerPoints() {
        return getPoints(dealerCards);
    }

    public int getPlayerPoints() {
        return getPoints(playerCards);
    }

    public boolean isDealerBusted() {
        return getDealerPoints() > 21;
    }

    public boolean isPlayerBusted() {
        return getPlayerPoints() > 21;
    }

    public boolean isDealerBlackjack() {
        return dealerCards.size() == 2 && getDealerPoints() == 21;
    }

    public boolean isPlayerBlackjack() {
        return playerCards.size() == 2 && getPlayerPoints() == 21;
    }

    public ShuffleResult getShuffleResult() {
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
