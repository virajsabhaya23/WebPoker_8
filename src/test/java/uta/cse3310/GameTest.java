package uta.cse3310;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

  @Test
  public void addPlayer() {
    final Game game = new Game();
    Player p = new Player();
    game.addPlayer(p);
    game.addPlayer(p);
    game.addPlayer(p);
    assertEquals(3, game.numPlayers);
  }

  @Test
  public void removePlayer() {
    final Game game = new Game();
    Player p = new Player();
    game.addPlayer(p);
    game.addPlayer(p);
    game.addPlayer(p);

    game.removePlayer(0);
    game.removePlayer(1);
    game.removePlayer(2);
    assertEquals(0, game.numPlayers);
  }

  @Test
  public void testStateExport() {
    final Game game = new Game();


  }
}
