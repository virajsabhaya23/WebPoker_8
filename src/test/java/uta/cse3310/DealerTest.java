package uta.cse3310;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
  @Test
  public void constructorTest() {
    final Dealer dealer = new Dealer();

    assertEquals(52, dealer.deck.size());
  }

  @Test
  public void deal() {
    final Dealer dealer = new Dealer();
    Player player = new Player();
    player.hand = dealer.deal();

    assertEquals(5, player.hand.cards.size());
  }
}
