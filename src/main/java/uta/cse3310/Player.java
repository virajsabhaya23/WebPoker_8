package uta.cse3310;

import com.google.gson.Gson;

public class Player {
    public int Id; // Made Changes here
    public int Wallet = 100; // Made Changes here
    String Name;
    String LastMessageToPlayer;
    public Hand hand = new Hand();

    public void Player_ID(int id) {
        Id = id;
        Name = "not set";
    }

    public void SetName(String N) {
        Name = N;
        LastMessageToPlayer = "Welcome " + N + " to the game.";
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String exportPlayerAsJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
