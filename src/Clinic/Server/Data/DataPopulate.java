package Clinic.Server.Data;

import Clinic.Core.*;
import Util.UserType;
import Util.Exceptions.LoginFailedException;

import java.util.ArrayList;

public class DataPopulate {
    public static void main(String args[]) throws LoginFailedException {
        popDoc();
        popCreds();
    }

    private static void popApps(){
        
    }    

    private static void popCreds(){
        ArrayList<Credentials> creds = new ArrayList<>();
        creds.add(new Credentials("seanp", "p", 1, UserType.PATIENT));
        creds.add(new Credentials("seand", "d", 2, UserType.DOCTOR));
        creds.add(new Credentials("seans", "s", 3, UserType.STAFF));
        DataWriter d = new DataWriter();
        try {
            d.writeCredentials(creds);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
    }

    private static void popDoc(){
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor("Aidan"));
        list.add(new Doctor("Sean"));
        list.add(new Doctor("Dawson"));
        list.add(new Doctor("John"));
        list.add(new Doctor("Mai"));
        DataWriter d = new DataWriter();
        //write some example info to the database xml
        try {
            d.writeDoctors(list);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
    }


}
