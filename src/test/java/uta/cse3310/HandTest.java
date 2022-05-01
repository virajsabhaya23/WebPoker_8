package uta.cse3310;

import org.junit.*;
import static org.junit.Assert.*;

public class HandTest {

  @Test
  public void isHighCard() {
    final Hand hand_highCard = new Hand();
    final Hand hand_notHighCard = new Hand();

    hand_highCard.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_highCard.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_highCard.cards.add(new Card(Card.Suit.CLUBS, Card.Value.THREE));
    hand_highCard.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
    hand_highCard.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));

    hand_notHighCard.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_notHighCard.cards.add(new Card(Card.Suit.SPADES, Card.Value.SIX));
    hand_notHighCard.cards.add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
    hand_notHighCard.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
    hand_notHighCard.cards.add(new Card(Card.Suit.SPADES, Card.Value.SEVEN));

    hand_highCard.getRanking();
    assertEquals(10, hand_highCard.ranking);
    hand_notHighCard.getRanking();
    assertNotEquals(10, hand_notHighCard.ranking);
  }

  @Test
  public void isOnePair() {
    final Hand hand_onePair = new Hand();
    final Hand hand_notOnePair = new Hand();

    hand_onePair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_onePair.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_onePair.cards.add(new Card(Card.Suit.CLUBS, Card.Value.KING));
    hand_onePair.cards.add(new Card(Card.Suit.SPADES, Card.Value.QUEEN));
    hand_onePair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_notOnePair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_notOnePair.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_notOnePair.cards.add(new Card(Card.Suit.CLUBS, Card.Value.KING));
    hand_notOnePair.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_notOnePair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_onePair.getRanking();
    hand_notOnePair.getRanking();
    assertEquals(9, hand_onePair.ranking);
    assertNotEquals(9, hand_notOnePair.ranking);
  }

  @Test
  public void isTwoPair() {
    final Hand hand_twoPair = new Hand();
    final Hand hand_notTwoPair = new Hand();

    hand_twoPair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_twoPair.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_twoPair.cards.add(new Card(Card.Suit.CLUBS, Card.Value.KING));
    hand_twoPair.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_twoPair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_notTwoPair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_notTwoPair.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_notTwoPair.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_notTwoPair.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_notTwoPair.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_twoPair.getRanking();
    assertEquals(8, hand_twoPair.ranking);
    hand_notTwoPair.getRanking();
    assertNotEquals(8, hand_notTwoPair.ranking);
  }

  @Test
  public void isThreeOfAKind() {
    final Hand hand_threeOfAKind = new Hand();
    final Hand hand_notThreeOfAKind = new Hand();

    hand_threeOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_threeOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));

    hand_notThreeOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_notThreeOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_notThreeOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_notThreeOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_notThreeOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.KING));

    hand_threeOfAKind.getRanking();
    assertEquals(7, hand_threeOfAKind.ranking);
    hand_notThreeOfAKind.getRanking();
    assertNotEquals(7, hand_notThreeOfAKind.ranking);
  }

  @Test
  public void isStraight() {
    final Hand hand_straight = new Hand();
    final Hand hand_notStraight = new Hand();

    hand_straight.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.SIX));
    hand_straight.cards.add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
    hand_straight.cards.add(new Card(Card.Suit.SPADES, Card.Value.SEVEN));

    hand_notStraight.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.NINE));
    hand_notStraight.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_notStraight.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FIVE));
    hand_notStraight.cards.add(new Card(Card.Suit.CLUBS, Card.Value.KING));
    hand_notStraight.cards.add(new Card(Card.Suit.SPADES, Card.Value.KING));

    hand_straight.getRanking();
    hand_notStraight.getRanking();
    assertEquals(6, hand_straight.ranking);
    assertNotEquals(6, hand_notStraight.ranking);
  }

  @Test
  public void isFlush() {
    final Hand hand_flush = new Hand();
    final Hand hand_notFlush = new Hand();

    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
    hand_flush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.TWO));

    hand_notFlush.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
    hand_notFlush.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FOUR));
    hand_notFlush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
    hand_notFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
    hand_notFlush.cards.add(new Card(Card.Suit.CLUBS, Card.Value.TWO));

    hand_flush.getRanking();
    assertEquals(5, hand_flush.ranking);
    assertNotEquals(5, hand_notFlush.ranking);
  }

  @Test
  public void isFullHouse() {
    final Hand hand_fullHouse = new Hand();
    final Hand hand_notFullHouse = new Hand();

    hand_fullHouse.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
    hand_fullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_fullHouse.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
    hand_fullHouse.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
    hand_fullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.KING));

    hand_notFullHouse.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_notFullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.SIX));
    hand_notFullHouse.cards.add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
    hand_notFullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
    hand_notFullHouse.cards.add(new Card(Card.Suit.SPADES, Card.Value.SEVEN));

    hand_fullHouse.getRanking();
    hand_notFullHouse.getRanking();
    assertEquals(4, hand_fullHouse.ranking);
    assertNotEquals(4, hand_notFullHouse.ranking);
  }

  @Test
  public void isFourOfAKind() {
    final Hand hand_fourOfAKind = new Hand();
    final Hand hand_notFourOfAKind = new Hand();

    hand_fourOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
    hand_fourOfAKind.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));

    hand_notFourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
    hand_notFourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
    hand_notFourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
    hand_notFourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
    hand_notFourOfAKind.cards.add(new Card(Card.Suit.CLUBS, Card.Value.TWO));

    hand_fourOfAKind.getRanking();
    hand_notFourOfAKind.getRanking();
    assertEquals(3, hand_fourOfAKind.ranking);
    assertNotEquals(3, hand_notFourOfAKind.ranking);
  }

  @Test
  public void isStraightFlush() {
    final Hand hand_straightFlush = new Hand();
    final Hand hand_notStraightFlush = new Hand();

    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.QUEEN));
    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.JACK));
    hand_straightFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.TEN));
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
    final Hand hand_notRoyalFlush = new Hand();

    hand_royalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.JACK));
    hand_royalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.ACE));
    hand_royalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.KING));
    hand_royalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.TEN));
    hand_royalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.QUEEN));

    hand_notRoyalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.QUEEN));
    hand_notRoyalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.JACK));
    hand_notRoyalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.TEN));
    hand_notRoyalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.NINE));
    hand_notRoyalFlush.cards.add(new Card(Card.Suit.SPADES, Card.Value.EIGHT));

    hand_royalFlush.getRanking();
    assertEquals(1, hand_royalFlush.ranking);
    hand_notRoyalFlush.getRanking();
    assertNotEquals(1, hand_notRoyalFlush.ranking);
  }

}
