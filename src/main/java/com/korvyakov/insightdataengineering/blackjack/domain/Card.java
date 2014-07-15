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

        CLUBS("♣", "black"), DIAMONDS("♦", "red"), HEARTS("♥", "red"), SPADES("♠", "black");

        private String symbol;

        private String color;

        private Suit(String symbol, String color) {
            this.symbol = symbol;
            this.color = color;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static enum Value {

        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10);

        private final int points;

        private Value(int points) {
            this.points = points;
        }

        public int getPoints() {
            return points;
        }
    }

}
