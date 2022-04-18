package uta.cse3310;

import uta.cse3310.Card;
import uta.cse3310.Hand;
import java.util.*;

public class Deck {
   public Card[] cards = new Card[52];
   public int ranking;
   public int highCard;

   public Deck() {

      for (int i = 0; i < 52; i++) {
         cards[i] = new Card();
      }
      // TWOS
      cards[0].value = Card.Value.valueOf("TWO");
      cards[0].suite = Card.Suite.valueOf("SPADES");

      cards[1].value = Card.Value.valueOf("TWO");
      cards[1].suite = Card.Suite.valueOf("HEARTS");

      cards[2].value = Card.Value.valueOf("TWO");
      cards[2].suite = Card.Suite.valueOf("CLUBS");

      cards[3].value = Card.Value.valueOf("TWO");
      cards[3].suite = Card.Suite.valueOf("DIAMONDS");

      // THREES
      cards[4].value = Card.Value.valueOf("THREE");
      cards[4].suite = Card.Suite.valueOf("SPADES");

      cards[5].value = Card.Value.valueOf("THREE");
      cards[5].suite = Card.Suite.valueOf("HEARTS");

      cards[6].value = Card.Value.valueOf("THREE");
      cards[6].suite = Card.Suite.valueOf("CLUBS");

      cards[7].value = Card.Value.valueOf("THREE");
      cards[7].suite = Card.Suite.valueOf("DIAMONDS");

      // FOURS
      cards[8].value = Card.Value.valueOf("FOUR");
      cards[8].suite = Card.Suite.valueOf("SPADES");

      cards[9].value = Card.Value.valueOf("FOUR");
      cards[9].suite = Card.Suite.valueOf("HEARTS");

      cards[10].value = Card.Value.valueOf("FOUR");
      cards[10].suite = Card.Suite.valueOf("CLUBS");

      cards[11].value = Card.Value.valueOf("FOUR");
      cards[11].suite = Card.Suite.valueOf("DIAMONDS");

      // FIVES
      cards[12].value = Card.Value.valueOf("FIVE");
      cards[12].suite = Card.Suite.valueOf("SPADES");

      cards[13].value = Card.Value.valueOf("FIVE");
      cards[13].suite = Card.Suite.valueOf("HEARTS");

      cards[14].value = Card.Value.valueOf("FIVE");
      cards[14].suite = Card.Suite.valueOf("CLUBS");

      cards[15].value = Card.Value.valueOf("FIVE");
      cards[15].suite = Card.Suite.valueOf("DIAMONDS");

      // SIXES
      cards[16].value = Card.Value.valueOf("SIX");
      cards[16].suite = Card.Suite.valueOf("SPADES");

      cards[17].value = Card.Value.valueOf("SIX");
      cards[17].suite = Card.Suite.valueOf("HEARTS");

      cards[18].value = Card.Value.valueOf("SIX");
      cards[18].suite = Card.Suite.valueOf("CLUBS");

      cards[19].value = Card.Value.valueOf("SIX");
      cards[19].suite = Card.Suite.valueOf("DIAMONDS");

      // SEVENS
      cards[20].value = Card.Value.valueOf("SEVEN");
      cards[20].suite = Card.Suite.valueOf("SPADES");

      cards[21].value = Card.Value.valueOf("SEVEN");
      cards[21].suite = Card.Suite.valueOf("HEARTS");

      cards[22].value = Card.Value.valueOf("SEVEN");
      cards[22].suite = Card.Suite.valueOf("CLUBS");

      cards[23].value = Card.Value.valueOf("SEVEN");
      cards[23].suite = Card.Suite.valueOf("DIAMONDS");

      // EIGHTS
      cards[24].value = Card.Value.valueOf("EIGHT");
      cards[24].suite = Card.Suite.valueOf("SPADES");

      cards[25].value = Card.Value.valueOf("EIGHT");
      cards[25].suite = Card.Suite.valueOf("HEARTS");

      cards[26].value = Card.Value.valueOf("EIGHT");
      cards[26].suite = Card.Suite.valueOf("CLUBS");

      cards[27].value = Card.Value.valueOf("EIGHT");
      cards[27].suite = Card.Suite.valueOf("DIAMONDS");

      // NINES
      cards[28].value = Card.Value.valueOf("NINE");
      cards[28].suite = Card.Suite.valueOf("SPADES");

      cards[29].value = Card.Value.valueOf("NINE");
      cards[29].suite = Card.Suite.valueOf("HEARTS");

      cards[30].value = Card.Value.valueOf("NINE");
      cards[30].suite = Card.Suite.valueOf("CLUBS");

      cards[31].value = Card.Value.valueOf("NINE");
      cards[31].suite = Card.Suite.valueOf("DIAMONDS");

      // TENS
      cards[32].value = Card.Value.valueOf("TEN");
      cards[32].suite = Card.Suite.valueOf("SPADES");

      cards[33].value = Card.Value.valueOf("TEN");
      cards[33].suite = Card.Suite.valueOf("HEARTS");

      cards[34].value = Card.Value.valueOf("TEN");
      cards[34].suite = Card.Suite.valueOf("CLUBS");

      cards[35].value = Card.Value.valueOf("TEN");
      cards[35].suite = Card.Suite.valueOf("DIAMONDS");

      // JACKS
      cards[36].value = Card.Value.valueOf("JACK");
      cards[36].suite = Card.Suite.valueOf("SPADES");

      cards[37].value = Card.Value.valueOf("JACK");
      cards[37].suite = Card.Suite.valueOf("HEARTS");

      cards[38].value = Card.Value.valueOf("JACK");
      cards[38].suite = Card.Suite.valueOf("CLUBS");

      cards[39].value = Card.Value.valueOf("JACK");
      cards[39].suite = Card.Suite.valueOf("DIAMONDS");

      // QUEENS
      cards[40].value = Card.Value.valueOf("QUEEN");
      cards[40].suite = Card.Suite.valueOf("SPADES");

      cards[41].value = Card.Value.valueOf("QUEEN");
      cards[41].suite = Card.Suite.valueOf("HEARTS");

      cards[42].value = Card.Value.valueOf("QUEEN");
      cards[42].suite = Card.Suite.valueOf("CLUBS");

      cards[43].value = Card.Value.valueOf("QUEEN");
      cards[43].suite = Card.Suite.valueOf("DIAMONDS");

      // KINGS
      cards[44].value = Card.Value.valueOf("KING");
      cards[44].suite = Card.Suite.valueOf("SPADES");

      cards[45].value = Card.Value.valueOf("KING");
      cards[45].suite = Card.Suite.valueOf("HEARTS");

      cards[46].value = Card.Value.valueOf("KING");
      cards[46].suite = Card.Suite.valueOf("CLUBS");

      cards[47].value = Card.Value.valueOf("KING");
      cards[47].suite = Card.Suite.valueOf("DIAMONDS");

      // ACES
      cards[48].value = Card.Value.valueOf("ACE");
      cards[48].suite = Card.Suite.valueOf("SPADES");

      cards[49].value = Card.Value.valueOf("ACE");
      cards[49].suite = Card.Suite.valueOf("HEARTS");

      cards[50].value = Card.Value.valueOf("ACE");
      cards[50].suite = Card.Suite.valueOf("CLUBS");

      cards[51].value = Card.Value.valueOf("ACE");
      cards[51].suite = Card.Suite.valueOf("DIAMONDS");

      // Random rand = new Random();
      // Card[] temparr = new Card[1];
      // for (int i = 0; i < cards.length; i++) {
      // int randidx = rand.nextInt(cards.length);
      // temparr[0] = cards[i];
      // cards[i] = cards[randidx];
      // cards[randidx] = temparr[0];
      // }

      // int j;
      // Card[] temp = new Card[1];
      // for (int i = 0; i < 52; i++) {
      // j = rand.nextInt(52);
      // temp[0] = cards[i];
      // cards[i] = cards[j];
      // cards[j] = temp[0];
      // }
   }

   public static Deck randomize() {
      Deck temp = new Deck();
      Deck deck = new Deck();
      Random rand = new Random();
      // Card[] temparr = new Card[1];
      // int j = (int) (Math.random() * deck.length);
      for (int i = 0; i < 52; i++) {
         int randidx = rand.nextInt(52);
         if (temp.cards[randidx].flag == false) {
            deck.cards[i] = temp.cards[randidx];
            System.out.println(deck.cards[i].value + "-" + deck.cards[i].suite);
            temp.cards[randidx].flag = true;
         } else {
            i = i - 1;
         }
      }
      return deck;
   }
}
