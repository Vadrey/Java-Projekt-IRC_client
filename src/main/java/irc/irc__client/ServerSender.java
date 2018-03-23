package irc.irc__client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSender {

    private BufferedWriter wout = null;

    ServerSender(Socket irc) throws IOException {
        wout = new BufferedWriter(new OutputStreamWriter(irc.getOutputStream()));
        sendMsg("NICK", "Wasyli");
        sendMsg("USER", "testbot 0 * : Wasyli");
    }

    public void sendMsg(String user, String messageToBeSent) {
        try{
            wout.write(":" + user + "! " + messageToBeSent + "\r\n");
            wout.flush();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }

    }

}
