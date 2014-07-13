package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;

/**
 * @author nailgun
 * @since 13.07.14
 */
public interface Stage<T> {

    Expect getExpect();

    String getTemplate();

    boolean isExit();

    Stage action(T input);

}
