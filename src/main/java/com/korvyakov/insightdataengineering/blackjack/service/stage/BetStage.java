package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class BetStage extends AbstractStage<Integer> {

    @Override
    public Expect getExpect() {
        return Expect.expectNumber(
                String.format("Please enter new bet from %s to %s", 1, gameContext.getTotalChips()),
                1, gameContext.getTotalChips());
    }

    @Override
    public String getTemplate() {
        return "start";
    }

    @Override
    public Stage action(Integer input) {
        gameContext.setBet(input);
        return applicationContext.getBean(NewGameStartStage.class);
    }
}
