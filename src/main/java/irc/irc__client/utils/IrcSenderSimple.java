package irc.irc__client.utils;

import java.net.*;
import java.io.*;
import java.util.*;


public class IrcSenderSimple {

    static void sendString(BufferedWriter bw, String str) {
        try {
            bw.write(str + "\r\n");
            bw.flush();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String[] args) {
        // write your code here
        try{

            String server = "irc.irchighway.net";
            int port = 6661;
            String nickname = "Wasyli";
            String channel = "#wfmi";
            String message = "Jestę hakierę";

            Socket socket = new Socket(server, port);
            System.out.println("*** Connected to server ***");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            System.out.println("*** Opened OutputStreamWriter ***");
            BufferedWriter bwriter = new BufferedWriter(outputStreamWriter);
            System.out.println("*** Opened BufferedWriter ***");
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader breader = new BufferedReader(inputStreamReader);

            sendString(bwriter, "NICK " + nickname);
            sendString(bwriter, "USER testbot 0 * : Wasyli");

            //Read lines from server until it tells us that we have connection
            String line = null;
            while((line = breader.readLine()) != null) {
                if(line.indexOf("004") >= 0) {
                    //We are logged in
                    break;
                }
                else if(line.indexOf("433") >= 0) {
                    System.out.println("Nickname already in use.");
                    return;
                }
            }

            sendString(bwriter, "JOIN " + channel);

            sendString(bwriter, "PRIVMSG " + channel + " :" + message);

            // Keep reading lines from the server
            while((line = breader.readLine()) != null) {
                if(line.toLowerCase().startsWith("ping ")) {
                    sendString(bwriter, "PONG " + line.substring(5));
                    sendString(bwriter, "PRIVMSG " + channel + " : I got pinged!");
                } else {
                    System.out.println(line);
                }
            }
            bwriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}