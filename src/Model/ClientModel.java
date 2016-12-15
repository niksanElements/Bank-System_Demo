package Model;

import Data.Client;
import Resurses.Crypting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nikolay on 12/14/2016.
 */
public class ClientModel extends BaseModel {

    public ClientModel() {
        super();
    }

    // It has to be add password checking.
    public Client getClient(String userName, String password) {
        String sql = "SELECT id,password,firstName,lastName FROM clients WHERE userName = \"" + userName + "\"";
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            //if (resultSet.getFetchSize() == 1) {
                resultSet.first();
                String primeryKey = resultSet.getString("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String currentPassword = resultSet.getString("password");
                //if (Crypting.equal(password, currentPassword)) {
                    return new Client(primeryKey, userName, firstName, lastName);
                //}
            //}
        } catch (SQLException e) {
            e.printStackTrace(); // or do something else
        }
        return null;
    }

    public String authenticatUserName(String userName, String password) {
        String sql = "SELECT password,id FROM clients WHERE userName = " + userName;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            stmt = this.conn.createStatement();
            resultSet = stmt.executeQuery(sql);
            if (resultSet.getFetchSize() == 1) {
                resultSet.first();
                String id = resultSet.getString("id");
                String currentPassword = resultSet.getString("password");
                if (Crypting.equal(password, currentPassword)) {
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // or do something else
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
