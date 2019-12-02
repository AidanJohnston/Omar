package Clinic.Core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Diagnosis.java - A class for storing diagnosis data from appointments
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Diagnosis implements Serializable {

    private String name;
    private LocalDate date;
    private String notes;

    /**
     * Constructor for the Diagnosis class
     *
     * @param name
     * @param date
     * @param notes
     */
    public Diagnosis(String name, LocalDate date, String notes) {
        this.name = name;
        this.date = date;
        this.notes = notes;
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
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the diagnosis
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
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
