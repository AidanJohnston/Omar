package Core;

import java.util.Date;

/**
 * Diagnosis.java - A class for storing diagnosis data from appointments
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Diagnosis {

    private String name;
    private Date date;
    private Doctor doctor;
    private String notes;

    /**
     * Constructor for the Diagnosis class
     *
     * @param name
     * @param date
     * @param doctor
     * @param notes
     */
    public Diagnosis(String name, Date date, Doctor doctor, String notes) {
        this.name = name;
        this.date = date;
        this.doctor = doctor;
        this.notes = notes;
    }

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
}
