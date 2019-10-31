package Users;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Date;
import java.util.List;

public class Patient {

    private int healthCardNumber;
    private Date healthCardExpiry;
    private String province;
    private Schedule schedule;
    private List<Doctor> doctors;
    private List<Diagnosis> diagnoses;
    private List<Prescription> prescriptions;

    public Patient(int healthCardNumber, Date healthCardExpiry, String province, Schedule schedule, List<Doctor> doctors, List<Diagnosis> diagnoses, List<Prescription> prescriptions) {
        this.healthCardNumber = healthCardNumber;
        this.healthCardExpiry = healthCardExpiry;
        this.province = province;
        this.schedule = schedule;
        this.doctors = doctors;
        this.diagnoses = diagnoses;
        this.prescriptions = prescriptions;
    }

    public int getHealthCardNumber() {
        return healthCardNumber;
    }

    public void setHealthCardNumber(int healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    public Date getHealthCardExpiry() {
        return healthCardExpiry;
    }

    public void setHealthCardExpiry(Date healthCardExpiry) {
        this.healthCardExpiry = healthCardExpiry;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void addDiagnose(Diagnosis diagnosis) {
        this.diagnoses.add(diagnosis);
    }

    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
    }
}
