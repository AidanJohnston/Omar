package Clinic.Core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * Staff.java - A class for storing information relative to staff members
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see User
 */
public class Staff extends User implements Serializable {

    /**
     * Constructor for the Staff class
     * @param FName
     * @param LName
     * @param brithday
     * @param SIN
     * @param adress
     * @param ID
     * @param phoneNumber
     */
    public Staff(
            String FName,
            String LName,
            LocalDate brithday,
            int SIN,
            String adress,
            int ID,
            String phoneNumber) {
        super(FName, LName, brithday, SIN, adress, ID, phoneNumber);
    }

    public Staff(int id) {
        super(id);
    }
    /**
     * Empty Constructor
     */
    public Staff() {}
}
