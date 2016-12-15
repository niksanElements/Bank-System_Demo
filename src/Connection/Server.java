package Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;


public class Server {
    public static final int PORT = 9004;
    public static HashSet<String> ids = new HashSet<String>();

    public static void main(String[] args) throws IOException{
        System.out.println("The chat server is running!");
        ServerSocket listener = new ServerSocket(PORT);
        try{
            while(true){
                new Connection(listener.accept()).start();
            }
        }
        finally {
            listener.close();
        }
    }

}
