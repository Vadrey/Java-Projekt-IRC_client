package irc.irc__client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerListener extends Thread implements Runnable {

    private Socket socket;
    private String serverMessage = null;
    private BufferedReader bin = null;

    ServerListener(Socket irc) throws IOException {
        socket = irc;
        bin = new BufferedReader(new InputStreamReader(irc.getInputStream()));
    }

    @Override
    public void run() {
        while(true) {
            try{
                serverMessage = bin.readLine();
                if(serverMessage != null) {
                    System.out.println(serverMessage);
                }
            } catch(IOException e) {
                    System.out.println("Cannot read lines from server.");
                }
            }
        }
}
