package uta.cse3310;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
//Reference: https://cs.smu.ca/~porter/csc/465/code/deitel/examples/ch07/fig07_09_11/DeckOfCards.java2html

import java.util.Random;
import uta.cse3310.Card.Value;
import uta.cse3310.Card.Suite;

public class Deck {

   Card card;

   public static void initialize() {
      String[] SUITS = {
         "C", "D", "H", "S"
      };

      String[] RANKS = {
         "2", "3", "4", "5", "6", "7", "8", "9", "T",
         "J", "Q", "K", "A"
      };

      // initialize deck
      int n = SUITS.length * RANKS.length;
      String[] deck = new String[n];
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
      // return deck;
   }

   public static String[] deal(int id) {
      String[] deal = new String[5];
      return deal;
   }
}


// public class Deck
// {
//    private Card deck[]; // array of Card objects
//    private int currentCard; // index of next Card to be dealt
//    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
//    private Random randomNumbers; // random number generator

//    // constructor fills deck of Cards
//    public Deck()
//    {
//       Value[] card_values = Card.Value.values();
//       Suite[] card_suites = Card.Suite.values();
//       Card[] deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
//       currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
//       randomNumbers = new Random(); // create random number generator

//       // populate deck with Card objects
//       for ( int count = 0; count < deck.length; count++ ){
//          deck[count].suite = card_suites[count];
//          deck[count].value = card_values[count];
//       }
//    } // end DeckOfCards constructor

//    // shuffle deck of Cards with one-pass algorithm
//    public void shuffle()
//    {
//       // after shuffling, dealing should start at deck[ 0 ] again
//       currentCard = 0; // reinitialize currentCard

//       // for each Card, pick another random Card and swap them
//       for ( int first = 0; first < deck.length; first++ ) 
//       {
//          // select a random number between 0 and 51 
//          int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
//          // swap current Card with randomly selected Card
//          Card temp = deck[ first ];        
//          deck[ first ] = deck[ second ];   
//          deck[ second ] = temp;            
//       } // end for
//    } // end method shuffle

//    // deal one Card
//    public Card dealCard()
//    {
//       // determine whether Cards remain to be dealt
//          if ( currentCard < deck.length )
//             return deck[ currentCard++ ]; // return current Card in array
//          else        
//             return null; // return null to indicate that all Cards were dealt
//    } // end method dealCard
// } // end class DeckOfCards


// /**************************************************************************
//  * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
//  * Pearson Education, Inc. All Rights Reserved.                           *
//  *                                                                        *
//  * DISCLAIMER: The authors and publisher of this book have used their     *
//  * best efforts in preparing the book. These efforts include the          *
//  * development, research, and testing of the theories and programs        *
//  * to determine their effectiveness. The authors and publisher make       *
//  * no warranty of any kind, expressed or implied, with regard to these    *
//  * programs or to the documentation contained in these books. The authors *
//  * and publisher shall not be liable in any event for incidental or       *
//  * consequential damages in connection with, or arising out of, the       *
//  * furnishing, performance, or use of these programs.                     *
//  *************************************************************************/
