package uta.cse3310;

import uta.cse3310.Card;
import uta.cse3310.Hand;
import java.util.*;

public class Deck {
   public Card[] cards = new Card[52];

   public Deck() {
      cards[0] = new Card();
      cards[1] = new Card();
      cards[2] = new Card();
      cards[3] = new Card();
      cards[4] = new Card();
      cards[5] = new Card();
      cards[6] = new Card();
      cards[7] = new Card();
      cards[8] = new Card();
      cards[9] = new Card();
      cards[10] = new Card();
      cards[11] = new Card();
      cards[12] = new Card();
      cards[13] = new Card();
      cards[14] = new Card();
      cards[15] = new Card();
      cards[16] = new Card();
      cards[17] = new Card();
      cards[18] = new Card();
      cards[19] = new Card();
      cards[20] = new Card();
      cards[21] = new Card();
      cards[22] = new Card();
      cards[23] = new Card();
      cards[24] = new Card();
      cards[25] = new Card();
      cards[26] = new Card();
      cards[27] = new Card();
      cards[28] = new Card();
      cards[29] = new Card();
      cards[30] = new Card();
      cards[31] = new Card();
      cards[32] = new Card();
      cards[33] = new Card();
      cards[34] = new Card();
      cards[35] = new Card();
      cards[36] = new Card();
      cards[37] = new Card();
      cards[38] = new Card();
      cards[39] = new Card();
      cards[40] = new Card();
      cards[41] = new Card();
      cards[42] = new Card();
      cards[43] = new Card();
      cards[44] = new Card();
      cards[45] = new Card();
      cards[46] = new Card();
      cards[47] = new Card();
      cards[48] = new Card();
      cards[49] = new Card();
      cards[50] = new Card();
      cards[51] = new Card();
      cards[0].value = Card.Value.valueOf("TWO");
      cards[0].suite = Card.Suite.valueOf("SPADES");
      cards[1].value = Card.Value.valueOf("TWO");
      cards[1].suite = Card.Suite.valueOf("HEARTS");
      cards[2].value = Card.Value.valueOf("TWO");
      cards[2].suite = Card.Suite.valueOf("CLUBS");
      cards[3].value = Card.Value.valueOf("TWO");
      cards[3].suite = Card.Suite.valueOf("DIAMONDS");
      cards[4].value = Card.Value.valueOf("THREE");
      cards[4].suite = Card.Suite.valueOf("SPADES");
      cards[5].value = Card.Value.valueOf("THREE");
      cards[5].suite = Card.Suite.valueOf("HEARTS");
      cards[6].value = Card.Value.valueOf("THREE");
      cards[6].suite = Card.Suite.valueOf("CLUBS");
      cards[7].value = Card.Value.valueOf("THREE");
      cards[7].suite = Card.Suite.valueOf("DIAMONDS");
      cards[8].value = Card.Value.valueOf("FOUR");
      cards[8].suite = Card.Suite.valueOf("SPADES");
      cards[9].value = Card.Value.valueOf("FOUR");
      cards[9].suite = Card.Suite.valueOf("HEARTS");
      cards[10].value = Card.Value.valueOf("FOUR");
      cards[10].suite = Card.Suite.valueOf("CLUBS");
      cards[11].value = Card.Value.valueOf("FOUR");
      cards[11].suite = Card.Suite.valueOf("DIAMONDS");
      cards[12].value = Card.Value.valueOf("FIVE");
      cards[12].suite = Card.Suite.valueOf("SPADES");
      cards[13].value = Card.Value.valueOf("FIVE");
      cards[13].suite = Card.Suite.valueOf("HEARTS");
      cards[14].value = Card.Value.valueOf("FIVE");
      cards[14].suite = Card.Suite.valueOf("CLUBS");
      cards[15].value = Card.Value.valueOf("FIVE");
      cards[15].suite = Card.Suite.valueOf("DIAMONDS");
      cards[16].value = Card.Value.valueOf("SIX");
      cards[16].suite = Card.Suite.valueOf("SPADES");
      cards[17].value = Card.Value.valueOf("SIX");
      cards[17].suite = Card.Suite.valueOf("HEARTS");
      cards[18].value = Card.Value.valueOf("SIX");
      cards[18].suite = Card.Suite.valueOf("CLUBS");
      cards[19].value = Card.Value.valueOf("SIX");
      cards[19].suite = Card.Suite.valueOf("DIAMONDS");
      cards[20].value = Card.Value.valueOf("SEVEN");
      cards[20].suite = Card.Suite.valueOf("SPADES");
      cards[21].value = Card.Value.valueOf("SEVEN");
      cards[21].suite = Card.Suite.valueOf("HEARTS");
      cards[22].value = Card.Value.valueOf("SEVEN");
      cards[22].suite = Card.Suite.valueOf("CLUBS");
      cards[23].value = Card.Value.valueOf("SEVEN");
      cards[23].suite = Card.Suite.valueOf("DIAMONDS");
      cards[24].value = Card.Value.valueOf("EIGHT");
      cards[24].suite = Card.Suite.valueOf("SPADES");
      cards[25].value = Card.Value.valueOf("EIGHT");
      cards[25].suite = Card.Suite.valueOf("HEARTS");
      cards[26].value = Card.Value.valueOf("EIGHT");
      cards[26].suite = Card.Suite.valueOf("CLUBS");
      cards[27].value = Card.Value.valueOf("EIGHT");
      cards[27].suite = Card.Suite.valueOf("DIAMONDS");
      cards[28].value = Card.Value.valueOf("NINE");
      cards[28].suite = Card.Suite.valueOf("SPADES");
      cards[29].value = Card.Value.valueOf("NINE");
      cards[29].suite = Card.Suite.valueOf("HEARTS");
      cards[30].value = Card.Value.valueOf("NINE");
      cards[30].suite = Card.Suite.valueOf("CLUBS");
      cards[31].value = Card.Value.valueOf("NINE");
      cards[31].suite = Card.Suite.valueOf("DIAMONDS");
      cards[32].value = Card.Value.valueOf("TEN");
      cards[32].suite = Card.Suite.valueOf("SPADES");
      cards[33].value = Card.Value.valueOf("TEN");
      cards[33].suite = Card.Suite.valueOf("HEARTS");
      cards[34].value = Card.Value.valueOf("TEN");
      cards[34].suite = Card.Suite.valueOf("CLUBS");
      cards[35].value = Card.Value.valueOf("TEN");
      cards[35].suite = Card.Suite.valueOf("DIAMONDS");
      cards[36].value = Card.Value.valueOf("JACK");
      cards[36].suite = Card.Suite.valueOf("SPADES");
      cards[37].value = Card.Value.valueOf("JACK");
      cards[37].suite = Card.Suite.valueOf("HEARTS");
      cards[38].value = Card.Value.valueOf("JACK");
      cards[38].suite = Card.Suite.valueOf("CLUBS");
      cards[39].value = Card.Value.valueOf("JACK");
      cards[39].suite = Card.Suite.valueOf("DIAMONDS");
      cards[40].value = Card.Value.valueOf("QUEEN");
      cards[40].suite = Card.Suite.valueOf("SPADES");
      cards[41].value = Card.Value.valueOf("QUEEN");
      cards[41].suite = Card.Suite.valueOf("HEARTS");
      cards[42].value = Card.Value.valueOf("QUEEN");
      cards[42].suite = Card.Suite.valueOf("CLUBS");
      cards[43].value = Card.Value.valueOf("QUEEN");
      cards[43].suite = Card.Suite.valueOf("DIAMONDS");
      cards[44].value = Card.Value.valueOf("KING");
      cards[44].suite = Card.Suite.valueOf("SPADES");
      cards[45].value = Card.Value.valueOf("KING");
      cards[45].suite = Card.Suite.valueOf("HEARTS");
      cards[46].value = Card.Value.valueOf("KING");
      cards[46].suite = Card.Suite.valueOf("CLUBS");
      cards[47].value = Card.Value.valueOf("KING");
      cards[47].suite = Card.Suite.valueOf("DIAMONDS");
      cards[48].value = Card.Value.valueOf("ACE");
      cards[48].suite = Card.Suite.valueOf("SPADES");
      cards[49].value = Card.Value.valueOf("ACE");
      cards[49].suite = Card.Suite.valueOf("HEARTS");
      cards[50].value = Card.Value.valueOf("ACE");
      cards[50].suite = Card.Suite.valueOf("CLUBS");
      cards[51].value = Card.Value.valueOf("ACE");
      cards[51].suite = Card.Suite.valueOf("DIAMONDS");

      Random rand = new Random();
      int j;
      Card[] temp = new Card[1];
      for (int i = 0; i < 52; i++) {
         j = rand.nextInt(52);
         temp[0] = cards[i];
         cards[i] = cards[j];
         cards[j] = temp[0];
      }
      System.out.println(Arrays.toString(cards));
   }

   // public Card[] initialize() {

   // return cards;
   // }

   // public void shuffle() {
   // for (int i = cards.length - 1; i > 0; i--) {

   // Random rand = new Random();

   // int j = rand.nextInt(i + 1);
   // Card tmp = cards[j];
   // cards[j] = cards[i];
   // cards[i] = tmp;
   // }
   // }
}
