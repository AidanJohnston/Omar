package Clinic.Core;

import java.io.Serializable;
import java.util.Date;

/**
 * Diagnosis.java - A class for storing diagnosis data from appointments
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Diagnosis implements Serializable {

    private String name;
    private Date date;
    private Doctor doctor;
    private String notes;
    private int appointmentID;

    /**
     * Constructor for the Diagnosis class
     *
     * @param name
     * @param date
     * @param doctor
     * @param notes
     * @param appointmentID
     */
    public Diagnosis(String name, Date date, Doctor doctor, String notes, int appointmentID) {
        this.name = name;
        this.date = date;
        this.doctor = doctor;
        this.notes = notes;
        this.appointmentID = appointmentID;
    }

    /**
     * Empty Constructor
     */
    public Diagnosis() {}
    /**
     * Gets the name of the diagnosis
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the diagnosis
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of the diagnosis
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the diagnosis
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the doctor who gave the diagnosis
     *
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Sets the doctor who gave the diagnosis
     *
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Gets the notes for the diagnosis given by the doctor
     *
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes for the diagnosis
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * gets the appointmentID
     * @return appointmentID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * Sets the appointmentID
     * @param appointmentID
     */
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
}
