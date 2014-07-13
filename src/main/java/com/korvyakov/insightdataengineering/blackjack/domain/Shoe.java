package com.korvyakov.insightdataengineering.blackjack.domain;

import java.util.*;

/**
 * @author nailgun
 * @since 13.07.14
 */
public class Shoe {

    private List<Card> cards;

    public Shoe(int numberOfSets) {
        cards = new LinkedList<>();
        for (int i = 0; i < numberOfSets; i++) {
            for (Card.Suit suit: Card.Suit.values()) {
                for (Card.Value value: Card.Value.values()) {
                    cards.add(new Card(value, suit));
                }
            }
        }
    }

    public Shoe() {
        this(1);
    }

    public Card takeCard() {
        return cards.remove(new Random().nextInt(cards.size()));
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
