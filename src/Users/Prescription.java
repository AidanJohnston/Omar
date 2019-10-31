package Users;

import java.util.Date;

public class Prescription {
    private String name;
    private Date date;
    private String note;
    private String instructions;

    public Prescription(String name, Date date, String note, String instructions) {
        this.name = name;
        this.date = date;
        this.note = note;
        this.instructions = instructions;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
