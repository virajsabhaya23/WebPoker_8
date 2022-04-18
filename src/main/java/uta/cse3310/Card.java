package uta.cse3310;

public class Card {
    public enum Suite {
        HEARTS, CLUBS, DIAMONDS, SPADES
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        TEN, JACK, QUEEN, KING, ACE
    }

    public Suite suite;
    public Value value;

    public boolean flag = false;
    // public int ranking;
    // public int highCard;

    public Card() {
    }
}
