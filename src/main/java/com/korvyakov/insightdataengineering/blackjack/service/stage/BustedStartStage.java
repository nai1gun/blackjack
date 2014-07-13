package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import com.korvyakov.insightdataengineering.blackjack.domain.Shoe;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class BustedStartStage extends StartStage {

    @Override
    public String getTemplate() {
        return "play";
    }

}
