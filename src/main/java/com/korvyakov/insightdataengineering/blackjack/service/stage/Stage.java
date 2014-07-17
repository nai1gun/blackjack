package com.korvyakov.insightdataengineering.blackjack.service.stage;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;

/**
 * Stage represents a state of the game
 *
 * @author nailgun
 * @since 13.07.14
 */
public interface Stage<T> {

	/**
	 * @return what to expect from the user after the stage
	 */
    Expect getExpect();

	/**
	 * @return name of the corresponding template
	 */
    String getTemplate();

	/**
	 * @return true if application should be closed after the stage
	 */
    boolean isExit();

	/**
	 * Actions on user input
	 * @param input command
	 * @return the next stage
	 */
    Stage action(T input);

}
