package Users;

import java.util.Date;
import java.util.List;

public class Diagnosis {

    private String name;
    private Date date;
    private Doctor doctor;
    private String notes;

    public Diagnosis(String name, Date date, Doctor doctor, String notes) {
        this.name = name;
        this.date = date;
        this.doctor = doctor;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
