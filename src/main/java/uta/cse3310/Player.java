package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.Deck;

public class Player {
    public int Id;
    String Name;
    String LastMessageToPlayer;
    Card[] hand = new Card[5];

    public Player(int id) {
        Id = id;
        Name = "not set";
        hand = splitCardsForPlayer();
    }

    public void SetName(String N) {
        Name = N;
        LastMessageToPlayer="Welcome " + N + " to the game.";
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Card[] splitCardsForPlayer() {
        Deck deck = WebPoker.deck;
        System.out.println("ID # = " + Id);
        if (Id == 0){
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i];
                System.out.println("Suite = " + hand[i].suite);
                System.out.println("Value = " + hand[i].value);
            }
            return hand;
        }
        else if (Id == 1) {
            System.out.println("I am past the fisrt loop :)");
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i+5];
                System.out.println("Suite = " + hand[i].suite);
                System.out.println("Value = " + hand[i].value);
            }
            return hand;
        }
        else if (Id == 2) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i+10];
                System.out.println("Suite = " + hand[i].suite);
                System.out.println("Value = " + hand[i].value);
            }
            return hand;
        }
        else if (Id == 3) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i+15];
                System.out.println("Suite = " + hand[i].suite);
                System.out.println("Value = " + hand[i].value);
            }
            return hand;
        }
        else if (Id == 4) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i+20];
                System.out.println("Suite = " + hand[i].suite);
                System.out.println("Value = " + hand[i].value);
            }
            return hand;
        }
        else {
            System.out.println("The if statement don't work");
            return null;
        }
    }
}