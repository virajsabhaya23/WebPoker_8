package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.Deck;

public class Player {
    
    public int Id;
    String Name;
    String[] Cards = new String[5];
    String LastMessageToPlayer;

    public Player(int id) {
        Id = id;
        Name = "not set";
        // there is a lot smarter ways to do this,
        // but at least this is obvious
        // Deck.get5card();
        
        // Cards = new Card[5];
    }

    public void SetName(String N) {
        Name = N;
        LastMessageToPlayer="Welcome " + N + " to the game.";
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void splitCardsForPlayer(){
        Deck deck = new Deck();
        //deck.cards = new Card[52];
    

        
        // String[] hand;
        // String[] deck;
        // Deck D = new Deck();
        // deck = D.initialize();
        // hand = D.get5card(deck);
        
        if (Id == 0){
            for (int i = 0; i <= 5; i++) {
                //Cards[i] = hand[i];
            }
        }
        else if (Id == 1) {
            for (int i = 0; i <= 5; i++) {
                //Cards[i] = hand[i];
            }
        }
        else if (Id == 2) {
            for (int i = 0; i <= 5; i++) {
                //Cards[i] = hand[i];
            }
        }
        else if (Id == 3) {
            for (int i = 0; i <= 5; i++) {
                //Cards[i] = hand[i];
            }
        }
        else if (Id == 4) {
            for (int i = 0; i <= 5; i++) {
                //Cards[i] = hand[i];
            }
        }
        else {
            System.out.println("The if statement don't work");
        }
    }
}