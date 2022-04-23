package uta.cse3310;

import org.junit.*;

public class DeckTest {

  @Test
  public void isRandom() {
    Deck deck_from_Deck = Deck.randomize();
    Deck copy_of_unshuffled_deck = new Deck();

    assert false == deck_from_Deck.equals(copy_of_unshuffled_deck);
  }
}
