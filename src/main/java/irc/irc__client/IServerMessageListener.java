package irc.irc__client;

public interface IServerMessageListener {

    void onMessage(String userName, String message);
}
