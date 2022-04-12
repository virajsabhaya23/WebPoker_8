package uta.cse3310;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uta.cse3310.UserEvent.UserEventType;
import uta.cse3310.WebPoker;
import uta.cse3310.Deck;
import java.util.*;

public class Game {
    Deck deck = new Deck();

    // I am not going to write a for loop
    //System.out.println(Deck.cards[i]);
    
    private transient int seconds;
    int action = 0;
    ArrayList<Player> players = new ArrayList<>();
    private int turn; // player ID that has the current turn
    int actions = 0;

    public void shuffle(){
        for (int i = 0; i < 51; i++) {
            System.out.println(deck.cards[i].value);
            System.out.println(deck.cards[i].suite);
        }
        // for (int i = deck.cards.length - 1; i > 0; i--) {

        //  Random rand = new Random();

        //  int j = rand.nextInt(i + 1);
        //  Card tmp = deck.cards[j];
        //  deck.cards[j] = deck.cards[i];
        //  deck.cards[i] = tmp;
      //}
    }

    public String exportStateAsJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void removePlayer(int playerid) {
        // given it's player number, this method
        // deletes the player from the players array
        // and does whatever else is needed to remove
        // the player from the game.
        
        if (playerid != 0)
            players.remove(playerid - 1);
        // else
        //     players.remove(playerid);
    }

    public void processMessage(String msg) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        // take the string we just received, and turn it into a user event
        UserEvent event = gson.fromJson(msg, UserEvent.class);


        // TODO: look into order of display
        if (event.event == UserEventType.NAME) {
            players.get(event.playerID).SetName(event.name);
            // players.get(event.playerID).splitCardsForPlayer();
            // call Player.GiveHand function to give player their hand
        }
        //while (actions != 1) {
            if (event.event == UserEventType.STAND) {
                // when user calls stand, move on to the next player
                System.out.println("Player STAND");
                action = action + 1;
                //players.get(event.playerID).SetName(event.stand);
            }
            if (event.event == UserEventType.HIT) {
                // when user calls hit
                action = action + 1;
                System.out.println("Player HIT");
                
                //players.get(event.playerID).SetName(event.hit);
            }          
            if (event.event == UserEventType.CALL) {
                // when user calls call
                action = action + 1;
                System.out.println("Player CALL" + " Action " + action);
                //players.get(event.playerID).SetName(event.call);
            }    
        //}
        System.out.println("Ayo");             
    }

    // TODO: Fix issue when more than one player enters their name


    public boolean update() {
        
        // this function is called on a periodic basis (once a second) by a timer
        // it is to allow time based situations to be handled in the game
        // if the game state is changed, it returns a true.
        seconds = seconds + 1;
        if ((seconds % 10) == 0) {
            turn = turn + 1;
            if (turn == 5) {
                turn = 0;
            }
            return true;
        }
        return false;

        // return false;
        // expecting that returning a true will trigger a send of the game
        // state to everyone

    }


    public Game() {
        System.out.println("Going into loop");
        // while(actions < 1) {
            
        // }
        System.out.println("Somehow made it out of the loop");
    }

    // private int getNum() {
    //     return 2;
    // }

        // System.out.println("creating a Game Object");
        // // Deal cards to players
        // System.out.println("Dealing cards");
        // // get5card();
        // System.out.println("Each Player Has 5 Cardse, rejoice!!!");
        // WebPoker.betRound();
        // System.out.println("Bet Round Complete");
        // WebPoker.changeRound();
        // System.out.println("Change Round Complete");
        // WebPoker.betRound();
        // System.out.println("Bet Round Complete");
        // WebPoker.showdownRound();
        // System.out.println("Game Overs");

}
