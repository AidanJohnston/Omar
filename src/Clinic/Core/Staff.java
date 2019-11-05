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
     * @param brithday
     * @param SIN
     * @param adress
     * @param ID
     * @param phoneNumber
     */
    public Staff(
            String username,
            String password,
            String Fname,
            String LName,
            Date brithday,
            int SIN,
            String adress,
            int ID,
            int phoneNumber) {
        super(username, password, Fname, LName, brithday, SIN, adress, ID, phoneNumber);
    }
}
