package Clinic.Core;


import java.io.Serializable;
import java.lang.reflect.Type;

import Util.UserType;

/**
 * Token.java - used to store token data for logged in users
 */
public class Token implements Serializable{

    private UserType type;
    private int userID;

    /**
     * The constructor for the login token
     * @param type Type of user logged in
     * @param userID Their unique id
     */
    public Token (UserType type, int userID) {
        this.type = type;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
