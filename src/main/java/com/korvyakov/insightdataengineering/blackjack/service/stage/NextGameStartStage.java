package com.korvyakov.insightdataengineering.blackjack.service.stage;

import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class NextGameStartStage extends StartStage {

    @Override
    public String getTemplate() {
        return "next";
    }

}
