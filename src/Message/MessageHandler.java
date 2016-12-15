package Message;

import Conroller.LogInController;
import Data.Client;
import Message.Interfaces.Action;
import Message.Interfaces.Response;
;
import java.io.*;
import java.util.TreeMap;

/**
 * Created by Nikolay on 12/14/2016.
 */
public class MessageHandler {

    private static TreeMap<String,Action> options;

    private BufferedReader in;
    private PrintWriter out;

    private Client client;
    private boolean isRunning;

    public MessageHandler(BufferedReader in,PrintWriter out) throws ClassNotFoundException, IOException {
        this.in = in;
        this.out = out;
        this.client = logIn();
        if(this.client == null){
            throw new ClassNotFoundException();
        }
    }
    public boolean run() throws IOException {
        this.isRunning = true;
        while(isRunning){
            String requst = in.readLine();
            Response res = this.options.get(requst).runAction();
            res.runResponse(out);
        }
        return false;
    }

    private Client logIn() throws IOException {
        String flag = this.in.readLine();
        if(flag.equals("login")){
            String userName = this.in.readLine();
            String password = this.in.readLine();
            LogInMessage res =(LogInMessage) new LogInController(userName,password).runAction();
            res.runResponse(this.out);
            return res.getClient();
        }
        return null;
    }

    public String getId(){ return this.client.getId(); }
}
