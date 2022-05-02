package uta.cse3310;

public class GameEvent {
  GameEventType event;
  int ante;

  public enum GameEventType {
    ANTE;

    GameEventType() {}
  }
}
