package Clinic.Core;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * User.java - A class for storing basic information about members of the clinic
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see Doctor
 * @see Patient
 * @see Staff
 */
public class User implements Serializable{
    private String FName;
    private String LName;
    private LocalDate brithday;
    private int SIN;
    private String adress;
    private int ID;
    private String phoneNumber;

    private Token loginToken;

    /**
     * Empty Constructor
     */
    public User() {}

    /**
     * Constructor for the user class
     *
     * @param FName
     * @param LName
     * @param brithday
     * @param SIN
     * @param adress
     * @param ID
     * @param phoneNumber
     */
    public User(String FName, String LName, LocalDate brithday, int SIN, String adress, int ID, String phoneNumber) {
        this.FName = FName;
        this.LName = LName;
        this.brithday = brithday;
        this.SIN = SIN;
        this.adress = adress;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }
    /**
     * Constructor used for logging out.a
     * @param loginToken
     */
    public User(Token loginToken) {
        this.loginToken = loginToken;
    }
    public User(String FName) { this.FName = FName;}

    public User(int id) {
        this.ID = id;
    }

    /**
     * Gets the users first name
     *
     * @return firstName
     */
    public String getFName() {
        return FName;
    }

    /**
     * Sets the users first name
     *
     * @param _FName
     */
    public void setFName(String _FName) {
        FName = _FName;
    }

    /**
     * Gets the users last name
     *
     * @return lastName
     */
    public String getLName() {
        return LName;
    }

    /**
     * Sets the users last name
     *
     * @param LName
     */
    public void setLName(String LName) {
        this.LName = LName;
    }

    /**
     * Gets the users birthday
     *
     * @return birthday
     * @see LocalDate
     */
    public LocalDate getBrithday() {
        return brithday;
    }

    /**
     * Setes the users birthday
     *
     * @param brithday
     * @see LocalDate
     */
    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    /**
     * Gets the users SIN
     *
     * @return SIN
     */
    public int getSIN() {
        return SIN;
    }

    /**
     * Sets the users SIN
     *
     * @param SIN
     */
    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    /**
     * Gets the users address
     *
     * @return address
     */
    public String getAddress() {
        return adress;
    }

    /**
     * Sets the users address
     *
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Gets the users ID
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets the users ID
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Gets the users phone number
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the users phoneNumber
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Token getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(Token loginToken) {
        this.loginToken = loginToken;
    }
}
