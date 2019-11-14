package Clinic.Core;

import java.io.Serializable;

/**
 * Appointment.java - A class for storing the time, patient, doctor, diagnosis, and prescription from an appointment.
 * Can be used to store upcoming appointments or to see appointment history
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Appointment implements Serializable {

    private int ID;
    private Patient patient;
    private Doctor doctor;
    private Diagnosis diagnosis;
    private Prescription prescription;

    /**
     * Constructor for Appointment class
     *
     * @param patient the patient
     * @param doctor the doctor
     * @param diagnosis the diagnosis
     * @param prescription the prescription
     */
    public Appointment(Patient patient, Doctor doctor, Diagnosis diagnosis, Prescription prescription) {
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    /**
     * Gets the appointment ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets the appointment ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Gets the concerned patient involved in the appointment
     *
     * @return patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the patient for the appointment
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets the concerned doctor for the appointment
     *
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Sets the doctor for the appointment
     *
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Sets the diagnosis from the appointment
     *
     * @return diagnosis
     */
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets the diagnosis for the appointment
     *
     * @param diagnosis
     */
    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Gets the prescription for the appointment
     *
     * @return prescription
     */
    public Prescription getPrescription() {
        return prescription;
    }

    /**
     * Sets the prescription for the appointment
     *
     * @param prescription
     */
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
