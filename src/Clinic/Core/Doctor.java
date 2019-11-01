package Clinic.Core;

import java.util.Date;
import java.util.List;

/**
 * Doctor.java - A class for storing information relative to doctors
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see User
 */
public class Doctor extends User {
    private String speciatly;
    private String rank;
    private double startHour;
    private double endHour;
    private Schedule schedule;
    private List<Patient> patients;

    /**
     * Constructor for the Doctor class
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
     * @param speciatly
     * @param rank
     * @param startHour
     * @param endHour
     * @param schedule
     * @param patients
     */
    public Doctor(
            String username,
            String password,
            String Fname,
            String LName,
            Date brithday,
            int SIN,
            String adress,
            int ID,
            int phoneNumber,
            String speciatly,
            String rank,
            double startHour,
            double endHour,
            Schedule schedule,
            List<Patient> patients) {
        super(username, password, Fname, LName, brithday, SIN, adress, ID, phoneNumber);
        this.speciatly = speciatly;
        this.rank = rank;
        this.startHour = startHour;
        this.endHour = endHour;
        this.schedule = schedule;
        this.patients = patients;
    }

    /**
     * Gets the doctors speciatly
     *
     * @return speciatly
     */
    public String getSpeciatly() {
        return speciatly;
    }

    /**
     * Sets the doctors speciatly
     *
     * @param speciatly
     */
    public void setSpeciatly(String speciatly) {
        this.speciatly = speciatly;
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
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets the doctors schedule
     *
     * @param schedule
     * @see Schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Gets a list of the doctors patients, included all patients.  Current, pass, and future
     *
     * @return List of Patients
     * @see Patient
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Added a patient to the doctors list of patients
     *
     * @param patient
     * @see Patient
     */
    public void addCurrentPatient(Patient patient) {
        this.patients.add(patient);
    }
}
