package Clinic.Core;


import java.io.Serializable;
import java.lang.reflect.Type;

import Util.UserType;

public class Credentials implements Serializable{
    private String username;
    private String hashword;
    private int userID;
    private UserType type;

    public Credentials(String _username, String _hashword){
        username = _username;
        hashword = _hashword;
    }

    public Credentials(String _username, String _hashword, int _userID, UserType _type){
        username = _username;
        hashword = _hashword;
        userID = _userID;
        type = _type;
    }

    public String getUsername(){
        return username;
    }

    public String getHashword(){
        return hashword;
    }

    public int getID(){
        return userID;
    }

    public UserType getType(){
        return type;
    }
}
