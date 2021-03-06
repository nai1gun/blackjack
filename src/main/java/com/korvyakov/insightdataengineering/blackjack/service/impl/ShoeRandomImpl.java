package com.korvyakov.insightdataengineering.blackjack.service.impl;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.service.Shoe;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
@Component
public class ShoeRandomImpl implements Shoe {

	private int numberOfSets;

	private List<Card> cards;

	public ShoeRandomImpl(int numberOfSets) {
		this.numberOfSets = numberOfSets;
		reload();
	}

	public ShoeRandomImpl() {
		this(1);
	}

	public Card takeCard() {
		return cards.remove(new Random().nextInt(cards.size()));
	}

	public void reload() {
		cards = new LinkedList<>();
		for (int i = 0; i < numberOfSets; i++) {
			for (Card.Suit suit: Card.Suit.values()) {
				for (Card.Value value: Card.Value.values()) {
					cards.add(new Card(value, suit));
				}
			}
		}
	}
}
