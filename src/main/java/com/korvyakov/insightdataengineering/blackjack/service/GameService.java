package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.domain.Output;
import com.korvyakov.insightdataengineering.blackjack.service.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class GameService {

    @Autowired private GameContext gameContext;
    @Autowired private ApplicationContext applicationContext;

    private Stage stage;

    public Output newGame() {
        gameContext.restart();
        stage = applicationContext.getBean("startStage", Stage.class);
        Map<String, Object> model = createModel();
        return new Output(stage.getTemplate(), model, stage.getExpect(), false);
    }

    @SuppressWarnings("unchecked")
    public <T> Output action(T input) {
        stage = stage.action(input);
        Map<String, Object> model = createModel();
        return new Output(stage.getTemplate(), model, stage.getExpect(), stage.isExit());
    }

    private Map<String, Object> createModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("context", gameContext);
        model.put("require", stage.getExpect().getDescription());
        return model;
    }

}
