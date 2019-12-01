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
        ArrayList<Appointment> apps = new DataReader().readAppointments();
        apps.add((Appointment)params);
        new DataWriter().writeAppointments(apps);
        return null;
    }

    public Object getAllSchedule(Object params) throws IncorrectPayloadException {
        return null;
    }

    public Object getScheduleOfDoctor(Object params) throws IncorrectPayloadException {
        return null;
    }

    public Object getCurrentAppointmentOfPatient(Object params) throws IncorrectPayloadException {
        return new Queries().getFutureAppsPatient((Patient)params);
    }

    public Object getAllAppointmentOfPatient(Object params) throws IncorrectPayloadException {
        return new Queries().getAppsPatient((Patient)params);
    }

    public Object getAllDoctor(Object params) throws IncorrectPayloadException {
        return new DataReader().readDoctors();
    }

    public Object getDoctorWithId(Object params) throws DoctorNotFoundException {
        return new Queries().getDoctorByID((Doctor)params);
    }
    
    public Object setDoctor(Object params) throws IncorrectPayloadException {
        return null;
    }
    
    public Object getAllDiagnosisFromPatient(Object params) throws IncorrectPayloadException {
        return null;
    }
    
    public Object getAllPrescriptionFromPatient(Object params) throws IncorrectPayloadException {
        return null;
    }
    
    public Object setSchedule(Object params) throws IncorrectPayloadException {
        return null;
    }
    
    public Object getCurrentAppointmentDoctor(Object params) throws IncorrectPayloadException {
        return new Queries().getFutureAppsDoctor((Doctor)params);
    }
    
    public Object getAllPatient(Object params) throws IncorrectPayloadException {
        return new DataReader().readPatients();
    }

    public Object createDoctor(Object params) throws IncorrectPayloadException {
        ArrayList<Doctor> list = new DataReader().readDoctors();
        list.add((Doctor)params);
        new DataWriter().writeDoctors(list);
        return null;
    }

    public Object createPatient(Object params) throws IncorrectPayloadException {
        ArrayList<Patient> list = new DataReader().readPatients();
        list.add((Patient)params);
        new DataWriter().writePatients(list);
        return null;
    }
}