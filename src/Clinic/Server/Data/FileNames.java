package Clinic.Server.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileNames //Yo we're using this one its like 10000000 times better
{
    public static final String 
    APPOINTMENTS,
    CREDENTIALS,
    DIAGNOSES,
    DOCTORS,
    PATIENTS,
    PRESCRIPTIONS,
    STAFF,
    USERS;
    // etc.

public static final Collection<String> ALL_PATHS;
    static {
        ALL_PATHS = Collections.unmodifiableCollection(Arrays.asList(
            APPOINTMENTS = "appointments.txt",
            CREDENTIALS = "credentials.txt",
            DIAGNOSES = "diagnoses.txt",
            DOCTORS = "doctors.txt",
            PATIENTS = "patients.txt",
            PRESCRIPTIONS = "prescriptions.txt",
            STAFF = "staff.txt",
            USERS = "users.txt"
        ));
    }
}
