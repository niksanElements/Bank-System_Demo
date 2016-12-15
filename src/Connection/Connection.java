package Connection;

import Data.Client;
import Message.LogInMessage;
import Message.MessageHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Connection(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            MessageHandler messageHandler = new MessageHandler(in,out);
            System.out.println("Yes you are user with id: "+ messageHandler.getId());
            messageHandler.run();
        }
        catch(IOException e){
            System.out.println("Something is wrong with the socket!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                this.in.close();
                this.out.close();
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
