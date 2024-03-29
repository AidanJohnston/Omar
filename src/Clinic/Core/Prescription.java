package Clinic.Core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Prescription.java - A class for storing prescription information
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Prescription implements Serializable {
    private String name;
    private LocalDate date;
    private String note;
    private String instructions;
    /**
     * Constructor for Prescription Class
     *
     * @param name
     * @param date
     * @param note
     * @param instructions
     */
    public Prescription(String name, LocalDate date, String note, String instructions) {

        this.name = name;
        this.date = date;
        this.note = note;
        this.instructions = instructions;
    }

    /**
     * Empty Constructor
     */
    public Prescription() {}
    /**
     * Gets the name of the prescription
     *
     * @return Name of prescription
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the prescription
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date the prescription was given
     *
     * @return Date of the prescription
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date the prescription wave given
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the note the doctor left for the prescription
     *
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets a note for the prescription
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets the prescription instructions ie. when to take the prescription, how much
     *
     * @return instruction
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Sets the instructions for taking the prescription
     *
     * @param instructions
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
