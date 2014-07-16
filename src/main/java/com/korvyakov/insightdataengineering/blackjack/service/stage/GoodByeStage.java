package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class GoodByeStage extends AbstractStage<String> {

    @Override
    public Expect getExpect() {
        return Expect.none();
    }

    @Override
    public String getTemplate() {
        return "goodbye";
    }

    @Override
    public Stage action(String input) {
        return this;
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
