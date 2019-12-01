package Clinic.Core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Patient.java - A class for storing information relative to patients
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see User
 */
public class Patient extends User implements Serializable {

    private int healthCardNumber;
    private LocalDate healthCardExpiry;
    private String province;

    /**
     * Constructor for the patient class
     * @param FName
     * @param LName
     * @param brithday
     * @param SIN
     * @param adress
     * @param ID
     * @param phoneNumber
     * @param healthCardNumber
     * @param healthCardExpiry
     * @param province
     */
    public Patient(
            String FName,
            String LName,
            LocalDate brithday,
            int SIN,
            String adress,
            int ID,
            String phoneNumber,
            int healthCardNumber,
            LocalDate healthCardExpiry,
            String province) {
        super(FName, LName, brithday, SIN, adress, ID, phoneNumber);
        this.healthCardNumber = healthCardNumber;
        this.healthCardExpiry = healthCardExpiry;
        this.province = province;
    }

    public Patient(int id) {
        super(id);
    }

    /**
     * Empty Constructor
     */
    public Patient() {}
    /**
     * Gets the health care number of the patient
     *
     * @return healthCardNumber
     */
    public int getHealthCardNumber() {
        return healthCardNumber;
    }

    /**
     * Sets the patients health care number
     *
     * @param healthCardNumber
     */
    public void setHealthCardNumber(int healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    /**
     * Gets the expiry date of the patients health card
     *
     * @return
     */
    public LocalDate getHealthCardExpiry() {
        return healthCardExpiry;
    }

    /**
     * Sets the expriy date of the patients health card
     *
     * @param healthCardExpiry
     */
    public void setHealthCardExpiry(LocalDate healthCardExpiry) {
        this.healthCardExpiry = healthCardExpiry;
    }

    /**
     * Gets thes province of the patient
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province of the patient
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

}
