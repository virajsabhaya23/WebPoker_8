// Java class for handling ranking of a hand.

package uta.cse3310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
  public ArrayList<Card> cards;
  public int ranking;
  public int highestCard;

  /** Construct a Hand with 5 (empty) cards. Initialization exists to minimize re-allocations. */
  public Hand() {
    this.cards = new ArrayList<>(5);
  }

  /**
   * Get the numerical ranking of the hand. Adds a ranking to the Hand. The higher the integer, the
   * higher the hand.
   */
  public void getRanking() {
    if (this.isFlush() && this.isStraight() && this.getHighestCard() == 12) {
      this.ranking = 1; // Royal flush
    } else if (this.isStraight() && this.isFlush()) {
      this.ranking = 2; // Straight flush
    } else if (this.isFourOfAKind()) {
      this.ranking = 3; // Four of a kind
    } else if (this.isFullHouse()) {
      this.ranking = 4; // Full house
    } else if (this.isFlush()) {
      this.ranking = 5; // Flush
    } else if (this.isStraight()) {
      this.ranking = 6; // Straight
    } else if (this.isThreeOfAKind()) {
      this.ranking = 7; // Three of a kind
    } else if (this.isTwoPair()) {
      this.ranking = 8; // 2 pairs
    } else if (this.isOnePair()) {
      this.ranking = 9; // 1 pair
    } else {
      this.ranking = 10; // only thing left is high card?
    }
  }

  /**
   * Simply sorts the Hand values from lowest to highest.
   *
   * @return Ordinal of the highest position.
   */
  public int getHighestCard() {
    Collections.sort(this.cards);
    highestCard = this.cards.get(4).getValue().ordinal();
    return highestCard;
  }

  /**
   * Checks for 5 consecutive matching suits.
   *
   * @return True if Hand contains a flush.
   */
  public boolean isFlush() {
    this.cards.sort(Comparator.comparing(Card::getSuit));
    return (this.cards.get(0).suit == this.cards.get(4).suit);
  }

  /**
   * Checks first for an ace. If ace exists, checks for straight from 2-5 and 10-king. If ace does
   * not exist, checks for regular straight.
   *
   * @return True if Hand contains a straight.
   */
  public boolean isStraight() {
    int tmpPosition;
    Collections.sort(this.cards);
    if (this.cards.get(0).value.equals(Card.Value.ACE)) {
      boolean option1 =
          this.cards.get(1).value.equals(Card.Value.TWO)
              && this.cards.get(2).value.equals(Card.Value.THREE)
              && this.cards.get(3).value.equals(Card.Value.FOUR)
              && this.cards.get(4).value.equals(Card.Value.FIVE);
      boolean option2 =
          this.cards.get(1).value.equals(Card.Value.TEN)
              && this.cards.get(2).value.equals(Card.Value.JACK)
              && this.cards.get(3).value.equals(Card.Value.QUEEN)
              && this.cards.get(4).value.equals(Card.Value.KING);
      return (option1 || option2);
    } else {
      tmpPosition = this.cards.get(0).value.ordinal() + 1;
      for (int i = 1; i < 5; i++) {
        if (this.cards.get(i).value.ordinal() != tmpPosition) {
          return false;
        }
        tmpPosition++;
      }
    }
    return true;
  }

  /**
   * Checks if the first four contains the same value or if the last four contains the same value.
   * EZ
   *
   * @return True if Hand contains four of a kind.
   */
  public boolean isFourOfAKind() {
    Collections.sort(this.cards);
    boolean option1 =
        this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal()
            && this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal()
            && this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal();

    boolean option2 =
        this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal()
            && this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal()
            && this.cards.get(2).value.ordinal() == this.cards.get(4).value.ordinal();

    return (option1 || option2);
  }

  /**
   * Checks if three cards in the Hand have the same value AND if the last two have the same value.
   *
   * @return True if Hand contains a full house.
   */
  public boolean isFullHouse() {
    Collections.sort(this.cards);
    boolean option1 =
        this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal()
            && this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal()
            && this.cards.get(3).value.ordinal() == this.cards.get(4).value.ordinal();

    boolean option2 =
        this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal()
            && this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal()
            && this.cards.get(3).value.ordinal() == this.cards.get(4).value.ordinal();
    return (option1 || option2);
  }

  /**
   * Checks the Hand **FIRST** if there is four of a kind or a full house. If not, then checks for
   * three repeating values in the first three, second three, and third three positions.
   *
   * @return True if Hand contains three of a kind.
   */
  public boolean isThreeOfAKind() {
    Collections.sort(this.cards);
    if (this.isFourOfAKind() || this.isFullHouse()) {
      return false;
    }

    boolean option1 =
        this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal()
            && this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal();

    boolean option2 =
        this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal()
            && this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal();

    boolean option3 =
        this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal()
            && this.cards.get(3).value.ordinal() == this.cards.get(4).value.ordinal();

    return (option1 || option2 || option3);
  }

  /**
   * Checks if the Hand **FIRST** contains four of a kind, full house, or three of a kind. Then
   * checks if the first two positions and the subsequent two positions match--across the entire
   * Hand.
   *
   * @return True if Hand contains two pairs.
   */
  public boolean isTwoPair() {
    Collections.sort(this.cards);
    if (this.isFourOfAKind() || this.isFullHouse() || this.isThreeOfAKind()) {
      return false;
    }

    boolean option1 =
        this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal()
            && this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal();

    boolean option2 =
        this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal()
            && this.cards.get(3).value.ordinal() == this.cards.get(4).value.ordinal();

    boolean option3 =
        this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal()
            && this.cards.get(3).value.ordinal() == this.cards.get(4).value.ordinal();

    return (option1 || option2 || option3);
  }

  /**
   * Checks if the Hand **FIRST** contains four of a kind, full house, three of a kind, or two
   * pairs. Then checks across the entire Hand for two matching positions.
   *
   * @return True if Hand contains two pairs.
   */
  public boolean isOnePair() {
    Collections.sort(this.cards);
    if (this.isFourOfAKind() || this.isFullHouse() || this.isThreeOfAKind() || this.isTwoPair()) {
      return false;
    }

    boolean option1 = this.cards.get(0).value.ordinal() == this.cards.get(1).value.ordinal();

    boolean option2 = this.cards.get(1).value.ordinal() == this.cards.get(2).value.ordinal();

    boolean option3 = this.cards.get(2).value.ordinal() == this.cards.get(3).value.ordinal();

    boolean option4 = this.cards.get(3).value.ordinal() == this.cards.get(4).value.ordinal();

    return (option1 || option2 || option3 || option4);
  }
}
