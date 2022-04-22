package uta.cse3310;

import org.junit.*;
import uta.cse3310.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import com.google.gson.Gson;

public class PlayerTest {

  @Test
  public void isStraight() {
    final Hand hand_straight = new Hand();
    hand_straight.cards = new Card[5];
    hand_straight.cards[0] = new Card();
    hand_straight.cards[0].suit = Card.Suit.valueOf("DIAMONDS");
    hand_straight.cards[0].value = Card.Value.valueOf("FIVE");
    hand_straight.cards[1] = new Card();
    hand_straight.cards[1].suit = Card.Suit.valueOf("SPADES");
    hand_straight.cards[1].value = Card.Value.valueOf("SIX");
    hand_straight.cards[2] = new Card();
    hand_straight.cards[2].suit = Card.Suit.valueOf("CLUBS");
    hand_straight.cards[2].value = Card.Value.valueOf("THREE");
    hand_straight.cards[3] = new Card();
    hand_straight.cards[3].suit = Card.Suit.valueOf("SPADES");
    hand_straight.cards[3].value = Card.Value.valueOf("FOUR");
    hand_straight.cards[4] = new Card();
    hand_straight.cards[4].suit = Card.Suit.valueOf("SPADES");
    hand_straight.cards[4].value = Card.Value.valueOf("SEVEN");
    hand_straight.getRanking();
    int Ans1 = 6;
    assertTrue(Ans1 == hand_straight.ranking);
  }

  @Test
  public void isFourOfAKind() {
    final Hand hand_four5s = new Hand();
    hand_four5s.cards = new Card[5];
    hand_four5s.cards[0] = new Card();
    hand_four5s.cards[0].suit = Card.Suit.valueOf("SPADES");
    hand_four5s.cards[0].value = Card.Value.valueOf("FIVE");
    hand_four5s.cards[1] = new Card();
    hand_four5s.cards[1].suit = Card.Suit.valueOf("DIAMONDS");
    hand_four5s.cards[1].value = Card.Value.valueOf("FIVE");
    hand_four5s.cards[2] = new Card();
    hand_four5s.cards[2].suit = Card.Suit.valueOf("CLUBS");
    hand_four5s.cards[2].value = Card.Value.valueOf("FIVE");
    hand_four5s.cards[3] = new Card();
    hand_four5s.cards[3].suit = Card.Suit.valueOf("HEARTS");
    hand_four5s.cards[3].value = Card.Value.valueOf("FIVE");
    hand_four5s.cards[4] = new Card();
    hand_four5s.cards[4].suit = Card.Suit.valueOf("SPADES");
    hand_four5s.cards[4].value = Card.Value.valueOf("ACE");
    hand_four5s.getRanking();
    int Ans1 = 3;
    assertTrue(Ans1 == hand_four5s.ranking);
  }
}

// Testing the Card if you run out of ideas
// Also, remove above line lol
