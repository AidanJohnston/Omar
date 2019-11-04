package Clinic.Core;


import java.lang.reflect.Type;

/**
 * Token.java - used to store token data for logged in users
 */
public class Token {

    private Type type;
    private int userID;

    /**
     * The constructor for the login token
     * @param type Type of user logged in
     * @param userID Their unique id
     */
    public Token (Type type, int userID) {
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
