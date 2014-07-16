package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class GameOverStage  extends AbstractStage<String>{

    private static final String EXPECT_OPTIONS =
            "Would you like to play another game? (Enter @|bold y|@ or @|bold n|@)";

    @Override
    public Expect getExpect() {
        return Expect.expectOptions(EXPECT_OPTIONS, "y", "n");
    }

    @Override
    public String getTemplate() {
        return "next";
    }

    @Override
    public Stage action(String input) {
        if ("y".equals(input)) {
            gameContext.restart();
            return applicationContext.getBean(NewGameStartStage.class);
        }
        return applicationContext.getBean(GoodByeStage.class);
    }

}
