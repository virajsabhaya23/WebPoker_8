package uta.cse3310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dealer {
  public ArrayList<Card> deck;

  /**
   * Dealer is created with a new shuffled deck. This should only be called once, at the beginning
   * of the Game.
   */
  public Dealer() {
    this.deck = new ArrayList<>();

    for (Card.Suit suit : Card.Suit.values()) {
      for (Card.Value value : Card.Value.values()) {
        deck.add(new Card(suit, value));
      }
    }
    Collections.shuffle(deck);
  }

  /**
   * Deals a hand to a player.
   *
   * @return Hand with 5 random cards.
   */
  public Hand deal() {
    Hand hand = new Hand();
    for (int i = 0; i < 5; i++) {
      Random rand = new Random();
      int random = rand.nextInt(deck.size());
      hand.cards.add(deck.get(random));
      deck.remove(random);
    }
    return hand;
  }

  public void swapHand(Hand playerHand) {
    // TODO: Swap the hand that is passed in
  }
}
