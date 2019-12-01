package Clinic.Core;

import java.time.LocalDate;
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
     *  @param username
     * @param password
     * @param FName
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
            String FName,
            String LName,
            LocalDate brithday,
            int SIN,
            String adress,
            int ID,
            String phoneNumber) {
        super(FName, LName, brithday, SIN, adress, ID, phoneNumber);
    }

    /**
     * Empty Constructor
     */
    public Staff() {}
}
