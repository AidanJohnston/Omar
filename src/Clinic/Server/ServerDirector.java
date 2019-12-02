package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Data.DataReader;
import Clinic.Server.Data.DataWriter;
import Clinic.Server.Data.Queries;
import Util.*;
import Util.Exceptions.*;
import java.util.ArrayList;
import java.util.UUID;

public class ServerDirector {
    public Object login(Object params) throws LoginFailedException {
        Credentials user = new Queries().login((Credentials)params);
        return new Token(user.getType(), UUID.randomUUID(), user.getID());
    }

    public Object createAppointment(Object params) throws IncorrectPayloadException {
        ArrayList<Appointment> list = new DataReader().readAppointments();
        Appointment app = (Appointment)params;
        app.setID((list
            .stream()
            .mapToInt(d -> d.getID())
            .max())
            .getAsInt() + 1);
        list.add(app);
        new DataWriter().writeAppointments(list);
        return null;
    }

    public Object getCurrentAppointmentOfPatient(Object params) throws AppointmentNotFoundException {
        return new Queries().getFutureAppsPatient((Patient)params);
    }

    public Object getAllAppointmentOfPatient(Object params) throws AppointmentNotFoundException {
        return new Queries().getAppsPatient((Patient)params);
    }

    public Object getAllDoctor(Object params) throws IncorrectPayloadException {
        return new DataReader().readDoctors();
    }

    public Object getDoctorWithId(Object params) throws DoctorNotFoundException {
        return new Queries().getDoctorByID((Doctor)params);
    }
    
    public Object getPatientWithId(Object params) throws PatientNotFoundException {
        return new Queries().getPatientByID((Patient)params);
    }
    
    public Object getAllDiagnosisFromPatient(Object params) throws AppointmentNotFoundException {
        return new Queries().getDiagnoses((Patient)params);
    }
    
    public Object getAllPrescriptionFromPatient(Object params) throws AppointmentNotFoundException {
        return new Queries().getPrescriptions((Patient)params);
    }
    
    public Object getAllAppopintmentOfDoctor(Object params) throws AppointmentNotFoundException{
        return new Queries().getAppsDoctor((Doctor)params);
    }

    public Object getCurrentAppointmentDoctor(Object params) throws AppointmentNotFoundException{
        return new Queries().getFutureAppsDoctor((Doctor)params);
    }
    
    public Object getAllPatient(Object params) throws IncorrectPayloadException {
        return new DataReader().readPatients();
    }

    public Object createDoctor(Object params) throws IncorrectPayloadException {
        ArrayList<Doctor> list = new DataReader().readDoctors();
        try{
            Doctor doc = (Doctor)params;
            doc.setID((list
                .stream()
                .mapToInt(d -> d.getID())
                .max())
                .getAsInt() + 1);
            list.add(doc);
            new DataWriter().writeDoctors(list);
            return null;
        }catch(NullPointerException e){
            throw new IncorrectPayloadException("Invalid payload");
        }
    }

    public Object createPatient(Object params) throws IncorrectPayloadException {
        ArrayList<Patient> list = new DataReader().readPatients();
        try{
            Patient pat = (Patient)params;
            pat.setID((list
                .stream()
                .mapToInt(d -> d.getID())
                .max())
                .getAsInt() + 1);
            list.add(pat);
            new DataWriter().writePatients(list);
            return null;
        }catch(NullPointerException e){
            throw new IncorrectPayloadException("Invalid payload");
        }
    }

    public Object getAllAppointments(Object params) {
        return new DataReader().readAppointments();
    }

    public Object updatePatient(Object params) throws IncorrectPayloadException {
        try{
            ArrayList<Patient> list = new DataReader().readPatients();
            Patient pat = (Patient)params;
            list.removeIf(p -> p.getID() == pat.getID());
            new DataWriter().writePatients(list);
            return null;
        }catch(NullPointerException e){
            throw new IncorrectPayloadException("Invalid payload");
        }
    }

    public Object updateDoctor(Object params) throws IncorrectPayloadException {
        try{
            ArrayList<Doctor> list = new DataReader().readDoctors();
            Doctor doc = (Doctor)params;
            list.removeIf(d -> d.getID() == doc.getID());
            new DataWriter().writeDoctors(list);
            return null;
        }catch(NullPointerException e){
            throw new IncorrectPayloadException("Invalid payload");
        }
    }

    public Object updateAppointment(Object params) throws IncorrectPayloadException {
        try{
            ArrayList<Appointment> list = new DataReader().readAppointments();
            Appointment app = (Appointment)params;
            list.removeIf(a -> a.getID() == app.getID());
            new DataWriter().writeAppointments(list);
            return null;
        }catch(NullPointerException e){
            throw new IncorrectPayloadException("Invalid payload");
        }
    }

    public Object updateStaff(Object params) throws IncorrectPayloadException {
        try{
            ArrayList<Staff> list = new DataReader().readStaff();
            Staff sta = (Staff)params;
            list.removeIf(s -> s.getID() == sta.getID());
            new DataWriter().writeStaff(list);
            return null;
        }catch(NullPointerException e){
            throw new IncorrectPayloadException("Invalid payload");
        }
    }
}