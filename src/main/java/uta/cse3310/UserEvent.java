package uta.cse3310;

public class UserEvent {
  UserEventType event;
  int playerID;
  String name;

  public UserEvent() {}

  public enum UserEventType {
    NAME,
    STAND, // aka check
    HIT, // aka bet
    CALL,
    DEAL,
    JOIN,
    LEAVE;

    UserEventType() {}
  }
}
