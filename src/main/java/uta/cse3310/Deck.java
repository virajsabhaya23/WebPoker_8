package uta.cse3310;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
//Reference: https://cs.smu.ca/~porter/csc/465/code/deitel/examples/ch07/fig07_09_11/DeckOfCards.java2html

import java.util.Random;
import uta.cse3310.Card.Value;
import uta.cse3310.Card.Suite;

public class Deck {

   static String[] deck;
   public static String[] playerHandCards = new String[5];
   public static int FiveCounter = 0;
   
   public static String[] initialize() {
      String[] SUITS = {
         "C", "D", "H", "S"
      };

      String[] RANKS = {
         "2", "3", "4", "5", "6", "7", "8", "9", "T",
         "J", "Q", "K", "A"
      };
      String[] deck;
         // initialize deck
         int n = SUITS.length * RANKS.length;
         deck = new String[n];
         for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
               deck[SUITS.length*i + j] = RANKS[i] + SUITS[j];
            }
         }

         for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
         }

         for (int i = 0; i < 52; i++) {
            System.out.println(deck[i]);
         }
      return deck;
   }

   public static String[] get5card(){
      int i = 0; 
      for (int k = FiveCounter; k < FiveCounter+5; k++){
         playerHandCards[i] = deck[k];
         i++;
      }
      FiveCounter += 5;
      return playerHandCards;
   }

}