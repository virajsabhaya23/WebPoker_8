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
    game.addPlayer(p);
    game.addPlayer(p);

    System.out.println(p.Id);

    assertEquals(3, game.numPlayers);
  }

  @Test
  public void removePlayerTest() {
    ArrayList<Player> players = new ArrayList<>();
    final Game game = new Game();
    Player p = new Player();
    game.addPlayer(p);
    game.addPlayer(p);
    game.addPlayer(p);

    game.removePlayer(0);
    game.removePlayer(1);
    game.removePlayer(2);

    System.out.println(p.Id);

    assertEquals(0, game.numPlayers);
  }
}
