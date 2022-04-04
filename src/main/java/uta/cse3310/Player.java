package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import uta.cse3310.Deck;

public class Player {
    
    public int Id;
    String Name;
    uta.cse3310.Card Cards[];
    String LastMessageToPlayer;

    public Player(int id) {
        Id = id;
        Name = "not set";
        // there is a lot smarter ways to do this,
        // but at least this is obvious
        //Deck.get5card();
        //String[] Cards = new String[5];
        Cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            Cards[i] = new Card();
            Cards[i].suite = Card.Suite.valueOf("SPADES");
            Cards[i].value = Card.Value.valueOf("FIVE");
        }
    }
    
    public void SetName(String N) {
        Name = N;
        LastMessageToPlayer="Welcome " + N + " to the game.";
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

//     public static void splitCardsForPlayer(){
        
//         if (Id == 0){
//             for (int i = 0; i <= Cards.length; i++) {
//                 Cards[i] = Deck.get5card()[i];
//             }
//         }
//         else if (Id == 1) {
//             for (int i = 0; i <= Cards.length; i++) {
//                 Cards[i] = Deck.get5card()[i];
//             }
//         }
//         else if (Id == 2) {
//             for (int i = 0; i <= Cards.length; i++) {
//                 Cards[i] = Deck.get5card()[i];
//             }
//         }
//         else if (Id == 3) {
//             for (int i = 0; i <= Cards.length; i++) {
//                 Cards[i] = Deck.get5card()[i];
//             }
//         }
//         else if (Id == 4) {
//             for (int i = 0; i <= Cards.length; i++) {
//                 Cards[i] = Deck.get5card()[i];
//             }
//         }
//         else {
//             System.out.println("The if statement don't work");
//         }
//     }
}

     

