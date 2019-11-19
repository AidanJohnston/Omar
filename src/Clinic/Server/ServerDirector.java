package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Data.DataReader;
import Clinic.Server.Data.DataWriter;
import Util.*;
import Util.Exceptions.IncorrectPayloadException;

import java.util.ArrayList;

public class ServerDirector {
    /*
     * This should stay dead, but just in case everything goes wrong and we need to
     * do this public Method login(){ return this.getClass().getEnclosingMethod(); }
     * //
     */
    public Token login(Util.PayloadBoys.login l) throws IncorrectPayloadException {
        UserType type = UserType.DOCTOR; // REPLACE WITH DATABASE LOOKUP
        int userID = 1;
        System.out.println("Login Params: " + l.username + " " + l.password);
        Token token = new Token(type, userID);

        return token;
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

    public Object getAllDoctor() throws IncorrectPayloadException {

        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor("Aidan"));
        list.add(new Doctor("Sean"));
        list.add(new Doctor("Dawson"));
        list.add(new Doctor("John"));
        list.add(new Doctor("Mai"));
        DataWriter d = new DataWriter();
        DataReader dd = new DataReader();
        try {
            return dd.readDoctors();
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
        
        /*
        try {
            //d.writeDoctors(list);
        } catch (Exception e) {
            return e;
        }
        return list;
        */
    }
    public Object getDoctorWithId(Object params) throws IncorrectPayloadException {return null;}
    public Object setDoctor(Object params) throws IncorrectPayloadException {return null;}
    public Object getAllDiagnosisFromPatient(Object params) throws IncorrectPayloadException {return null;}
    public Object getAllPrescriptionFromPatient(Object params) throws IncorrectPayloadException {return null;}
    public Object setSchedule(Object params) throws IncorrectPayloadException {return null;}
    public Object getCurrentAppointmentDoctor(Object params) throws IncorrectPayloadException {return null;}
    public Object getAllPatient(Object params) throws IncorrectPayloadException {return null;}
}