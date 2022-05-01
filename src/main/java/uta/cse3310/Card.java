package uta.cse3310;

public class Card implements Comparable<Card>{

  public enum Suit {
    HEARTS,
    CLUBS,
    DIAMONDS,
    SPADES
  }

  public enum Value {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE
  }

  public Suit suit;
  public Value value;

  public Card(Suit suit, Value value) {
    this.suit = suit;
    this.value = value;
  }

  public Suit getSuit() {
    return suit;
  }

  public Value getValue() {
    return value;
  }


  @Override
  public int compareTo(Card o) {
    int lastCmp = value.compareTo(o.value);
    return (lastCmp != 0 ? lastCmp : suit.compareTo(o.suit));
  }
}
