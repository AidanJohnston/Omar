package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Data.DataReader;
import Clinic.Server.Data.DataWriter;
import Clinic.Server.Data.Queries;
import Util.*;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.LoginFailedException;

import java.util.ArrayList;
import java.util.UUID;

public class ServerDirector {
    public Object login(Object params) throws LoginFailedException {
        Credentials user = new Queries().login((Credentials)params);
        return new Token(user.getType(), UUID.randomUUID(), user.getID());
    }

    public Object createAppointment(Object params) throws IncorrectPayloadException {
        return null;
    }

    public Object getAllSchedule(Object params) throws IncorrectPayloadException {
        return null;
    }

    public Object getScheduleOfDoctor(Object params) throws IncorrectPayloadException {
        return null;
    }

    public Object getCurrentAppointmentOfPatient(Object params) throws IncorrectPayloadException {
        return new Queries().getFutureAppsPatient((int)params);
    }

    public Object getAllAppointmentOfPatient(Object params) throws IncorrectPayloadException {
        return new Queries().getAppsPatient((int)params);
    }

    public Object getAllDoctor(Object params) throws IncorrectPayloadException {
        try {
            return new DataReader().readDoctors();
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }

    public Object getDoctorWithId(Object params) throws IncorrectPayloadException {
        return null;
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
        return new Queries().getFutureAppsDoctor((int)params);
    }
    
    public Object getAllPatient(Object params) throws IncorrectPayloadException {
        try{
            return new DataReader().readPatients();
        }catch(Exception e){
            return e;
        }
    }
}