package uta.cse3310;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uta.cse3310.UserEvent.UserEventType;
import uta.cse3310.WebPoker;

public class Game {
    int action = 0;
    ArrayList<Player> players = new ArrayList<>();
    int turn; // player ID that has the current turn
    int actions = 0;

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

        // TODO: FIX THIS WHEN PLAYERID = 0
        // RETURNS WITH IndexOutOfBoundsException
        
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

        if (event.event == UserEventType.NAME) {
            players.get(event.playerID).SetName(event.name);
        }
        if (event.event == UserEventType.STAND) {
            // when user calls stand, move on to the next player
            System.out.println("Player STAND");
            action = action + 1;
            // players.get(event.playerID).SetName(event.name);
        }
        if (event.event == UserEventType.HIT) {
            // when user calls hit
            System.out.println("Player HIT");
            action = action + 1;
            // players.get(event.playerID).SetName(event.name);
        }          
        if (event.event == UserEventType.CALL) {
            // when user calls call
            action = action + 1;
            System.out.println("Player CALL" + " Action " + action);
            // players.get(event.playerID).SetName(event.name);
        }                    
    }

    // TODO: Fix issue when more than one player enters their name


    public boolean update() {

        // this function is called on a periodic basis (once a second) by a timer
        // it is to allow time based situations to be handled in the game
        // if the game state is changed, it returns a true.
        return false;
        // expecting that returning a true will trigger a send of the game
        // state to everyone

    }

    // public void betRound(int n) {
    //     //bet Round call atm does nothing aswell LOL

    //     System.out.println("Bet Round");

    //     while (actions != n) {
    //         //System.out.println("Inside Bet Round");
    //                 if (event.event == UserEventType.STAND) {
    //         // when user calls stand, move on to the next player
    //         System.out.println("Player STAND");
    //         action = action + 1;
    //         // players.get(event.playerID).SetName(event.name);
    //     }
    //     if (event.event == UserEventType.HIT) {
    //         // when user calls hit
    //         System.out.println("Player HIT");
    //         action = action + 1;
    //         // players.get(event.playerID).SetName(event.name);
    //     }          
    //     if (event.event == UserEventType.CALL) {
    //         // when user calls call
    //         action = action + 1;
    //         System.out.println("Player CALL" + " Action " + action);
    //         // players.get(event.playerID).SetName(event.name);
    //     }
    //     }
    //     actions = 0;
    // }

    // public void changeRound(int n) {
    //     // Change Round call does nothing atm

    //     System.out.println("Change Round");

    //     // while (actions != n) {
    //     //     System.out.println("Inside Change Round");
    //     // }
    //     actions = 0;    
    // }

    // public void showdownRound(int n) {
    //     // hand ranking call

    //     System.out.println("Showdown Round");

    //     // while (actions != n) {
    //     //     System.out.println("Inside Showdown Round");
    //     // }
    //     actions = 0;
    // }

    public Game() {
        System.out.println("creating a Game Object");

        // Deal cards to players
        System.out.println("Dealing cards");
        

        
        // int numPlayers = 2;


        //numPlayers = getNum();
        //round 1
        //betRound(numPlayers);
        // System.out.println("You are going into a loop:)");
        // while (actions != numPlayers) {
            
        // }
        // actions = 0;
        // System.out.println("You've Made it out Congrats :)");
        // //round 2
        // //changeRound(numPlayers);
        // while (actions != numPlayers) {
            
        // }
        // actions = 0;
        // System.out.println("You've Made it out Congrats :)");
        // //round 3
        // //betRound(numPlayers);
        // while (actions != numPlayers) {
            
        // }
        // actions = 0;
        // System.out.println("You've Made it out Congrats :)");
        // //round 4
        // //showdownRound(numPlayers);
        // while (actions != numPlayers) {
            
        // }
        // actions = 0;
        // System.out.println("You've Made it out Congrats :)");
        //close game
        System.out.println("Dealing complete, rejoice!!!");
    }

    // private int getNum() {
    //     return 2;
    // }

}
