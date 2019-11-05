package Clinic.Core;

import java.util.Date;

/**
 * Staff.java - A class for storing information relative to staff members
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see User
 */
public class Staff extends User {

    /**
     * Constructor for the Staff class
     *
     * @param username
     * @param password
     * @param Fname
     * @param LName
     * @param birthday
     * @param SIN
     * @param address
     * @param ID
     * @param phoneNumber
     */
    public Staff(
            String username,
            String password,
            String Fname,
            String LName,
            Date birthday,
            int SIN,
            String address,
            int ID,
            int phoneNumber) {
        super(username, password, Fname, LName, birthday, SIN, address, ID, phoneNumber);
    }
}
