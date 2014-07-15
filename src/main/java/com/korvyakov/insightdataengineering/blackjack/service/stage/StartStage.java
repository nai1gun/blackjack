package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import com.korvyakov.insightdataengineering.blackjack.domain.Shoe;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nailgun
 * @since 13.07.14
 */
abstract class StartStage extends AbstractStage<String> {

    private static final String EXPECT_OPTIONS =
            "Please enter @|bold d|@ to deal, @|bold c|@ to change bet " +
            "or @|bold e|@ to exit the game.";

    @Override
    public Expect getExpect() {
        return Expect.expectOptions(EXPECT_OPTIONS, "d", "c", "e");
    }

    @Override
    public Stage action(String input) {
        if ("d".equals(input)) {
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
            if (gameContext.isPlayerBlackjack()) {
                dealerCards.add(shoe.takeCard());
                if (gameContext.isDealerBlackjack()) {
                    push();
                } else {
                    playerWins();
                }
                return applicationContext.getBean(NextGameStartStage.class);
            }
            return applicationContext.getBean(DealStage.class);
        } else if ("c".equals(input)) {
            return applicationContext.getBean(BetStage.class);
        }
        return applicationContext.getBean(GoodByeStage.class);
    }
}
