// Java class for handling ranking of a hand.

package uta.cse3310;

import java.util.*;

import static uta.cse3310.Card.Value;

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
	 * Initializes Hand class with 5 cards.
	 * Initialization exists to minimize re-allocations.
	 */
	public Hand() {
		this.cards = new ArrayList<>(5);
	}

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

		// TODO: Better sort, but missing highCard variable
		this.cards.sort(Collections.reverseOrder());

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
}
