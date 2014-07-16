package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;
import com.korvyakov.insightdataengineering.blackjack.service.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class DealStage extends AbstractStage<String> {

    private static final String EXPECT_OPTIONS = "Please enter @|bold h|@ to hit or @|bold s|@ to stay.";

	@Autowired private Shoe shoe;

    @Override
    public Expect getExpect() {
        return Expect.expectOptions(EXPECT_OPTIONS, "h", "s");
    }

    @Override
    public String getTemplate() {
        return "play";
    }

    @Override
    public Stage action(String input) {
        boolean hit = "h".equals(input);
        if (hit) {
            gameContext.getPlayerCards().add(shoe.takeCard());
            if (gameContext.isPlayerBusted()) {
                playerLoses();
                return nextStage();
            } else if(gameContext.getPlayerPoints() == 21) {
                dealerTurn();
                return nextStage();
            } else {
                return this;
            }
        }
        dealerTurn();
        return nextStage();
    }

    private void dealerTurn() {
        while(gameContext.getDealerPoints() < 17) {
            gameContext.getDealerCards().add(shoe.takeCard());
        }
        if (gameContext.getShuffleResult() == ShuffleResult.WIN) {
            playerWins();
        } else if (gameContext.getShuffleResult() == ShuffleResult.LOOSE) {
            playerLoses();
        } else {
            push();
        }
    }

    private Stage nextStage() {
        return gameContext.getTotalChips() > 0 ?
                applicationContext.getBean(NextGameStartStage.class) :
                applicationContext.getBean(GameOverStage.class);
    }

}
