package Clinic.Core;

import java.io.Serializable;
import java.util.List;

/**
 * Schedule.java - A class for store a list of appointments
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Schedule implements Serializable {
    private List<Appointment> appointmentList;

    /**
     * Constructor for the Schedule class
     */
    public Schedule() {

    }

    /**
     * Gets the List of appointments
     *
     * @return List of appointments
     */
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    /**
     * Adds an appointment to the appointment list
     *
     * @param appointment
     */
    public void addAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
    }
}
