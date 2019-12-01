package Clinic.Core;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Util.UserType;

public class Credentials implements Serializable{
    private String username;
    private String hashword;
    private int userID;
    private UserType type;

    public Credentials(String _username, String password){
        username = _username;
        hashword = hashPassword(password);
    }

    public Credentials(String _username, String password, int _userID, UserType _type){
        username = _username;
        hashword = hashPassword(password);
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

    private String hashPassword(String passwordToHash){
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            return sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
            return passwordToHash;
        }
    }
}
