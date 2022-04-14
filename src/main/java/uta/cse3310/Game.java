package uta.cse3310;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uta.cse3310.UserEvent.UserEventType;
import uta.cse3310.WebPoker;
import uta.cse3310.Deck; // Made Changes here
import uta.cse3310.Player; // Made Changes here
import java.util.*;

public class Game {

    private transient int seconds;
    public int round_num = 0; // Made Changes here
    public int player_turn = 0; // Made Changes here
    public int num_bets = 0; // Made Changes here
    public int bet_amount = 0; // Made Changes here
    public int pot = 0; // Made Changes here
    public int place_hold = 25; // Made Changes here
    ArrayList<Player> players = new ArrayList<>();

    public String exportStateAsJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void removePlayer(int playerid) {

        if (playerid != 0)
            players.remove(playerid - 1);
    }

    public void processMessage(String msg) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        UserEvent event = gson.fromJson(msg, UserEvent.class);

        if (event.event == UserEventType.NAME) {
            players.get(event.playerID).SetName(event.name);
            players.get(event.playerID).splitCardsForPlayer();
        }
        // Made Changes here
        if (event.event == UserEventType.STAND) {
            if (Player.Id == player_turn) {
                System.out.println("Player " + Player.Id + " STANDS");

                // Switch Statement For STAND in each round
                switch (round_num) {
                    // Bet
                    case 0:
                        if (Player.Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            Player.Wallet = Player.Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + Player.Id + " Bets " + bet_amount);
                        }
                        break;

                    // Change
                    case 1:
                        System.out.println("Player " + Player.Id + " Keeps all their cards");
                        break;

                    // Bet
                    case 2:
                        if (Player.Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            Player.Wallet = Player.Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + Player.Id + " Bets " + bet_amount);
                        }
                        break;

                    // Showdown
                    case 3:
                        System.out.println("Yea I need to implement this lol...");
                        break;
                }
                player_turn = player_turn + 1;
                // create if statement for when the last player completes thier turn
                // reset the player_turn variable to 0 and iterate the Round variable + 1
                // Possible issue, numPlayers could start at 0 or 1 IDK, testing 0
                if (WebPoker.numPlayers == player_turn) {
                    System.out.println("Round Complete, Starting next Round now!");
                    round_num = round_num + 1;
                    player_turn = 0;
                    num_bets = 0;
                }
            } else {
                System.out.println(Player.Id +", it is not your Turn :(");
            }
        }

        // Made Changes here
        // Hitting means you want to change cards, make them change the first 3 cards
        // for now
        if (event.event == UserEventType.HIT) {
            if (Player.Id == player_turn) {
                System.out.println("Player " + Player.Id + " HITS");

                // Switch Statement For HIT in each round
                switch (round_num) {
                    // Bet
                    case 0:
                        num_bets = num_bets + 1;
                        bet_amount = num_bets * 10;
                        if (Player.Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            Player.Wallet = Player.Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + Player.Id + " Bets " + bet_amount);
                        }
                        break;

                    // Change
                    case 1:
                        System.out.println("Player " + Player.Id + " Changes their first 3 cards");
                        for (int n = 0; n < 3; n++) {
                            Player.hand[n] = WebPoker.deck.cards[place_hold];
                        }
                        break;

                    // Bet
                    case 2:
                        num_bets = num_bets + 1;
                        bet_amount = num_bets * 10;
                        if (Player.Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            Player.Wallet = Player.Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + Player.Id + " Bets " + bet_amount);
                        }
                        break;

                    // Showdown is Round 3
                    case 3:
                        System.out.println("Yea I need to implement this lol...");
                        break;
                }
                player_turn = player_turn + 1;
                // create if statement for when the last player completes thier turn
                // reset the player_turn variable to 0 and iterate the Round variable + 1
                // Possible issue, numPlayers could start at 0 or 1 IDK, testing 0
                if (WebPoker.numPlayers == player_turn) {
                    System.out.println("Round Complete, Starting next Round now!");
                    round_num = round_num + 1;
                    player_turn = 0;
                    num_bets = 0;
                }
            } else {
                System.out.println(Player.Id +", it is not your Turn :(");
            }
        }

        // Made Changes here
        // Calling means you pass or you match the bet/ raise
        if (event.event == UserEventType.CALL) {
            if (Player.Id == player_turn) {
                System.out.println("Player " + Player.Id + " CALLS");

                // Switch Statement For CALL in each round
                switch (round_num) {
                    // Bet Round is Round 0
                    case 0:
                        if (Player.Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            Player.Wallet = Player.Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + Player.Id + " Bets " + bet_amount);
                        }
                        break;
                    // Change is Round 1
                    case 1:
                        System.out.println("Player " + Player.Id + " Keeps all their cards");
                        break;
                    // Bet is Round 2
                    case 2:
                        if (Player.Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            Player.Wallet = Player.Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + Player.Id + " Bets " + bet_amount);
                        }
                        break;
                    // Showdown is Round 3
                    case 3:
                        System.out.println("Yea I need to implement this lol...");
                        break;
                }
                player_turn = player_turn + 1;
                // create if statement for when the last player completes thier turn
                // reset the player_turn variable to 0 and iterate the Round variable + 1
                // Possible issue, numPlayers could start at 0 or 1 IDK, testing 0
                if (WebPoker.numPlayers == player_turn) {
                    System.out.println("Round Complete, Starting next Round now!");
                    round_num = round_num + 1;
                    player_turn = 0;
                    num_bets = 0;
                }
            } else {
                System.out.println(Player.Id +", it is not your Turn :(");
            }
        }
    }

    public boolean update() {
        seconds = seconds + 1;
        if ((seconds % 10) == 0) {
            player_turn = player_turn + 1;
            if (player_turn == 5) {
                player_turn = 0;
            }
            return true;
        }
        return false;
    }

    public Game() {
        System.out.println("Going into loop");
        System.out.println("Somehow made it out of the loop");
    }

}
