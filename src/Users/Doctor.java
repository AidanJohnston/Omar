package Users;

import java.util.Date;
import java.util.List;

public class Doctor extends User{
    private String speciatly;
    private String rank;
    private double startHour;
    private double endHour;
    private Schedule schedule;
    private List<Patient> patients;

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

    public String getSpeciatly() {
        return speciatly;
    }

    public void setSpeciatly(String speciatly) {
        this.speciatly = speciatly;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getStartHour() {
        return startHour;
    }

    public void setStartHour(double startHour) {
        this.startHour = startHour;
    }

    public double getEndHour() {
        return endHour;
    }

    public void setEndHour(double endHour) {
        this.endHour = endHour;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void addCurrentPatient(Patient patient) {
        this.patients.add(patient);
    }
}
