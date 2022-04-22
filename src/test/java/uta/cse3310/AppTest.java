package uta.cse3310;

public class AppTest {

  /*
   * // reference
   * import com.google.gson.Gson;
   * import com.google.gson.GsonBuilder;
   *
   * import org.apache.logging.log4j.LogManager;
   * import org.apache.logging.log4j.Logger;
   *
   * import poker.Hand;
   * import poker.Card;
   *
   * import static org.junit.jupiter.api.Assertions.assertTrue;
   *
   * import org.junit.jupiter.api.Test;
   *
   * class Assignment1Test {
   * // Define some hands as json strings that can be used for many tests
   * private final String four_5s =
   * "{'cards':[{'suite':'SPADES','value':'FIVE'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";
   * private final String three_5s =
   * "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";
   *
   * private final String straight =
   * "{'cards':[{'suite':'SPADES','value':'FIVE'},{'suite':'DIAMONDS','value':'SIX'},{'suite':'CLUBS','value':'SEVEN'},{'suite':'HEARTS','value':'EIGHT'},{'suite':'SPADES','value':'NINE'}]}";
   * private final String spadesStraightFlush =
   * "{'cards':[{'suite':'SPADES','value':'FIVE'},{'suite':'SPADES','value':'SIX'},{'suite':'SPADES','value':'SEVEN'},{'suite':'SPADES','value':'EIGHT'},{'suite':'SPADES','value':'NINE'}]}";
   *
   * private final String royalFlush =
   * "{'cards':[{'suite':'HEARTS','value':'ACE'},{'suite':'HEARTS','value':'KING'},{'suite':'HEARTS','value':'QUEEN'},{'suite':'HEARTS','value':'JACK'},{'suite':'HEARTS','value':'TEN'}]}";
   * private final String heartsStraightFlush =
   * "{'cards':[{'suite':'HEARTS','value':'FIVE'},{'suite':'HEARTS','value':'SIX'},{'suite':'HEARTS','value':'SEVEN'},{'suite':'HEARTS','value':'EIGHT'},{'suite':'HEARTS','value':'NINE'}]}";
   *
   * private final String twoPair =
   * "{'cards':[{'suite':'SPADES','value':'ACE'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FOUR'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";
   * private final String threeOfAKind =
   * "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";
   *
   * private final String highCardLow =
   * "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'TWO'},{'suite':'SPADES','value':'KING'}]}";
   * private final String highCardHigh =
   * "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'TWO'},{'suite':'SPADES','value':'ACE'}]}";
   *
   * private final String fullHouse =
   * "{'cards':[{'suite':'SPADES','value':'KING'},{'suite':'DIAMONDS','value':'KING'},{'suite':'CLUBS','value':'KING'},{'suite':'HEARTS','value':'TWO'},{'suite':'SPADES','value':'TWO'}]}";
   * private final String fourOfAKind =
   * "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'CLUBS','value':'FOUR'},{'suite':'HEARTS','value':'FOUR'},{'suite':'HEARTS','value':'KING'}]}";
   *
   * private final String onePair =
   * "{'cards':[{'suite':'SPADES','value':'ACE'},{'suite':'DIAMONDS','value':'ACE'},{'suite':'CLUBS','value':'QUEEN'},{'suite':'HEARTS','value':'TWO'},{'suite':'DIAMONDS','value':'THREE'}]}";
   * private final String flush =
   * "{'cards':[{'suite':'SPADES','value':'ACE'},{'suite':'SPADES','value':'THREE'},{'suite':'SPADES','value':'QUEEN'},{'suite':'SPADES','value':'TWO'},{'suite':'SPADES','value':'JACK'}]}";
   *
   * private final String fullHouse2 =
   * "{'cards':[{'suite':'SPADES','value':'KING'},{'suite':'CLUBS','value':'KING'},{'suite':'CLUBS','value':'KING'},{'suite':'HEARTS','value':'TWO'},{'suite':'SPADES','value':'TWO'}]}";
   * private final String straight2 =
   * "{'cards':[{'suite':'DIAMONDS','value':'ACE'},{'suite':'DIAMONDS','value':'TWO'},{'suite':'SPADES','value':'THREE'},{'suite':'HEARTS','value':'FOUR'},{'suite':'HEARTS','value':'FIVE'}]}";
   *
   * private final String royalFlush2 =
   * "{'cards':[{'suite':'HEARTS','value':'ACE'},{'suite':'HEARTS','value':'KING'},{'suite':'HEARTS','value':'QUEEN'},{'suite':'HEARTS','value':'JACK'},{'suite':'HEARTS','value':'TEN'}]}";
   * private final String fourOfAkind2 =
   * "{'cards':[{'suite':'SPADES','value':'SIX'},{'suite':'DIAMONDS','value':'SIX'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'SIX'},{'suite':'HEARTS','value':'ACE'}]}";
   *
   * private final String lowCard =
   * "{'cards':[{'suite':'DIAMONDS','value':'TWO'},{'suite':'CLUBS','value':'KING'},{'suite':'HEARTS','value':'QUEEN'},{'suite':'DIAMONDS','value':'JACK'},{'suite':'DIAMONDS','value':'TEN'}]}";
   * private final String flush2 =
   * "{'cards':[{'suite':'CLUBS','value':'FOUR'},{'suite':'CLUBS','value':'THREE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'CLUBS','value':'SIX'},{'suite':'CLUBS','value':'TEN'}]}";
   *
   * private static final Logger LOGGER =
   * LogManager.getLogger(Assignment1Test.class);
   *
   * @Test
   * void lowcard_vs_flush2() {
   * LOGGER.debug(" flush 2 test");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(lowCard, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(flush2, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void royalFlush_vs_fourofaKind2() {
   * LOGGER.debug(" Royal flush 2 test");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(fourOfAkind2, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(royalFlush2, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void fullhouse2_vs_straight2() {
   * LOGGER.debug(" fullhouse 2 test");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(straight2, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(fullHouse2, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void flush_vs_pair() {
   * LOGGER.debug(" flush vs pair test ");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(onePair, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(flush, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void fullHouse_vs_fourOfAKind() {
   * LOGGER.debug("fullhouse vs four of a kind test ");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(fullHouse, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(fourOfAKind, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void TWO_PAIR_VS_3_OF_A_KIND() {
   * LOGGER.debug(" 3 of a kind test ");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(twoPair, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(threeOfAKind, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void HIGHCARD_VS_HIGHCARD() {
   * LOGGER.debug(" high card vs high card test ");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(highCardHigh, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(highCardLow, Hand.class);
   *
   * // Now test it
   * assertTrue(H1.is_better_than(H2)); // uncomment when the is_better_than
   * function is working !
   * // assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void straight_vs_straightflush() {
   * LOGGER.debug(" straight Flush test");
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(straight, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(spadesStraightFlush, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   *
   * @Test
   * void four_of_a_kind_better_then_3_of_a_kind() {
   * // Use the logger to see what is happening
   * // with a test when it fails. it is written
   * // to a log file.
   *
   * LOGGER.debug(" in the 4 of a kind test");
   *
   * // turn it into json
   * Gson gson = new Gson();
   *
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(four_5s, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(three_5s, Hand.class);
   *
   * // Now test it
   * assertTrue(H1.is_better_than(H2)); // uncomment when the is_better_than
   * function is working !
   * // assertTrue(!H2.is_better_than(H1));
   * }
   *
   * /*
   *
   * @Test
   * void run_a_lot_of_them()
   * {
   *
   * }
   *
   *
   * @Test
   * void royalFlushBetterThanAny() {
   * LOGGER.debug(" in the Royal Flush test");
   * // turn it into json
   * Gson gson = new Gson();
   * /
   * Hand H1 = new Hand();
   * H1 = gson.fromJson(heartsStraightFlush, Hand.class);
   *
   * Hand H2 = new Hand();
   * H2 = gson.fromJson(royalFlush, Hand.class);
   *
   * // Now test it
   * // assertTrue(H1.is_better_than(H2)); //uncomment when the is_better_than
   * // function is working !
   * assertTrue(H2.is_better_than(H1));
   * }
   * }
   */
}
