package uta.cse3310;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HandTest {

  @Test
  public void isStraight() {
    final Hand hand_straight = new Hand();

    hand_straight.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.SIX));
    hand_straight.cards.add(new Card(Card.Suit.CLUBS, Card.Value.THREE));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.FOUR));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.SEVEN));

    hand_straight.getRanking();
    assertEquals(6, hand_straight.ranking);
  }

  @Test
  public void isFourOfAKind() {
    final Hand hand_straight = new Hand();

    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.FIVE));
    hand_straight.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_straight.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FIVE));
    hand_straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));

    hand_straight.getRanking();
    assertEquals(3, hand_straight.ranking);
  }


}
