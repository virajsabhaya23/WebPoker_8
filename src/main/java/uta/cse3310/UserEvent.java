package uta.cse3310;

public class UserEvent {

    public enum UserEventType {
        NAME, STAND, HIT, CALL, DEAL;

        private UserEventType() {
        }
    };

    UserEventType event;
    int playerID;
    String name;
    String stand;
    String hit;
    String call;
    String deal;

    public UserEvent() {
    }

}
