package uta.cse3310;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class GameTest {

  @Test
  public void addPlayerTest() {
    ArrayList<Player> players = new ArrayList<>();
    final Game game = new Game();
    Player p = new Player();
    game.addPlayer(p);

    assertEquals(1, players.size());

  }

}
