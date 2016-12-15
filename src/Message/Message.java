package Message;

import JSON.JSONWriter;
import Message.Interfaces.Response;

import java.util.StringJoiner;

/**
 * Created by Nikolay on 12/14/2016.
 */
public abstract class Message implements Response {

    protected JSONWriter jsonWriter;
    protected StringBuilder message;

    public Message(){
        //this.jsonWriter = new JSONWriter();
        this.message = new StringBuilder();
    }
}
