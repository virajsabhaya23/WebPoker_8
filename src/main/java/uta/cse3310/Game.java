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
    ArrayList<Player> players = new ArrayList<>();
    public Deck deck = new Deck();

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

    public void removePlayer(int playerID) {
        if (playerID != 0) {
            players.remove(playerID - 1);
        }
        numPlayers = numPlayers - 1;
    }

    public void swapCards(Hand playerHand) {
        Hand hand = playerHand;
        for (int i = 0; i < 3; i++) {
            hand.cards.remove(i);
        }
        for (int j = 0; j < 3; j++) {
            hand.cards.add(deck.deck.get(place_hold + j));
            place_hold = place_hold + j;
        }
    }

    public Hand splitCardsForPlayer(int Id) {
        Hand hand = new Hand();

        System.out.println("ID # = " + Id);

        if (Id == 0) {
            for (int i = 0; i < 5; i++) {
                hand.cards.add(deck.deck.get(i));
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(hand.cards.get(i).value + "-" + hand.cards.get(i).suit);
            }
            return hand;

        } else if (Id == 1) {
            for (int i = 0; i < 5; i++) {
                hand.cards.add(deck.deck.get(i + 5));
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(hand.cards.get(i).value + "-" + hand.cards.get(i).suit);
            }
            return hand;
        } else if (Id == 2) {
            for (int i = 0; i < 5; i++) {
                hand.cards.add(deck.deck.get(i + 10));
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(hand.cards.get(i).value + "-" + hand.cards.get(i).suit);
            }
            return hand;
        } else if (Id == 3) {
            for (int i = 0; i < 5; i++) {
                hand.cards.add(deck.deck.get(i + 15));
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(hand.cards.get(i).value + "-" + hand.cards.get(i).suit);
            }
            return hand;
        } else if (Id == 4) {
            for (int i = 0; i < 5; i++) {
                hand.cards.add(deck.deck.get(i + 20));
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(hand.cards.get(i).value + "-" + hand.cards.get(i).suit);
            }
            return hand;
        } else {
            System.out.println("The if statement don't work");
            return null;
        }
    }

    public void processMessage(String msg) {
        System.out.println("It is " + player_turn + "'s Turn!!! numPlayers = " + numPlayers);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        UserEvent event = gson.fromJson(msg, UserEvent.class);

        // Player is named and dealt a hand
        if (event.event == UserEventType.NAME) {
            int Id = players.get(event.playerID).Id;
            players.get(event.playerID).SetName(event.name);
            players.get(event.playerID).hand = splitCardsForPlayer(Id);
        }

        if (event.event == UserEventType.STAND) {

            if (players.get(event.playerID).Id == player_turn) {
                player_turn = player_turn + 1;
                System.out.println("Player " + players.get(event.playerID).Id + " STANDS");

                // Switch Statement For STAND in each round
                switch (round_num) {
                    // Bet
                    case 0:
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet -
                                    bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " +
                                    bet_amount);
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
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet -
                                    bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " +
                                    bet_amount);
                        }
                        break;

                    // Showdown
                    case 3:
                        players.get(event.playerID).hand.getRanking();
                        System.out.println("Showdown");
                        System.out.println("Current Highest Ranking: " + highestNumber);
                        System.out.println("Player Ranking: " +
                                players.get(event.playerID).hand.ranking);
                        if (players.get(event.playerID).hand.ranking > highestNumber) {
                            highestNumber = players.get(event.playerID).hand.ranking;
                            numOwner = players.get(event.playerID).Id;
                        } else {
                            // System.out.println("Sorry sport your hand was ass");
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
                System.out.println(players.get(event.playerID).Id + ", it is not your Turn:(\n" + "It is " + player_turn
                        + "'s Turn!!!");
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
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet -
                                    bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " +
                                    bet_amount);
                        }
                        break;

                    // Change
                    case 1:
                        System.out.println("BEFORE HAND CHANGES");
                        for (int j = 0; j < 5; j++) {
                            System.out.println(players.get(event.playerID).hand.cards.get(j).value + " "
                                    + players.get(event.playerID).hand.cards.get(j).suit);
                        }
                        System.out.println("Player " + players.get(event.playerID).Id + " Changes their first 3 cards");

                        // Swap player hand
                        swapCards(players.get(event.playerID).hand);
                        place_hold = place_hold + 3;
                        System.out.println("AFTER HAND CHANGES");
                        for (int j = 0; j < 5; j++) {
                            System.out.println(players.get(event.playerID).hand.cards.get(j).value + " "
                                    + players.get(event.playerID).hand.cards.get(j).suit);
                        }
                        break;

                    // Bet
                    case 2:
                        num_bets = num_bets + 1;
                        bet_amount = num_bets * 10;
                        if (players.get(event.playerID).Wallet < bet_amount) {
                            System.out.println("You broke ass hoe, smh <(*-*)>");
                        } else {
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet -
                                    bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " +
                                    bet_amount);
                        }
                        break;

                    // Showdown is Round 3
                    case 3:
                        players.get(event.playerID).hand.getRanking();
                        System.out.println("Showdown");
                        System.out.println("Current Highest Ranking: " + highestNumber);
                        System.out.println("Player Ranking: " +
                                players.get(event.playerID).hand.ranking);
                        if (players.get(event.playerID).hand.ranking > highestNumber) {
                            highestNumber = players.get(event.playerID).hand.ranking;
                            numOwner = players.get(event.playerID).Id;
                        } else {
                            // System.out.println("Sorry sport your hand was ass");
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
                System.out.println(players.get(event.playerID).Id + ", it is not your Turn:(\n" + "It is " + player_turn
                        + "'s Turn!!!");
            }
        }

        // Made Changes here
        // Calling means you pass, or you match the bet/ raise
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
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet -
                                    bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " +
                                    bet_amount);
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
                            players.get(event.playerID).Wallet = players.get(event.playerID).Wallet -
                                    bet_amount;
                            pot = pot + bet_amount;
                            System.out.println("Player " + players.get(event.playerID).Id + " Bets " +
                                    bet_amount);
                        }
                        break;
                    // Showdown is Round 3
                    case 3:
                        // for(int i = 0; i < numPlayers; i++){
                        // players.get(event.playerID).hand.getRanking();
                        // }
                        players.get(event.playerID).hand.getRanking();

                        System.out.println("Showdown");
                        System.out.println("Current Highest Ranking: " + highestNumber);

                        System.out.println("Player Ranking: " +
                                players.get(event.playerID).hand.ranking);
                        if (players.get(event.playerID).hand.ranking > highestNumber) {
                            highestNumber = players.get(event.playerID).hand.ranking;
                            numOwner = players.get(event.playerID).Id;
                        } else {
                            // System.out.println("Sorry sport your hand was ass");
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
