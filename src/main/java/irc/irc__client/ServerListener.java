package irc.irc__client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerListener extends Thread implements Runnable {

    private BufferedReader bin = null;
    private List<IServerMessageListener> messageListeners;
    private List<IServerNewUserListener> newUsersListeners;
    private Socket socket;
    

    public ServerListener(Socket irc) throws IOException {
        socket = irc;
        messageListeners = new ArrayList<>();
        newUsersListeners = new ArrayList<>();
        bin = new BufferedReader(new InputStreamReader(irc.getInputStream()));
    }
    
    public void registerMessageListener(IServerMessageListener listener) {
        messageListeners.add(listener);
    }
    
    @Override
    public void run() {
        while(true) {
            try{
                String serverMessage = bin.readLine();
                if(serverMessage != null) {
                    String user = "someUser";
                    String message = serverMessage;
                    // Leśmin tu wyggogluj jak przy użyciu regexp wyciagnąć user name i message sie nauczysz czegos pozytecznego :)
                    for (IServerMessageListener l: messageListeners) {
                        l.onMessage(user, message);
                    }
                }
            } catch(IOException e) {
                System.out.println("Cannot read lines from server.");
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void addLoggedUser(String userName) {
        for (IServerNewUserListener l: newUsersListeners) {
            l.onNewUser(userName);
        }
    }
    
    public void registerNewUserListener(IServerNewUserListener listener) {
        newUsersListeners.add(listener);
    }
}
