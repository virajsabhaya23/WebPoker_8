package uta.cse3310;

import org.junit.*;
import static org.junit.Assert.*;

public class HandTest {

//  @Test
//  public void isHighCard() {
//    final Hand hand_highCard = new Hand();
//
//    hand_highCard.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
//    hand_highCard.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
//    hand_highCard.cards.add(new Card(Card.Suit.CLUBS, Card.Value.THREE));
//    hand_highCard.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
//    hand_highCard.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
//
//    hand_highCard.getRanking();
//    assertEquals(10, hand_highCard.ranking);
//  }

  @Test
  public void isOnePair() {
    final Hand hand_onePair = new Hand();

    hand_onePair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_onePair.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_onePair.cards.add(new Card(Card.Suit.CLUBS, Card.Value.KING));
    hand_onePair.cards.add(new Card(Card.Suit.SPADES, Card.Value.QUEEN));
    hand_onePair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_onePair.getRanking();
    assertEquals(9, hand_onePair.ranking);
    System.out.println("hi");
  }

  @Test
  public void isTwoPair() {
    final Hand hand_twoPair = new Hand();

    hand_twoPair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_twoPair.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_twoPair.cards.add(new Card(Card.Suit.CLUBS, Card.Value.KING));
    hand_twoPair.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_twoPair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_twoPair.getRanking();
    assertEquals(8, hand_twoPair.ranking);
  }

  @Test
  public void isThreeOfAKind() {
    final Hand hand_threeOfAKind = new Hand();

    hand_threeOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_threeOfAKind.getRanking();
    assertEquals(7, hand_threeOfAKind.ranking);
  }

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
  public void isFlush() {
    final Hand hand_flush = new Hand();

    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.TWO));

    hand_flush.getRanking();
    assertEquals(5, hand_flush.ranking);
  }

  @Test
  public void isFullHouse() {
    final Hand hand_fullHouse = new Hand();

    hand_fullHouse.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_fullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_fullHouse.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_fullHouse.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_fullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.KING));

    hand_fullHouse.getRanking();
    assertEquals(4, hand_fullHouse.ranking);
  }

  @Test
  public void isFourOfAKind() {
    final Hand hand_fourOfAKind = new Hand();

    hand_fourOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));

    hand_fourOfAKind.getRanking();
    assertEquals(3, hand_fourOfAKind.ranking);
  }

  @Test
  public void isStraightFlush() {
    final Hand hand_straightFlush = new Hand();
    final Hand hand_notStraightFlush = new Hand();

    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.QUEEN));
    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.JACK));
    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.TWO));
    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.EIGHT));

    hand_notStraightFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_notStraightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_notStraightFlush.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_notStraightFlush.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_notStraightFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_straightFlush.getRanking();
    hand_notStraightFlush.getRanking();
    assertEquals(2, hand_straightFlush.ranking);
    assertNotEquals(2, hand_notStraightFlush.ranking);
  }

  @Test
  public void isRoyalFlush() {
    final Hand hand_royalFlush = new Hand();

    hand_royalFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_royalFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.KING));
    hand_royalFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.QUEEN));
    hand_royalFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
    hand_royalFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.THREE));

    hand_royalFlush.getRanking();
    assertEquals(1, hand_royalFlush.ranking);
  }

}
