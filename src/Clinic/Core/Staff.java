package Clinic.Core;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> branch 'master' of https://github.com/AidanJohnston/ESOF-3050DesignProject.git

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
            LocalDate brithday,
            int SIN,
            String adress,
            int ID,
            int phoneNumber) {
        super(username, password, Fname, LName, brithday, SIN, adress, ID, phoneNumber);
    }
}
