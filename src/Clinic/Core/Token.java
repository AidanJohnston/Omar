package Clinic.Core;


import java.lang.reflect.Type;

/**
 * Token.java - used to store token data for logged in users
 */
public class Token {

    private Type type;
    private int tokenid;

    /**
     * The constructor for the login token
     * @param type Type of user logged in
     * @param tokenid Their unique id
     */
    public Token (Type type, int tokenid) {
        this.type = type;
        this.tokenid = tokenid;
    }
}
