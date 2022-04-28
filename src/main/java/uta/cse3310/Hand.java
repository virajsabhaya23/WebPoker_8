// Java class for handling ranking of a hand.

package uta.cse3310;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import static uta.cse3310.Card.*;

public class Hand extends Deck {
	public ArrayList<Card> cards;
	public int ranking;
	public int highCard;
	private final HashMap<Value, Integer> counts = new HashMap<>();

	/**
	 * Constructor to initialize Hand class attribute with 5 cards. Initial capacity
	 * exists to minimize re-allocations.
	 */
	public Hand() {
		this.cards = new ArrayList<>(5);
	}

	public void getRanking() {
		int spadesCount = 0;
		int heartsCount = 0;
		int clubsCount = 0;
		int diamondsCount = 0;

		for (int j = 0; j < 5; j++) {
			if (this.cards.get(j).suit == Card.Suit.valueOf("SPADES")) {
				spadesCount++;
			} else if (this.cards.get(j).suit == Card.Suit.valueOf("HEARTS")) {
				heartsCount++;
			} else if (this.cards.get(j).suit == Card.Suit.valueOf("CLUBS")) {
				clubsCount++;
			} else {
				diamondsCount++;
			}
		}

		Value[] this_hand_enum_values = Card.Value.values();
		for (Card card : this.cards) {
			if (!counts.containsKey(card.value)) {
				counts.put(card.value, 1);
			} else {
				counts.put(card.value, counts.get(card.value) + 1);
			}
		}

		if (counts.containsKey(Value.ACE) && counts.containsKey(Value.KING) && counts.containsKey(Value.QUEEN)
				&& counts.containsKey(Value.JACK) && counts.containsKey(Value.TEN)
				&& ((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
			this.ranking = 1; // Royal Flush
		}
//
		else if ((!counts.containsValue(4) && !counts.containsValue(3) && !counts.containsValue(2))
				&& ((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
			this.ranking = 2; // Straight Flush
		}

		else if (counts.containsValue(4)) {
			this.ranking = 3; // Four of a Kind
		}

		else if ((counts.containsValue(3)) && counts.containsValue(2)) {
			this.ranking = 4; // Full House
		}

		else if (((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
			this.ranking = 5; // Flush
		}

		else if (!counts.containsValue(4) && !counts.containsValue(3) && !counts.containsValue(2)) {
			this.ranking = 6; // Straight
		}

		else if (counts.containsValue(3) && !counts.containsValue(2)) {
			this.ranking = 7; // Three of a Kind
		}

		else if (counts.containsValue(2) && !counts.containsValue(4) && !counts.containsValue(3)
				&& counts.containsValue(1)) {
			this.ranking = 8; // Two Pair
		}

		else if (counts.containsValue(2) && !counts.containsValue(3) && counts.containsValue(1)) {
			this.ranking = 9; // One Pair
		}

		else {
			this.ranking = 10; // High Card
		}
	}

//	public Hand sort(Hand hnd) {
//		int i, j;
//		Value[] this_hand_enum_values = Card.Value.values();
//
//		// Sort
//		for (i = 0; i < 5; i++) {
//			int min_ind = i;
//			for (j = i + 1; j < 5; j++) {
//				if (Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[j].value) > Arrays
//						.asList(this_hand_enum_values)
//						.indexOf(hnd.cards[min_ind].value)) {
//					min_ind = j;
//				}
//
//			}
//			Card.Value temp = hnd.cards[min_ind].value;
//			hnd.cards[min_ind].value = hnd.cards[i].value;
//			hnd.cards[i].value = temp;
//
//		}
//		hnd.highCard = Arrays.asList(this_hand_enum_values).indexOf(hnd.cards[0].value);
//		this.getRanking();
//		return hnd;
//	}

	public String asJSONString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

//	public Hand splitCardsForPlayer(int Id) {
//		// Deck deck = new Deck(); // Might need to change this later......
//		// use player's hand
//		// hnd.cards = hand;
//		Hand hand = new Hand();
//
//		System.out.println("ID # = " + Id);
//		if (Id == 0) {
//			for (int i = 0; i < 5; i++) {
//				this.cards[i] = deck.cards[i];
//			}
//			hand = sort(this); // testing sort func()
//			for (int i = 0; i < 5; i++) {
//				System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
//			}
//			return hand;
//		} else if (Id == 1) {
//			System.out.println("I am past the first loop :)");
//			for (int i = 0; i < 5; i++) {
//				this.cards[i] = deck.cards[i + 5];
//			}
//			hand = sort(this); // testing sort func()
//			for (int i = 0; i < 5; i++) {
//				System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
//			}
//			return hand;
//		} else if (Id == 2) {
//			for (int i = 0; i < 5; i++) {
//				this.cards[i] = deck.cards[i + 10];
//			}
//			hand = sort(this); // testing sort func()
//			for (int i = 0; i < 5; i++) {
//				System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
//			}
//			return hand;
//		} else if (Id == 3) {
//			for (int i = 0; i < 5; i++) {
//				this.cards[i] = deck.cards[i + 15];
//			}
//			hand = sort(this); // testing sort func()
//			for (int i = 0; i < 5; i++) {
//				System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
//			}
//			return hand;
//		} else if (Id == 4) {
//			for (int i = 0; i < 5; i++) {
//				this.cards[i] = deck.cards[i + 20];
//			}
//			hand = sort(this); // testing sort func()
//			for (int i = 0; i < 5; i++) {
//				System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
//			}
//			return hand;
//		} else {
//			System.out.println("The if statement don't work");
//			return null;
//		}
//	}

}
