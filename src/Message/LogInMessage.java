package Message;

import Data.Client;

import java.io.PrintWriter;

/**
 * Created by Nikolay on 12/14/2016.
 */
public class LogInMessage extends Message {
    private Client client;

    public LogInMessage(Client client){
        super();
        this.client = client;
    }

    public Client getClient(){return this.client;}

    @Override
    public void runResponse(PrintWriter out) {
        makeLogInReponse();
        out.println(this.message.toString());
    }

    private void makeLogInReponse() {
        this.message.append("login true");
    }
}
