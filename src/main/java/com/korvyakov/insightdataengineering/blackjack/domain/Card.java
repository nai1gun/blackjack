package com.korvyakov.insightdataengineering.blackjack.domain;

/**
 * @author nailgun
 * @since 13.07.14
 */
public class Card {

    private Value value;

    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        if (value != card.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    public static enum Suit {

        CLUBS("♣", "c", "default"), DIAMONDS("♦", "d", "red"), HEARTS("♥", "h", "red"), SPADES("♠", "s", "default");

        private final String symbol;

	    private final String alternativeSymbol;

        private final String color;

        private Suit(String symbol, String alternativeSymbol, String color) {
            this.symbol = symbol;
	        this.alternativeSymbol = alternativeSymbol;
            this.color = color;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getColor() {
            return color;
        }

	    public String getAlternativeSymbol() {
		    return alternativeSymbol;
	    }
    }

    public static enum Value {

        ACE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
        NINE("9", 9), TEN("10", 10), JACK("J", 10), QUEEN("Q", 10), KING("10", 10);

        private final String symbols;

        private final int points;

        private Value(String symbols, int points) {
            this.symbols = symbols;
            this.points = points;
        }

        public String getSymbols() {
            return symbols;
        }

        public int getPoints() {
            return points;
        }
    }

}
