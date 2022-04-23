package uta.cse3310;

import java.util.*;

import uta.cse3310.Card.Suit;
import uta.cse3310.Card.Value;

public class Deck {
   public Card[] cards = new Card[52];

   public Deck() {

      // for (int i = 0; i < 52; i++) {
      // cards[i] = new Card();
      // }

      // TODO: Dynamically create a full Deck
      Card.Value.values();
      // for(DATATYPE VAR : ARRAY)
      for (Suit suit : Card.Suit.values()) {
         for (Value value : Card.Value.values()) {
            this.add(new Card(suit, value));
         }
      }

      // for (Suit suit : Suit.values()) {
      // for (Rank rank : Rank.values()) {
      // deck.add(new Card(suit, rank));
      // }
      // }

      // TWOS
      cards[0].value = Card.Value.valueOf("TWO");
      cards[0].suit = Card.Suit.valueOf("SPADES");

      cards[1].value = Card.Value.valueOf("TWO");
      cards[1].suit = Card.Suit.valueOf("HEARTS");

      cards[2].value = Card.Value.valueOf("TWO");
      cards[2].suit = Card.Suit.valueOf("CLUBS");

      cards[3].value = Card.Value.valueOf("TWO");
      cards[3].suit = Card.Suit.valueOf("DIAMONDS");

      // THREES
      cards[4].value = Card.Value.valueOf("THREE");
      cards[4].suit = Card.Suit.valueOf("SPADES");

      cards[5].value = Card.Value.valueOf("THREE");
      cards[5].suit = Card.Suit.valueOf("HEARTS");

      cards[6].value = Card.Value.valueOf("THREE");
      cards[6].suit = Card.Suit.valueOf("CLUBS");

      cards[7].value = Card.Value.valueOf("THREE");
      cards[7].suit = Card.Suit.valueOf("DIAMONDS");

      // FOURS
      cards[8].value = Card.Value.valueOf("FOUR");
      cards[8].suit = Card.Suit.valueOf("SPADES");

      cards[9].value = Card.Value.valueOf("FOUR");
      cards[9].suit = Card.Suit.valueOf("HEARTS");

      cards[10].value = Card.Value.valueOf("FOUR");
      cards[10].suit = Card.Suit.valueOf("CLUBS");

      cards[11].value = Card.Value.valueOf("FOUR");
      cards[11].suit = Card.Suit.valueOf("DIAMONDS");

      // FIVES
      cards[12].value = Card.Value.valueOf("FIVE");
      cards[12].suit = Card.Suit.valueOf("SPADES");

      cards[13].value = Card.Value.valueOf("FIVE");
      cards[13].suit = Card.Suit.valueOf("HEARTS");

      cards[14].value = Card.Value.valueOf("FIVE");
      cards[14].suit = Card.Suit.valueOf("CLUBS");

      cards[15].value = Card.Value.valueOf("FIVE");
      cards[15].suit = Card.Suit.valueOf("DIAMONDS");

      // SIXES
      cards[16].value = Card.Value.valueOf("SIX");
      cards[16].suit = Card.Suit.valueOf("SPADES");

      cards[17].value = Card.Value.valueOf("SIX");
      cards[17].suit = Card.Suit.valueOf("HEARTS");

      cards[18].value = Card.Value.valueOf("SIX");
      cards[18].suit = Card.Suit.valueOf("CLUBS");

      cards[19].value = Card.Value.valueOf("SIX");
      cards[19].suit = Card.Suit.valueOf("DIAMONDS");

      // SEVENS
      cards[20].value = Card.Value.valueOf("SEVEN");
      cards[20].suit = Card.Suit.valueOf("SPADES");

      cards[21].value = Card.Value.valueOf("SEVEN");
      cards[21].suit = Card.Suit.valueOf("HEARTS");

      cards[22].value = Card.Value.valueOf("SEVEN");
      cards[22].suit = Card.Suit.valueOf("CLUBS");

      cards[23].value = Card.Value.valueOf("SEVEN");
      cards[23].suit = Card.Suit.valueOf("DIAMONDS");

      // EIGHTS
      cards[24].value = Card.Value.valueOf("EIGHT");
      cards[24].suit = Card.Suit.valueOf("SPADES");

      cards[25].value = Card.Value.valueOf("EIGHT");
      cards[25].suit = Card.Suit.valueOf("HEARTS");

      cards[26].value = Card.Value.valueOf("EIGHT");
      cards[26].suit = Card.Suit.valueOf("CLUBS");

      cards[27].value = Card.Value.valueOf("EIGHT");
      cards[27].suit = Card.Suit.valueOf("DIAMONDS");

      // NINES
      cards[28].value = Card.Value.valueOf("NINE");
      cards[28].suit = Card.Suit.valueOf("SPADES");

      cards[29].value = Card.Value.valueOf("NINE");
      cards[29].suit = Card.Suit.valueOf("HEARTS");

      cards[30].value = Card.Value.valueOf("NINE");
      cards[30].suit = Card.Suit.valueOf("CLUBS");

      cards[31].value = Card.Value.valueOf("NINE");
      cards[31].suit = Card.Suit.valueOf("DIAMONDS");

      // TENS
      cards[32].value = Card.Value.valueOf("TEN");
      cards[32].suit = Card.Suit.valueOf("SPADES");

      cards[33].value = Card.Value.valueOf("TEN");
      cards[33].suit = Card.Suit.valueOf("HEARTS");

      cards[34].value = Card.Value.valueOf("TEN");
      cards[34].suit = Card.Suit.valueOf("CLUBS");

      cards[35].value = Card.Value.valueOf("TEN");
      cards[35].suit = Card.Suit.valueOf("DIAMONDS");

      // JACKS
      cards[36].value = Card.Value.valueOf("JACK");
      cards[36].suit = Card.Suit.valueOf("SPADES");

      cards[37].value = Card.Value.valueOf("JACK");
      cards[37].suit = Card.Suit.valueOf("HEARTS");

      cards[38].value = Card.Value.valueOf("JACK");
      cards[38].suit = Card.Suit.valueOf("CLUBS");

      cards[39].value = Card.Value.valueOf("JACK");
      cards[39].suit = Card.Suit.valueOf("DIAMONDS");

      // QUEENS
      cards[40].value = Card.Value.valueOf("QUEEN");
      cards[40].suit = Card.Suit.valueOf("SPADES");

      cards[41].value = Card.Value.valueOf("QUEEN");
      cards[41].suit = Card.Suit.valueOf("HEARTS");

      cards[42].value = Card.Value.valueOf("QUEEN");
      cards[42].suit = Card.Suit.valueOf("CLUBS");

      cards[43].value = Card.Value.valueOf("QUEEN");
      cards[43].suit = Card.Suit.valueOf("DIAMONDS");

      // KINGS
      cards[44].value = Card.Value.valueOf("KING");
      cards[44].suit = Card.Suit.valueOf("SPADES");

      cards[45].value = Card.Value.valueOf("KING");
      cards[45].suit = Card.Suit.valueOf("HEARTS");

      cards[46].value = Card.Value.valueOf("KING");
      cards[46].suit = Card.Suit.valueOf("CLUBS");

      cards[47].value = Card.Value.valueOf("KING");
      cards[47].suit = Card.Suit.valueOf("DIAMONDS");

      // ACES
      cards[48].value = Card.Value.valueOf("ACE");
      cards[48].suit = Card.Suit.valueOf("SPADES");

      cards[49].value = Card.Value.valueOf("ACE");
      cards[49].suit = Card.Suit.valueOf("HEARTS");

      cards[50].value = Card.Value.valueOf("ACE");
      cards[50].suit = Card.Suit.valueOf("CLUBS");

      cards[51].value = Card.Value.valueOf("ACE");
      cards[51].suit = Card.Suit.valueOf("DIAMONDS");
   }

   public static Deck randomize() {
      Deck deck = new Deck();
      Deck temp = new Deck();
      Random rand = new Random();

      for (int i = 0; i < 52; i++) {
         int randidx = rand.nextInt(52);
         if (temp.cards[randidx].delt == false) {
            deck.cards[i] = temp.cards[randidx];
            System.out.println(deck.cards[i].value + "-" + deck.cards[i].suit);
            temp.cards[randidx].delt = true;
         } else {
            i = i - 1;
         }
      }
      return deck;
   }
}
