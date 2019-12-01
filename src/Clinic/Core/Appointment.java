package Clinic.Core;

import Util.RequestType;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Appointment.java - A class for storing the time, patient, doctor, diagnosis, and prescription from an appointment.
 * Can be used to store upcoming appointments or to see appointment history
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Appointment implements Serializable {

    private int ID;
    private int patientID;
    private Patient patient;
    private int doctorID;
    private Doctor doctor;
    private LocalDate date;
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
    public Appointment(Patient patient, Doctor doctor, LocalDate date, Diagnosis diagnosis, Prescription prescription) {
        this.patient = patient;
        this.doctor = doctor;
        this.patientID = patient.getID();
        this.doctorID = doctor.getID();
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public LocalDate getDate(){
        return date;
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
    public int getPatientID() {
        return patientID;
    }

    public Patient getPatient(){
        return patient;
    }

    /**
     * Sets the patient for the appointment
     *
     * @param patient
     */
    public void setPatient(int patient) {
        this.patientID = patient;
    }

    /**
     * Gets the concerned doctor for the appointment
     *
     * @return doctor
     */
    public int getDoctorID() {
        return doctorID;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    /**
     * Sets the doctor for the appointment
     *
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctorID = doctor.getID();
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
