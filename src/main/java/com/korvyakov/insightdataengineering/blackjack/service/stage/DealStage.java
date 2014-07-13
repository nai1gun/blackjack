package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class DealStage extends AbstractStage<String> {

    @Override
    public Expect getExpect() {
        return Expect.expectOptions("Please enter h to hit or s to stay.", "h", "s");
    }

    @Override
    public String getTemplate() {
        return "play";
    }

    @Override
    public Stage action(String input) {
        boolean hit = "h".equals(input);
        if (hit) {
            gameContext.getPlayerCards().add(gameContext.getShoe().takeCard());
            if (gameContext.isPlayerBusted()) {
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
            gameContext.getDealerCards().add(gameContext.getShoe().takeCard());
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
