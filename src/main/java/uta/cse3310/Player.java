package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.Deck;

public class Player {
    int Id;
    String Name;
    String[] Cards;
    String LastMessageToPlayer;

    public Player(int id) {
        Id = id;
        Name = "not set";
        // there is a lot smarter ways to do this,
        // but at least this is obvious
        Cards = Deck.deal(id);
    }

    // private Card[] deal(int id2) {
    //     return null;
    // }

    public void SetName(String N) {
        Name = N;
        LastMessageToPlayer="Welcome " + N + " to the game.";
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Cards = new Card[5];
        // for (int i = 0; i < 5; i++) {
        //     Cards[i] = new Card();
        //     Cards[i].suite = Card.Suite.valueOf("SPADES");
        //     Cards[i].value = Card.Value.valueOf("FIVE");
        // }

}
