package Clinic.Core;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.UUID;

import Util.UserType;

/**
 * Token.java - used to store token data for logged in users
 */
public class Token implements Serializable{

    private UserType type;
    private UUID tokenID;
    private int userID;

    /**
     * The constructor for the login token
     * @param type Type of user logged in
     * @param userID Their unique id
     */
    public Token (UserType type, UUID tokenID, int userID) {
        this.type = type;
        this.userID = userID;
        this.tokenID = tokenID;
    }

    public UserType getType(){
        return type;
    }

    public int getUserID() {
        return userID;
    }

    public UUID getTokenID(){
        return tokenID;
    }
}
