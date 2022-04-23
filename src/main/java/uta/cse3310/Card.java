package uta.cse3310;

public class Card {
    public enum Suit {
        HEARTS, CLUBS, DIAMONDS, SPADES
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        TEN, JACK, QUEEN, KING, ACE
    }

    public Suit suit;
    public Value value;

    public boolean delt = false;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
}
