package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.service.GameContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author nailgun
 * @since 13.07.14
 */
abstract class AbstractStage<T> implements Stage<T> {

    @Autowired protected GameContext gameContext;
    @Autowired protected ApplicationContext applicationContext;

    @Override
    public boolean isExit() {
        return false;
    }

    protected void playerWins() {
        gameContext.setTotalChips(gameContext.getTotalChips() + gameContext.getBet() * 2);
    }

    protected void playerLoses() {
        if (gameContext.getBet() > gameContext.getTotalChips()) {
            gameContext.setTotalChips(gameContext.getBet());
        }
    }

    protected void push() {
        gameContext.setTotalChips(gameContext.getTotalChips() + gameContext.getBet());
    }
}
