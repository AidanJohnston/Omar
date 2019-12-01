package Clinic.Core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Patient.java - A class for storing information relative to patients
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see User
 */
public class Patient extends User implements Serializable {

    private int healthCardNumber;
    private Date healthCardExpiry;
    private String province;
    private Schedule schedule;
    private List<Diagnosis> diagnoses;
    private List<Prescription> prescriptions;

    /**
     * Constructor for the patient class
     * @param username
     * @param password
     * @param FName
     * @param LName
     * @param brithday
     * @param SIN
     * @param adress
     * @param ID
     * @param phoneNumber
     * @param healthCardNumber
     * @param healthCardExpiry
     * @param province
     * @param schedule
     * @param diagnoses
     * @param prescriptions
     */
    public Patient(
            String username,
            String password,
            String FName,
            String LName,
            LocalDate brithday,
            int SIN,
            String adress,
            int ID,
            String phoneNumber,
            int healthCardNumber,
            Date healthCardExpiry,
            String province,
            Schedule schedule,
            List<Diagnosis> diagnoses,
            List<Prescription> prescriptions) {
        super(FName, LName, brithday, SIN, adress, ID, phoneNumber);
        this.healthCardNumber = healthCardNumber;
        this.healthCardExpiry = healthCardExpiry;
        this.province = province;
        this.schedule = schedule;
        this.diagnoses = diagnoses;
        this.prescriptions = prescriptions;
    }

    public Patient(int id) {
        super(id);
    }

    /**
     * Empty Constructor
     */
    public Patient() {}
    /**
     * Gets the health care number of the patient
     *
     * @return healthCardNumber
     */
    public int getHealthCardNumber() {
        return healthCardNumber;
    }

    /**
     * Sets the patients health care number
     *
     * @param healthCardNumber
     */
    public void setHealthCardNumber(int healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    /**
     * Gets the expiry date of the patients health card
     *
     * @return
     */
    public Date getHealthCardExpiry() {
        return healthCardExpiry;
    }

    /**
     * Sets the expriy date of the patients health card
     *
     * @param healthCardExpiry
     */
    public void setHealthCardExpiry(Date healthCardExpiry) {
        this.healthCardExpiry = healthCardExpiry;
    }

    /**
     * Gets thes province of the patient
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province of the patient
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the schedule of the patients upcoming appointments
     *
     * @return schedule
     * @see Schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets the schedule of upcoming appointments for the patient
     *
     * @param schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Gets a list of all diagnoses given to the patient
     *
     * @return diagnoses
     * @see Diagnosis
     */
    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    /**
     * Sets a list of diagnoses given to the patient
     *
     * @param diagnoses
     * @see Diagnosis
     */
    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    /**
     * Gets the list of all prescriptions given to the patient
     *
     * @return prescriptions
     * @see Prescription
     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Sets a list of prescriptions given to the patient
     *
     * @param prescriptions
     * @see Prescription
     */
    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    /**
     * Added a diagnosis to the diagnosis list
     *
     * @param diagnosis
     * @see Diagnosis
     */
    public void addDiagnose(Diagnosis diagnosis) {
        this.diagnoses.add(diagnosis);
    }

    /**
     * Added a prescription to the prescription list
     *
     * @param prescription
     * @see Prescription
     */
    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
    }
}
