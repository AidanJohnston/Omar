package Clinic.Core;

import javax.print.Doc;

import java.io.Serializable;
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
public class Doctor extends User implements Serializable{
    private String specialty;
    private String rank;
    private double startHour;
    private double endHour;
    private int scheduleID;

    /**
     * Constructor for the Doctor class
     *
     * @param FName
     * @param LName
     * @param birthday
     * @param SIN
     * @param adress
     * @param ID
     * @param phoneNumber
     * @param specialty
     * @param rank
     * @param startHour
     * @param endHour
     * @param scheduleID
     */
    public Doctor(
            String FName,
            String LName,
            LocalDate birthday,
            int SIN,
            String adress,
            int ID,
            String phoneNumber,
            String specialty,
            String rank,
            double startHour,
            double endHour,
            int scheduleID) {
        super(FName, LName, birthday, SIN, adress, ID, phoneNumber);
        this.specialty = specialty;
        this.rank = rank;
        this.startHour = startHour;
        this.endHour = endHour;
        this.scheduleID = scheduleID;
    }

    /**
     * Empty Constructor
     */
    public Doctor() {}
    public Doctor(String FName) {
        super(FName);
    }
    public Doctor(String FName, String Lname, LocalDate birthday, int SIN, String address, int ID, String phoneNumber, String specialty) {
        super(FName, Lname, birthday, SIN, address, ID, phoneNumber);
        this.specialty = specialty;
    }



    /**
     * Gets the doctors speciatly
     *
     * @return speciatly
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the doctors speciatly
     *
     * @param specialty
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Gets the doctors rank
     *
     * @return rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets the doctor rank
     *
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Gets the doctors starts hours for work
     *
     * @return startHours
     */
    public double getStartHour() {
        return startHour;
    }

    /**
     * Sets the doctors start time
     *
     * @param startHour
     */
    public void setStartHour(double startHour) {
        this.startHour = startHour;
    }

    /**
     * Gets the doctors end time
     *
     * @return endHour
     */
    public double getEndHour() {
        return endHour;
    }

    /**
     * Sets the doctors end work hours
     *
     * @param endHour
     */
    public void setEndHour(double endHour) {
        this.endHour = endHour;
    }

    /**
     * Gets the doctor schedule
     *
     * @return schedule
     * @see Schedule
     */
    public int getSchedule() {
        return scheduleID;
    }

    /**
     * Sets the doctors schedule
     *
     * @param schedule
     * @see Schedule
     */
    public void setSchedule(Schedule schedule) {
        this.scheduleID = scheduleID;
    }

    public String getFname() {
        return super.getFName();
    }
}
