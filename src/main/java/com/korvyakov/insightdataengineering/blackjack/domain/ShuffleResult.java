package com.korvyakov.insightdataengineering.blackjack.domain;

/**
 * Possible results of a shuffle
 *
 * @author nailgun
 * @since 13.07.14
 */
public enum ShuffleResult {

	/**
	 * Player wins
	 */
    WIN,

	/**
	 * Player looses
	 */
	LOOSE,

	/**
	 * Nobody wins
	 */
	PUSH

}
