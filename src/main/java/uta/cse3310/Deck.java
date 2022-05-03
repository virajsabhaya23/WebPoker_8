package uta.cse3310;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  public ArrayList<Card> deck;

  public Deck() {
    this.deck = new ArrayList<>();

    for (Card.Suit suit : Card.Suit.values()) {
      for (Card.Value value : Card.Value.values()) {
        deck.add(new Card(suit, value));
      }
    }
    Collections.shuffle(deck);
  }

  public void swapHand(int playerID) {
    // TODO: Swap the hand that is passed in
  }

}
