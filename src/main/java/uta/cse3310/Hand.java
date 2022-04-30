// Java class for handling ranking of a hand.

package uta.cse3310;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static uta.cse3310.Card.*;

public class Hand {
	public ArrayList<Card> cards;
	public int ranking;
	public int highCard;
	boolean twoPair = false;
	boolean isFlush = false;
	boolean isStraight = false;
	boolean isRoyalFlush = false;
	public int counter = 0;
	private final HashMap<Value, Integer> counts = new HashMap<>();

	/**
	 * Constructor to initialize Hand class attribute with 5 cards.
	 * Initial capacity exists to minimize re-allocations.
	 */
	public Hand() {
		this.cards = new ArrayList<>(5);

		// Arrays.sort(Card.Suit.values());
		// Arrays.sort(Card.Value.values());
		// this.stream().forEach(System.out::println);
	}

	public Hand generateHand() {
		Hand hand = new Hand();
		// TODO: Create 5 cards from Deck
		return hand;
	}

	public void sort() {
		int i, j;
		Value[] this_hand_enum_values = Card.Value.values();

		// Sort
		for (i = 0; i < 5; i++) {
			int min_ind = i;
			for (j = i + 1; j < 5; j++) {
				if (Arrays.asList(this_hand_enum_values).indexOf(this.cards.get(j).value) > Arrays
						.asList(this_hand_enum_values)
						.indexOf(this.cards.get(min_ind).value)) {
					min_ind = j;
				}

			}
			Card.Value temp = this.cards.get(min_ind).value;
			this.cards.get(min_ind).value = this.cards.get(i).value;
			this.cards.get(i).value = temp;

		}
		this.highCard = Arrays.asList(this_hand_enum_values).indexOf(this.cards.get(0).value);
	}

