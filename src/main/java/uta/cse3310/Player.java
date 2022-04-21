package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.Deck;
import uta.cse3310.Hand;
import uta.cse3310.WebPoker;
import uta.cse3310.Card.Value;

import java.util.*;

public class Player {
    public int Id; // Made Changes here
    public int Wallet = 100; // Made Changes here
    // public int ranking;
    // public int highCard;
    String Name;
    String LastMessageToPlayer;
    public Card[] hand = new Card[5];
    public Hand hnd = new Hand();
    private HashMap<Card.Value, Integer> counts = new HashMap<>();
    Deck deck = Game.deck;

    public void getRanking() {
        int spadesCount = 0;
        int heartsCount = 0;
        int clubsCount = 0;
        int diamondsCount = 0;

        for (int j = 0; j < 5; j++) {
            if (hnd.cards[j].suit == Card.Suit.valueOf("SPADES")) {
                spadesCount++;
            } else if (hnd.cards[j].suit == Card.Suit.valueOf("HEARTS")) {
                heartsCount++;
            } else if (hnd.cards[j].suit == Card.Suit.valueOf("CLUBS")) {
                clubsCount++;
            } else {
                diamondsCount++;
            }
        }

        Value[] this_hand_enum_values = Card.Value.values();
        for (int i = 0; i < hnd.cards.length; i++) {
            if (!counts.containsKey(hnd.cards[i].value)) {
                counts.put(hnd.cards[i].value, 1);
            } else {
                counts.put(hnd.cards[i].value, counts.get(hnd.cards[i].value) + 1);
            }
        }

        if (counts.containsKey("ACE") && counts.containsKey("KING") && counts.containsKey("QUEEN")
                && counts.containsKey("JACK") && counts.containsKey("TEN")
                && ((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
            hnd.ranking = 1; // Royal Flush
        }

        else if ((!counts.containsValue(4) && !counts.containsValue(3) && !counts.containsValue(2))
                && ((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
            hnd.ranking = 2; // Straight Flush
        }

        else if (counts.containsValue(4)) {
            hnd.ranking = 3; // Four of a Kind
        }

        else if ((counts.containsValue(3)) && counts.containsValue(2)) {
            hnd.ranking = 4; // Full House
        }

        else if (((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
            hnd.ranking = 5; // Flush
        }

        else if (!counts.containsValue(4) && !counts.containsValue(3) && !counts.containsValue(2)) {
            hnd.ranking = 6; // Straight
        }

        else if (counts.containsValue(3) && !counts.containsValue(2)) {
            hnd.ranking = 7; // Three of a Kind
        }

        else if (counts.containsValue(2) && !counts.containsValue(4) && !counts.containsValue(3)
                && counts.containsValue(1)) {
            hnd.ranking = 8; // Two Pair
        }

        else if (counts.containsValue(2) && !counts.containsValue(3) && counts.containsValue(1)) {
            hnd.ranking = 9; // One Pair
        }

        else {
            hnd.ranking = 10; // High Card
        }
    }

    public Card[] sort(Hand hnd) {
        int i, j;
        Value[] this_hand_enum_values = Card.Value.values();

        // Sort
        for (i = 0; i < 5; i++) {
            int min_ind = i;
            for (j = i + 1; j < 5; j++) {
                if (Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[j].value) > Arrays
                        .asList(this_hand_enum_values)
                        .indexOf(hnd.cards[min_ind].value)) {
                    min_ind = j;
                }

            }
            Card.Value temp = hnd.cards[min_ind].value;
            hnd.cards[min_ind].value = hnd.cards[i].value;
            hnd.cards[i].value = temp;

        }
        hnd.highCard = Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[0].value);
        this.getRanking();
        return hnd.cards;
    }

    public void Player_ID(int id) {
        Id = id;
        Name = "not set";
        hand = splitCardsForPlayer();
    }

    public void SetName(String N) {
        Name = N;
        LastMessageToPlayer = "Welcome " + N + " to the game.";
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // players.get(event.playerID).hand[n]
    public Card[] splitCardsForPlayer() {
        // Deck deck = new Deck(); // Might need to change this later......
        hnd.cards = hand;
        System.out.println("ID # = " + Id);
        if (Id == 0) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i];
            }
            hand = sort(hnd); // testing sort func()
            for (int i = 0; i < 5; i++) {
                System.out.println(hand[i].value + "-" + hand[i].suit);
            }
            return hand;
        } else if (Id == 1) {
            System.out.println("I am past the first loop :)");
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i + 5];
            }
            hand = sort(hnd); // testing sort func()
            for (int i = 0; i < 5; i++) {
                System.out.println(hand[i].value + "-" + hand[i].suit);
            }
            return hand;
        } else if (Id == 2) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i + 10];
            }
            hand = sort(hnd); // testing sort func()
            for (int i = 0; i < 5; i++) {
                System.out.println(hand[i].value + "-" + hand[i].suit);
            }
            return hand;
        } else if (Id == 3) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i + 15];
            }
            hand = sort(hnd); // testing sort func()
            for (int i = 0; i < 5; i++) {
                System.out.println(hand[i].value + "-" + hand[i].suit);
            }
            return hand;
        } else if (Id == 4) {
            for (int i = 0; i < 5; i++) {
                hand[i] = deck.cards[i + 20];
            }
            hand = sort(hnd); // testing sort func()
            for (int i = 0; i < 5; i++) {
                System.out.println(hand[i].value + "-" + hand[i].suit);
            }
            return hand;
        } else {
            System.out.println("The if statement don't work");
            return null;
        }
    }
}
