package Util.PayloadBoys;

import javax.print.Doc;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Doctor.java - A class for storing information relative to doctors
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see User
 */
public class login implements Serializable {
    public String username;
    public String password;

    public login(String u, String p) {
        username = u;
        try {
            password = md5(u, p);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // TODO TAKEN FROM INTERNET - WILL DO MYSELF AT SOME POINT -AIDAN
    private static String md5(String salt, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        if (salt != null) {
            md.update(salt.getBytes());
        }
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }

}    