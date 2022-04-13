package uta.cse3310;

import uta.cse3310.Card;
import uta.cse3310.Hand;
import java.util.*;

public class Deck {
   public Card[] cards = new Card[52];

   public Deck() {

      for(int i = 0; i < 52; i++) { cards[i] = new Card(); }

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
      // for (int i = 0; i < 5; i++){
      //    System.out.println("Suite = " + cards[i].suite);
      //    System.out.println("Value = " + cards[i].value);
      // }
   }

   //  public static Card[] splitCardsForPlayer(int Id){
   //      Deck deck = WebPoker.deck;
   //      Card[] hand = new Card[25];
   //      if (Id == 0){
   //          for (int i = 0; i < 5; i++) {
   //              hand[i] = deck.cards[i];
   //              //System.out.println("Suite = " + hand[i].suite);
   //              //System.out.println("Value = " + hand[i].value);
   //          }
   //          return hand;
   //      }
   //      else if (Id == 1) {
   //          for (int i = 5; i < 10; i++) {
   //              hand[i] = deck.cards[i];
   //             //  System.out.println("Suite = " + hand[i].suite);
   //             //  System.out.println("Value = " + hand[i].value);
   //          }
   //          return hand;
   //      }
   //      else if (Id == 2) {
   //          for (int i = 10; i < 15; i++) {
   //              hand[i] = deck.cards[i];
   //             //  System.out.println("Suite = " + hand[i].suite);
   //             //  System.out.println("Value = " + hand[i].value);
   //          }
   //          return hand;
   //      }
   //      else if (Id == 3) {
   //          for (int i = 15; i < 20; i++) {
   //             hand[i] = deck.cards[i];
   //             //  System.out.println("Suite = " + hand[i].suite);
   //             //  System.out.println("Value = " + hand[i].value);
   //          }
   //          return hand;
   //      }
   //      else if (Id == 4) {
   //          for (int i = 20; i < 25; i++) {
   //              hand[i] = deck.cards[i];
   //             //  System.out.println("Suite = " + hand[i].suite);
   //             //  System.out.println("Value = " + hand[i].value);
   //          }
   //          return hand;
   //      }
   //      else {
   //          System.out.println("The if statement don't work");
   //          return null;
   //      }
   //  }
}