	// I am sorry for your eyes... the caveman in me had enough... i apologize for
	// the following function
	// Going to check the highest card and use a switch thingy hopefully the caveman
	// in me is good lol
	public void straightChecker() {

		int i;
		Hand straight = new Hand();

		switch (this.cards.get(0).value) {
			// ACE, KING, QUEEN, JACK, 10
			case ACE:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.KING));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.QUEEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TEN));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
					isRoyalFlush = true;
				}
				counter = 0;
				break;

			case KING:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.KING));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.QUEEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case QUEEN:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.QUEEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case JACK:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case TEN:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SIX));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case NINE:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SIX));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case EIGHT:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SIX));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FOUR));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case SEVEN:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SIX));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FOUR));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.THREE));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;

			case SIX:
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.SIX));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.FOUR));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.THREE));
				straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TWO));
				for (i = 0; i < 5; i++) {
					if (straight.cards.get(i).value == this.cards.get(i).value) {
						counter++;
					}
				}
				if (counter == 5) {
					isStraight = true;
				}
				counter = 0;
				break;
		}
	}

	public void getRanking() {

		int spadesCount = 0;
		int heartsCount = 0;
		int clubsCount = 0;
		int diamondsCount = 0;

		this.sort();

		for (int j = 0; j < 5; j++) {
			// System.out.println(this.cards.get(j).value);
			if (this.cards.get(j).suit == Card.Suit.valueOf("SPADES")) {
				spadesCount++;
			} else if (this.cards.get(j).suit == Card.Suit.valueOf("HEARTS")) {
				heartsCount++;
			} else if (this.cards.get(j).suit == Card.Suit.valueOf("CLUBS")) {
				clubsCount++;
			} else {
				diamondsCount++;
			}
			if (((spadesCount == 5) || (heartsCount == 5) || (clubsCount == 5) || (diamondsCount == 5))) {
				isFlush = true;
			}

		}

		ArrayList<Card> cardArrayList = this.cards;
		for (int i = 0; i < cardArrayList.size(); i++) {
			Card card = cardArrayList.get(i);
			if (!counts.containsKey(card.value)) {
				counts.put(card.value, 1);
			} else {
				if (((counts.get(card.value) + 1) == 2) && (counts.containsValue(2))) { // if pair detected
					twoPair = true;
				} else {
					counts.put(card.value, counts.get(card.value) + 1);
				}
			}
			// This is where the issue is...
			// Need way to check what the index of the
			// if (previousValue - counts.get(card.value) == 1){
			// straightChecker++;
			// }
			// previousValue = counts.get(card.value);
		}

		this.straightChecker();

		if (isRoyalFlush && isFlush) {
			this.ranking = 1; // Royal Flush
		}

		else if (isStraight && isFlush) {
			this.ranking = 2; // Straight Flush
		}

		else if (counts.containsValue(4)) {
			this.ranking = 3; // Four of a Kind
		}

		else if ((counts.containsValue(3)) && counts.containsValue(2)) {
			this.ranking = 4; // Full House
		}

		else if (isFlush) {
			this.ranking = 5; // Flush
		}

		else if (isStraight) {
			this.ranking = 6; // Straight
		}

		else if (counts.containsValue(3) && !counts.containsValue(2)) {
			this.ranking = 7; // Three of a Kind
		}

		else if (counts.containsValue(2) && !counts.containsValue(4) && !counts.containsValue(3)
				&& twoPair) {
			this.ranking = 8; // Two Pair
		}

		else if (counts.containsValue(2)) {
			this.ranking = 9; // One Pair
		}

		else {
			this.ranking = 10; // High Card
		}
	}

	// public boolean is_better_than(Hand H) {
	// Card[] this_sorted_cards = sort(this);
	// Card[] h_sorted_cards = sort(H);
	//
	// this.getRanking();
	// H.getRanking();
	//
	// if ((this.ranking < H.ranking) || ((this.ranking == H.ranking) &&
	// (this.highCard > H.highCard))) {
	// return true;
	// }
	// else {
	// return false;
	// }
	// }

	// public Hand splitCardsForPlayer(int Id) {
	// // Deck deck = new Deck(); // Might need to change this later......
	// // use player's hand
	// // hnd.cards = hand;
	// Hand hand = new Hand();
	//
	// System.out.println("ID # = " + Id);
	// if (Id == 0) {
	// for (int i = 0; i < 5; i++) {
	// this.cards[i] = deck.cards[i];
	// }
	// hand = sort(this); // testing sort func()
	// for (int i = 0; i < 5; i++) {
	// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
	// }
	// return hand;
	// } else if (Id == 1) {
	// System.out.println("I am past the first loop :)");
	// for (int i = 0; i < 5; i++) {
	// this.cards[i] = deck.cards[i + 5];
	// }
	// hand = sort(this); // testing sort func()
	// for (int i = 0; i < 5; i++) {
	// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
	// }
	// return hand;
	// } else if (Id == 2) {
	// for (int i = 0; i < 5; i++) {
	// this.cards[i] = deck.cards[i + 10];
	// }
	// hand = sort(this); // testing sort func()
	// for (int i = 0; i < 5; i++) {
	// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
	// }
	// return hand;
	// } else if (Id == 3) {
	// for (int i = 0; i < 5; i++) {
	// this.cards[i] = deck.cards[i + 15];
	// }
	// hand = sort(this); // testing sort func()
	// for (int i = 0; i < 5; i++) {
	// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
	// }
	// return hand;
	// } else if (Id == 4) {
	// for (int i = 0; i < 5; i++) {
	// this.cards[i] = deck.cards[i + 20];
	// }
	// hand = sort(this); // testing sort func()
	// for (int i = 0; i < 5; i++) {
	// System.out.println(this.cards[i].value + "-" + this.cards[i].suit);
	// }
	// return hand;
	// } else {
	// System.out.println("The if statement don't work");
	// return null;
	// }
	// }

	// // Hand straight = new Hand(); // ACE, KING, QUEEN, JACK, 10
	// straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
	// straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.KING));
	// straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.QUEEN));
	// straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
	// straight.cards.add(new Card(Card.Suit.HEARTS, Card.Value.TEN));

	// // Hand straight1 = new Hand(); // KING, QUEEN, JACK, 10, 9
	// // Hand straight2 = new Hand(); // QUEEN, JACK, 10, 9, 8
	// // Hand straight3 = new Hand(); // JACK, 10, 9, 8, 7
	// // Hand straight4 = new Hand(); // 10, 9, 8, 7, 6
	// // Hand straight5 = new Hand(); // 9, 8, 7, 6, 5
	// // Hand straight6 = new Hand(); // 8, 7, 6, 5, 4
	// // Hand straight7 = new Hand(); // 7, 6, 5, 4, 3
	// // Hand straight8 = new Hand(); // 6, 5, 4, 3 ,2
	// //Hand straight9 = new Hand(); // ACE, 5, 4, 3 ,2

	public String asJSONString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
