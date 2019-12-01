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
    /*
     * This should stay dead, but just in case everything goes wrong and we need to
     * do this public Method login(){ return this.getClass().getEnclosingMethod(); }
     * //
     */
    public Object login(Object params) throws LoginFailedException {
        return new Token(new Queries().login((Credentials)params).getType(), UUID.randomUUID());
    }

    public Object logout(Object params) throws IncorrectPayloadException {
        return null;
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
        return null;
    }

    public Object getAllAppointmentOfPatient(Object params) throws IncorrectPayloadException {
        return null;
    }

    public Object getAllDoctor(Object params) throws IncorrectPayloadException {
        DataReader dd = new DataReader();
        try {
            return dd.readDoctors();
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }
    public Object getDoctorWithId(Object params) throws IncorrectPayloadException {return null;}
    public Object setDoctor(Object params) throws IncorrectPayloadException {return null;}
    public Object getAllDiagnosisFromPatient(Object params) throws IncorrectPayloadException {return null;}
    public Object getAllPrescriptionFromPatient(Object params) throws IncorrectPayloadException {return null;}
    public Object setSchedule(Object params) throws IncorrectPayloadException {return null;}
    public Object getCurrentAppointmentDoctor(Object params) throws IncorrectPayloadException {return null;}
    public Object getAllPatient(Object params) throws IncorrectPayloadException {
        DataReader reader = new DataReader();
        try{
            return reader.readPatients();
        }catch(Exception e){
            return e;
        }
    }
}