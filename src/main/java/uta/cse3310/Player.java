package uta.cse3310;

import com.google.gson.Gson;

public class Player {
  public int id;
  public int matchID;
  public int wallet = 100;
  public Hand hand = new Hand();
  String playerName;
  String LastMessageToPlayer;
  boolean isReady;

  public void playerID(int id) {
    playerName = "not set";
  }

  public void SetName(String name) {
    playerName = name;
    LastMessageToPlayer = "Welcome " + name + " to the game.";
  }

  public String asJSONString() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
