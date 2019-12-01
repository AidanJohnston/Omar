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
    private UUID userID;

    /**
     * The constructor for the login token
     * @param type Type of user logged in
     * @param userID Their unique id
     */
    public Token (UserType type, UUID userID) {
        this.type = type;
        this.userID = userID;
    }

    public UserType getType(){
        return type;
    }

    public UUID getUserID() {
        return userID;
    }
}
