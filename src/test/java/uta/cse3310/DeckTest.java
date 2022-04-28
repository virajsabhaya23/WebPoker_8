package uta.cse3310;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {
  @Test
  public void constructorTest() {
    final Deck deck = new Deck();
    assertEquals(52, deck.deck.size());
  }

  @Test
  public void isRandom() {
    Deck shuffledDeck = new Deck();
    Deck unshuffledDeck = new Deck();

    assertNotEquals(unshuffledDeck, shuffledDeck.randomize());
  }
}
