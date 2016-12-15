package Conroller;

import Data.Client;
import Message.Interfaces.Response;
import Message.LogInMessage;
import Model.ClientModel;

/**
 * Created by Nikolay on 12/14/2016.
 */
public class LogInController extends BaseController {

    private String userName;
    private String password;
    private Client user;
    private ClientModel clientModel;

    public LogInController(String userName,String password){
        this.userName = userName;
        this.password = password;
        this.clientModel = new ClientModel();
    }

    @Override
    public Response runAction() {
        this.user = this.clientModel.getClient(this.userName,this.password);
        this.clientModel.close();
        return new LogInMessage(this.user);
    }
}
