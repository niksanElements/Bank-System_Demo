package Data;

import java.io.Serializable;

/**
 * Represents a client that has a {@link PrimaryKey} as unique identifier.
 *
 * @author iliyan-kostov <iliyan.kostov.gml@gmail.com>
 */
public class Client implements Serializable {

    protected String userName;
    protected  String id;
    /**
     * The client first name.
     */
    protected String firstName;

    /**
     * The client last name.
     */
    protected String lastName;


    public Client(String id,String userName,String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the client first name.
     *
     * @return the client first name.
     */
    public final String getFirstName() {
        return this.firstName;
    }
    public final String getId() {
        return this.id;
    }
    /**
     * Returns the client last name.
     *
     * @return the client last name.
     */
    public final String getLastName() {
        return this.lastName;
    }

    public final String getUserName(){ return this.userName; }
}
