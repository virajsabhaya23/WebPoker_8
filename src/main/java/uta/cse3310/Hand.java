// Java class for handling ranking of a hand.

package uta.cse3310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uta.cse3310.*;
import uta.cse3310.Card.Value;

public class Hand {
	// private transient int i=10;
	// marked transient they will not serialized / deserialized

	public Card[] cards;
	public int ranking;
	public int highCard;

	public Hand() {
	}

}