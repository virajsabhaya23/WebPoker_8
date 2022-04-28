package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.UserEvent.UserEventType;

import java.util.ArrayList;

public class Game {
    private transient int seconds;
    int round_num = 0;
    int player_turn = 0;
    int num_bets = 0;
    int bet_amount = 0;
    int pot = 0;
    int place_hold = 25;
    int numPlayers = 0;
    int highestNumber = 0;
    int numOwner = 0;
    int dealButtonPress = 0;
    ArrayList<Player> players = new ArrayList<>();
    final static Deck deck = Deck.randomize();

    public String exportStateAsJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void addPlayer(Player p) {
        players.add(p);
        System.out.println("Adding a Player");
        numPlayers = numPlayers + 1;
        System.out.println("numPlayers = " + numPlayers);
    }

    public void removePlayer(int playerid) {
        if (playerid != 0) {
            players.remove(playerid - 1);
        }
        numPlayers = numPlayers - 1;
    }

    public void processMessage(String msg) {
        System.out.println("It is " + player_turn + "'s Turn!!! numPlayers = " + numPlayers);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        // Player play = new Player();
        UserEvent event = gson.fromJson(msg, UserEvent.class);

        // if (event.event == UserEventType.DEAL) {
        // dealButtonPress = 1;
        // players.get(event.playerID).splitCardsForPlayer();
        // }

        if (event.event == UserEventType.NAME) {
            int Id = players.get(event.playerID).Id;
            players.get(event.playerID).SetName(event.name);
            players.get(event.playerID).hand.splitCardsForPlayer(Id);
            // players.get(event.playerID).Player_ID(Id);
        }

        // dealButtonPress = 0;
        // System.out.println("Before stand event" + player_turn);
        // Made Changes here
        if (event.event == UserEventType.STAND) {
            // System.out.println("Inside stand event" + player_turn);
            if (players.get(event.playerID).Id == player_turn) { // VS changed 04/15 I just replaced all play.Id to
                player_turn = player_turn + 1;
                System.out.println("Player " + players.get(event.playerID).Id + " STANDS");

                // Switch Statement For STAND in each round
                switch (round_num) {
                    // Bet
                    case 0:
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " + bet_amount);
                        }
                        break;

                    // Change
                    case 1:
                        System.out.println("Player " + players.get(event.playerID).Id + " Keeps all their cards");
                        break;

                    // Bet
                    case 2:
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " + bet_amount);
                        }
                        break;

                    // Showdown
                    case 3:
                        System.out.println("Showdown");
                        System.out.println("Current Highest Ranking: " + highestNumber);
                        System.out.println("Player Ranking: " + players.get(event.playerID).hand.ranking);
                        if (players.get(event.playerID).hand.ranking > highestNumber) {
                            highestNumber = players.get(event.playerID).hand.ranking;
                            numOwner = players.get(event.playerID).Id;
                        } else {
                            System.out.println("Sorry sport your hand was ass");
                        }
                        break;
                }
                if (player_turn > (numPlayers - 1)) {
                    if (round_num == 3) {
                        System.out.println("The Winner is " + numOwner);
                        System.out.println("Please Leave");
                    } else {
                        System.out.println("Round Complete, Starting next Round now!");
                        round_num = round_num + 1;
                        player_turn = 0;
                        num_bets = 0;
                    }
                }
            } else {
                System.out.println(players.get(event.playerID).Id + ", it is not your Turn :(\n" + "It is "
                        + player_turn + "'s Turn!!!");
            }
        }

        // Made Changes here
        // Hitting means you want to change cards, make them change the first 3 cards
        // for now
        // System.out.println("Before hit event");
        if (event.event == UserEventType.HIT) {
            // System.out.println("Inside hit event");
            if (players.get(event.playerID).Id == player_turn) {
                player_turn = player_turn + 1;
                System.out.println("Player " + players.get(event.playerID).Id + " HITS");

                // Switch Statement For HIT in each round
                switch (round_num) {
                    // Bet
                    case 0:
                        num_bets = num_bets + 1;
                        bet_amount = num_bets * 10;
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " + bet_amount);
                        }
                        break;

                    // Change
                    case 1:
                        System.out.println("BEFORE HAND CHANGES");
                        for (int j = 0; j < 5; j++) {
                            System.out.println(players.get(event.playerID).hand.cards[j].value + " "
                                    + players.get(event.playerID).hand.cards[j].suit);
                        }
                        System.out.println("Player " + players.get(event.playerID).Id + " Changes their first 3 cards");
                        for (int n = 1; n <= 3; n++) {
                            System.out.println("\nOld Cards: " + players.get(event.playerID).hand.cards[n].value + " "
                                    + players.get(event.playerID).hand.cards[n].suit);
//                            players.get(event.playerID).hand.cards[n] = deck.cards[place_hold];
                            System.out.println("\nNew Cards: " + players.get(event.playerID).hand.cards[n].value + " "
                                    + players.get(event.playerID).hand.cards[n].suit + "\n");
                            place_hold = place_hold + n;
                        }
                        System.out.println("AFTER HAND CHANGES");
                        for (int j = 0; j < 5; j++) {
                            System.out.println(players.get(event.playerID).hand.cards[j].value + " "
                                    + players.get(event.playerID).hand.cards[j].suit);
                        }
                        break;

                    // Bet
                    case 2:
                        num_bets = num_bets + 1;
                        bet_amount = num_bets * 10;
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " + bet_amount);
                        }
                        break;

                    // Showdown is Round 3
                    case 3:
                        System.out.println("Showdown");
                        System.out.println("Current Highest Ranking: " + highestNumber);
                        System.out.println("Player Ranking: " + players.get(event.playerID).hand.ranking);
                        if (players.get(event.playerID).hand.ranking > highestNumber) {
                            highestNumber = players.get(event.playerID).hand.ranking;
                            numOwner = players.get(event.playerID).Id;
                        } else {
                            System.out.println("Sorry sport your hand was ass");
                        }
                        break;
                }
                // Try or equals later if this does not work
                if (player_turn > (numPlayers - 1)) {
                    if (round_num == 3) {
                        System.out.println("The Winner is " + numOwner);
                        System.out.println("Please Leave");
                    } else {
                        System.out.println("Round Complete, Starting next Round now!");
                        round_num = round_num + 1;
                        player_turn = 0;
                        num_bets = 0;
                    }
                }
            } else {
                System.out.println(players.get(event.playerID).Id + ", it is not your Turn :(\n" + "It is "
                        + player_turn + "'s Turn!!!");
            }
        }

        // Made Changes here
        // Calling means you pass or you match the bet/ raise
        // System.out.println("Before call event" + player_turn);
        if (event.event == UserEventType.CALL) {
            // System.out.println("Inside call event" + player_turn);
            if (players.get(event.playerID).Id == player_turn) {
                player_turn = player_turn + 1;
                System.out.println("Player " + players.get(event.playerID).Id + " CALLS");

                // Switch Statement For CALL in each round
                switch (round_num) {
                    // Bet Round is Round 0
                    case 0:
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " + bet_amount);
                        }
                        break;
                    // Change is Round 1
                    case 1:
                        System.out.println("Player " + players.get(event.playerID).Id + " Keeps all their cards");
                        break;
                    // Bet is Round 2
                    case 2:
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet - bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " + bet_amount);
                        }
                        break;
                    // Showdown is Round 3
                    case 3:
                        System.out.println("Showdown");
                        System.out.println("Current Highest Ranking: " + highestNumber);
                        System.out.println("Player Ranking: " + players.get(event.playerID).hand.ranking);
                        if (players.get(event.playerID).hand.ranking > highestNumber) {
                            highestNumber = players.get(event.playerID).hand.ranking;
                            numOwner = players.get(event.playerID).Id;
                        } else {
                            System.out.println("Sorry sport your hand was ass");
                        }
                        break;
                }

                if (player_turn > (numPlayers - 1)) {
                    if (round_num == 3) {
                        System.out.println("The Winner is " + numOwner);
                        System.out.println("Please Leave");
                        // game.NewGame();
                    } else {
                        System.out.println("Round Complete, Starting next Round now!");
                        round_num = round_num + 1;
                        player_turn = 0;
                        num_bets = 0;
                    }
                }
            } else {
                System.out.println(players.get(event.playerID).Id + ", it is not your Turn :(\n" + "It is "
                        + player_turn + "'s Turn!!!");
            }
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

    public Game() {
    }

}
