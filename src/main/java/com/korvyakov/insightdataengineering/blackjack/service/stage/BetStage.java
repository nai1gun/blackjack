package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class BetStage extends AbstractStage<Integer> {

    private static final String EXPECT_PATTERN = "Please enter new bet from @|bold %s|@ to @|bold %s|@";

    @Override
    public Expect getExpect() {
        return Expect.expectNumber(
                String.format(EXPECT_PATTERN, 1, gameContext.getTotalChips()),
                1, gameContext.getTotalChips());
    }

    @Override
    public String getTemplate() {
        return gameContext.getPlayerCards() == null ? "start" : "next";
    }

    @Override
    public Stage action(Integer input) {
        gameContext.setBet(input);
        return applicationContext.getBean(gameContext.getPlayerCards() == null ?
                NewGameStartStage.class : NextGameStartStage.class);
    }

}
