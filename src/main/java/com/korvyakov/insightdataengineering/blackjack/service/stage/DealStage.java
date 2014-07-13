package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class DealStage extends AbstractStage<String> {

    @Override
    public Expect getExpect() {
        return Expect.expectOptions("Please enter h to hit or s to stay", "h", "s");
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
                return applicationContext.getBean(BustedStartStage.class);
            } else {
                return this;
            }
        } else {
            return applicationContext.getBean(NewGameStartStage.class);
        }
    }
}
