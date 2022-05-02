package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.UserEvent.UserEventType;

import java.util.ArrayList;

public class Game {
  static final int maxPlayers = 5;
  public Dealer gameDealer = new Dealer();
  int round_num = 0;
  int player_turn = 0;
  int num_bets = 0;
  int bet_amount = 0;
  int pot = 0;
  int ante = 0;
  int numPlayers = 0;
  int highestNumber = 0;
  int numOwner = 0;
  int matchID = 0;
  boolean hasStarted;
  ArrayList<Player> players = new ArrayList<>();
  private transient int seconds;

  public Game() {}

  public String exportStateAsJSON() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }

  public String exportPlayerHandAsJson(int id) {
    Gson gson = new Gson();
    gson.toJson(players.get(id).hand);
    return gson.toJson(players.get(id).hand);
  }

  public void addPlayer(Player p) {
    if (players.size() > maxPlayers) {
      System.out.println("Maximum number of players joined");
    }

    players.add(p);
    System.out.println("Adding a Player");
    numPlayers = numPlayers + 1;
    System.out.println("numPlayers = " + numPlayers);
  }

  public void removePlayer(int playerID) {
    if (playerID != 0) {
      players.remove(playerID - 1);
    }
    numPlayers = numPlayers - 1;
  }

  /**
   * Incoming messages from the client are processed.
   *
   * @param msg client message
   */
  public void processMessage(String msg) {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    UserEvent event = gson.fromJson(msg, UserEvent.class);

    // Player names themselves and get a matchID
    if (event.event == UserEventType.NAME) {
      players.get(event.playerID).SetName(event.name);
    }

    // Player joins a match and is dealt a hand
    if (event.event == UserEventType.JOIN) {
      players.get(event.playerID).hand = gameDealer.deal();
      this.exportPlayerHandAsJson(event.playerID);
    }
  }

  public boolean update() {
    seconds = seconds + 1;
    if ((seconds % 10) == 0) {
      if (player_turn > (numPlayers - 1)) {
        player_turn = 0;
      }
      return true;
    }
    return false;
  }
}
