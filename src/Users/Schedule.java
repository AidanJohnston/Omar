package Users;

import java.util.List;

public class Schedule {
    private List<Appointment> appointmentList;

    public Schedule() {

        //DO NOTHING

    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void addAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
    }
}
