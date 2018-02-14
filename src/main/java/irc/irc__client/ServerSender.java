package irc.irc__client;

import java.io.*;
import java.net.Socket;

public class ServerSender extends Thread {

    private Socket socket;
    private String command = null;
    private BufferedWriter wout = null;
    private BufferedReader sysIn = null;

    ServerSender(Socket irc) throws IOException {
        socket = irc;
        wout = new BufferedWriter(new OutputStreamWriter(irc.getOutputStream()));
        sysIn = new BufferedReader(new InputStreamReader(System.in));
        command = "NICK Wasyli";
        sendMsg();
        command = "USER testbot 0 * : Wasyli";
        sendMsg();
        command = "JOIN #wfmi";
        sendMsg();
        command = null;
    }

    void sendMsg() {
        try{
            wout.write(command + "\r\n");
            wout.flush();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }

    }

    @Override
    public void run() {
        while(true) {
            try{
                command = sysIn.readLine();
                if(command != null) {
                    sendMsg();
                }
            } catch(IOException e) {
                System.out.println("Error while writing command to the system.");
            }
        }
    }
}
