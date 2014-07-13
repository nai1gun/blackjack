package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.service.GameContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
abstract class AbstractStage<T> implements Stage<T> {

    @Autowired protected GameContext gameContext;
    @Autowired protected ApplicationContext applicationContext;

}
