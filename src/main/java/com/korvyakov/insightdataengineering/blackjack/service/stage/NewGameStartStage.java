package com.korvyakov.insightdataengineering.blackjack.service.stage;

import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class NewGameStartStage extends StartStage {

    @Override
    public String getTemplate() {
        return "start";
    }

}
