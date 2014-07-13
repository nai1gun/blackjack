package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import com.korvyakov.insightdataengineering.blackjack.domain.Shoe;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nailgun
 * @since 13.07.14
 */
abstract class StartStage extends AbstractStage<String> {

    @Override
    public Expect getExpect() {
        return Expect.expectOptions("Please enter c to change bet or d to deal.", "c", "d");
    }

    @Override
    public Stage action(String input) {
        boolean deal = "d".equals(input);
        if (deal) {
            gameContext.setTotalChips(gameContext.getTotalChips() - gameContext.getBet());
            Shoe shoe = new Shoe();
            gameContext.setShoe(shoe);
            List<Card> playerCards = new LinkedList<>();
            List<Card> dealerCards = new LinkedList<>();
            playerCards.add(shoe.takeCard());
            playerCards.add(shoe.takeCard());
            dealerCards.add(shoe.takeCard());
            gameContext.setPlayerCards(playerCards);
            gameContext.setDealerCards(dealerCards);
            return applicationContext.getBean(DealStage.class);
        } else {
            return applicationContext.getBean(BetStage.class);
        }
    }
}
