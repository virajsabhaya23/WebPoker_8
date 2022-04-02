package uta.cse3310;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uta.cse3310.Card.Value;

public class Hand {	
    // private transient int i=10;
    // marked transient they will not serialized / deserialized

    public Card[] cards;    
    public int ranking;
    public int highCard;
    
    private HashMap<Card.Value, Integer> counts = new HashMap<>();
    
    public Hand() {}

    public Card[] sort(Hand hnd) {
    	int i, j;
    	Value[] this_hand_enum_values = Card.Value.values();
    	
    	// Sort
    	for(i = 0; i < 5; i++) {
    		int min_ind = i;
    		for(j = i + 1; j < 5; j++) {
        		if(Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[j].value) > Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[min_ind].value)) {
        			min_ind = j;
        		}
        		
        	}
    		Card.Value temp = hnd.cards[min_ind].value;
    		hnd.cards[min_ind].value = hnd.cards[i].value;
    		hnd.cards[i].value = temp;
    		
    	}
    	hnd.highCard = Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[0].value);
    	return hnd.cards;	
    }
    
    
    public void getRanking() {
    	int spadesCount   = 0;
    	int heartsCount   = 0;
    	int clubsCount    = 0;
    	int diamondsCount = 0;
    	
    	for (int j = 0; j < 5; j++) {
    		if (this.cards[j].suite == Card.Suite.valueOf("SPADES")) {
    			spadesCount++;
    		}
    		else if (this.cards[j].suite == Card.Suite.valueOf("HEARTS")) {
    			heartsCount++;
    		}
    		else if (this.cards[j].suite == Card.Suite.valueOf("CLUBS")) {
    			clubsCount++;
    		}
    		else {
    			diamondsCount++;
    		}
    	}
    	
    	Value[] this_hand_enum_values = Card.Value.values();
    	for(int i = 0; i < cards.length; i++) {
    		if(!counts.containsKey(cards[i].value)) {
    			counts.put(cards[i].value, 1);
    		}
    		else {
    			counts.put(cards[i].value, counts.get(cards[i].value) + 1);
    		}
    	}
    	
    	if(counts.containsKey("ACE") && counts.containsKey("KING") && counts.containsKey("QUEEN") && counts.containsKey("JACK") && counts.containsKey("TEN") && ((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
    		this.ranking = 1;		// Royal Flush
    	}
    	
    	else if((!counts.containsValue(4) && !counts.containsValue(3) && !counts.containsValue(2)) && ((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
    		this.ranking = 2;		// Straight Flush
    	}
    	
    	else if(counts.containsValue(4)) {
    		this.ranking = 3;		// Four of a Kind
    	}
    	
    	else if((counts.containsValue(3)) && counts.containsValue(2)) {
    		this.ranking = 4;		// Full House
    	}
    	
    	else if(((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
    		this.ranking = 5;		// Flush
    	}
    	
    	else if(!counts.containsValue(4) && !counts.containsValue(3) && !counts.containsValue(2)) {
    		this.ranking = 6;		// Straight
    	}
    	
    	else if(counts.containsValue(3) && !counts.containsValue(2)) {
    		this.ranking = 7;		// Three of a Kind
    	}
    	
    	else if(counts.containsValue(2) && !counts.containsValue(4) && !counts.containsValue(3) && counts.containsValue(1)) {
    		this.ranking = 8;		// Two Pair
    	}
    	
    	else if(counts.containsValue(2) && !counts.containsValue(3) && counts.containsValue(1)) {
    		this.ranking = 9;		// One Pair
    	}
    	
    	else  {
    		this.ranking = 10;		// High Card
    	}
    	
    }
    
    
    public void resetHashMap() {
    	Value[] this_hand_enum_values = Card.Value.values();
    	for(int i = 0; i < cards.length; i++) {
    		if(!counts.containsKey(cards[i].value)) {
    			counts.put(cards[i].value, 0);
    		}
    		else {
    			counts.put(cards[i].value, 0);
    		}   			
    	}
    	System.out.println();
    }
    
    
    public boolean is_equal(Hand H) {
    	if(this.highCard != H.highCard) {
			return false;
		}
		else {
			return true;
		}
    }
    
    
    public boolean is_better_than(Hand H) {	  	
    	Card[] this_sorted_cards = sort(this);
    	Card[] h_sorted_cards = sort(H);
    	
    	this.getRanking();
    	H.getRanking();    	
    	
    	//System.out.println("H1 High Card" + " " + this.highCard + " " + "H1 Hand Ranking" + " " + this.ranking);		// Ranking and HighCard    	
    	//System.out.println("H2 High Card" + " " + H.highCard + " " + "H2 Hand Ranking" + " " + H.ranking);		// Ranking and HighCard
    	
    	
    	if ((this.ranking < H.ranking) || ((this.ranking == H.ranking) && (this.highCard > H.highCard))) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
   
}