package uta.cse3310;
import java.util.*;

public class Card {
    public enum Suite {
        HEARTS, CLUBS, DIAMONDS, SPADES
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        TEN, JACK, QUEEN, KING
    }

    public Suite suite;
    public Value value;

    public Card(){

    }
    // public Card(Suit suit, Value value) {
    //     this.suit = suit;
    //     this.value = value;
    // }

    // public Suit getSuit() {
    //     return suit;
    // }

    // public Value getValue() {
    //     return value;
    // }

    // public String toString() {
    //     return suit + " " + value;
    // }
}
