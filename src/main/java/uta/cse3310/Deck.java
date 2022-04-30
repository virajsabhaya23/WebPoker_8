package uta.cse3310;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  public ArrayList<Card> deck;

  public Deck() {
    this.deck = new ArrayList<>();

    for (Card.Suit suit : Card.Suit.values()) {
      for (Card.Value value : Card.Value.values()) {
        deck.add(new Card(suit, value));
      }
    }
    Collections.shuffle(deck);
  }

  // public Hand dealHand(int Id) {
  // Hand hand = new Hand();

  // System.out.println("ID # = " + Id);
  // if (Id == 0) {
  // for (int i = 0; i < 5; i++) {
  // deck.cards[i];
  // }
  // hand = hand.sort(); // testing sort func()
  // for (int i = 0; i < 5; i++) {
  // System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
  // }
  // return hand;
  // } else if (Id == 1) {
  // System.out.println("I am past the first loop :)");
  // for (int i = 0; i < 5; i++) {
  // this.cards[i] = deck.cards[i + 5];
  // }
  // hand = sort(this); // testing sort func()
  // for (int i = 0; i < 5; i++) {
  // System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
  // }
  // return hand;
  // } else if (Id == 2) {
  // for (int i = 0; i < 5; i++) {
  // this.cards[i] = deck.cards[i + 10];
  // }
  // hand = sort(this); // testing sort func()
  // for (int i = 0; i < 5; i++) {
  // System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
  // }
  // return hand;
  // } else if (Id == 3) {
  // for (int i = 0; i < 5; i++) {
  // this.cards[i] = deck.cards[i + 15];
  // }
  // hand = sort(this); // testing sort func()
  // for (int i = 0; i < 5; i++) {
  // System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
  // }
  // return hand;
  // } else if (Id == 4) {
  // for (int i = 0; i < 5; i++) {
  // this.cards[i] = deck.cards[i + 20];
  // }
  // hand = sort(this); // testing sort func()
  // for (int i = 0; i < 5; i++) {
  // System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
  // }
  // return hand;
  // } else {
  // System.out.println("The if statement don't work");
  // return null;
  // }

  // return hand;
  // }

  public void swapHand(int playerID) {
    // TODO: Swap the hand that is passed in
  }

}

// public Hand splitCardsForPlayer(int Id) {
// // Deck deck = new Deck(); // Might need to change this later......
// // use player's hand
// // hnd.cards = hand;
// Hand hand = new Hand();
// System.out.println("ID # = " + Id);
// if (Id == 0) {
// for (int i = 0; i < 5; i++) {
// deck.cards[i];
// }
// hand = hand.sort(); // testing sort func()
// for (int i = 0; i < 5; i++) {
// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
// }
// return hand;
// } else if (Id == 1) {
// System.out.println("I am past the first loop :)");
// for (int i = 0; i < 5; i++) {
// this.cards[i] = deck.cards[i + 5];
// }
// hand = sort(this); // testing sort func()
// for (int i = 0; i < 5; i++) {
// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
// }
// return hand;
// } else if (Id == 2) {
// for (int i = 0; i < 5; i++) {
// this.cards[i] = deck.cards[i + 10];
// }
// hand = sort(this); // testing sort func()
// for (int i = 0; i < 5; i++) {
// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
// }
// return hand;
// } else if (Id == 3) {
// for (int i = 0; i < 5; i++) {
// this.cards[i] = deck.cards[i + 15];
// }
// hand = sort(this); // testing sort func()
// for (int i = 0; i < 5; i++) {
// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
// }
// return hand;
// } else if (Id == 4) {
// for (int i = 0; i < 5; i++) {
// this.cards[i] = deck.cards[i + 20];
// }
// hand = sort(this); // testing sort func()
// for (int i = 0; i < 5; i++) {
// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
// }
// return hand;
// } else {
// System.out.println("The if statement don't work");
// return null;
// }

// return hand;
// }
