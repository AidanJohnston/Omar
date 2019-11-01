package Clinic.Core;

import java.util.Date;

/**
 * User.java - A class for storing basic information about members of the clinic
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see Doctor
 * @see Patient
 * @see Staff
 */
public class User {
    private String username;
    private String password;
    private String Fname;
    private String LName;
    private Date brithday;
    private int SIN;
    private String adress;
    private int ID;
    private int phoneNumber;

    /**
     * Constructor for the user class
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
    public User(String username, String password, String Fname, String LName, Date brithday, int SIN, String adress, int ID, int phoneNumber) {

        this.username = username;
        this.password = password;
        this.Fname = Fname;
        this.LName = LName;
        this.brithday = brithday;
        this.SIN = SIN;
        this.adress = adress;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the users password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the users password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the users first name
     *
     * @return firstName
     */
    public String getFname() {
        return Fname;
    }

    /**
     * Sets the users first name
     *
     * @param fname
     */
    public void setFname(String fname) {
        Fname = fname;
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
     * @see Date
     */
    public Date getBrithday() {
        return brithday;
    }

    /**
     * Setes the users birthday
     *
     * @param brithday
     * @see Date
     */
    public void setBrithday(Date brithday) {
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
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the users phoneNumber
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Compares the given password and the users password, will return true if they are the same
     *
     * @param password
     * @return boolean - True if passwords are the same, False if password are not the same
     */
    public boolean comparePassword(String password) {
        if (this.password == password)
            return true;
        else {
            return false;
        }
    }
}
