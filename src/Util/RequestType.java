package Util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class RequestType //Yo we're using this one its like 10000000 times better
{
    public static final String SUCCESS,
            LOGIN,
            LOGOUT,
            ERROR,
            APPOINTMENT_CREATE,
            APPOINTMENT_DOCTOR_ALL,
            APPOINTMENT_PATIENT_CURRENT_ALL, 
            APPOINTMENT_PATIENT_ALL,
            DOCTOR_GET_ALL,
            DOCTOR_GET_GIVEN_ID,
            PATIENT_GET_GIVEN_ID,
            DOCTOR_UPDATE_GIVEN_DOCTOR,
            DIAGNOSIS_GET_ALL_PATIENT,
            PRESCRIPTION_GET_ALL_PATIENT,
            APPOINTMENT_DOCTOR_CURRENT_ALL,
            PATIENT_GET_ALL,
            DOCTOR_CREATE,
            PATIENT_CREATE;
    // etc.

public static final Collection<String> ALL_PATHS;
    static {
        ALL_PATHS = Collections.unmodifiableCollection(Arrays.asList(
        SUCCESS = "success",
        LOGIN = "login",
        LOGOUT = "logout",
        ERROR = "error",
        APPOINTMENT_CREATE = "createAppointment",
        APPOINTMENT_DOCTOR_ALL = "getAllAppopintmentOfDoctor",
        APPOINTMENT_PATIENT_CURRENT_ALL = "getCurrentAppointmentOfPatient",
        APPOINTMENT_PATIENT_ALL = "getAllAppointmentOfPatient",
        DOCTOR_GET_ALL = "getAllDoctor",
        DOCTOR_GET_GIVEN_ID = "getDoctorWithId",
        PATIENT_GET_GIVEN_ID = "getPatientWithId",
        DOCTOR_UPDATE_GIVEN_DOCTOR = "setDoctor",
        DIAGNOSIS_GET_ALL_PATIENT = "getAllDiagnosisFromPatient",
        PRESCRIPTION_GET_ALL_PATIENT = "getAllPrescriptionFromPatient",
        APPOINTMENT_DOCTOR_CURRENT_ALL = "getCurrentAppointmentDoctor",
        PATIENT_GET_ALL = "getAllPatient",
        DOCTOR_CREATE = "createDoctor",
        PATIENT_CREATE = "createPatient"
        ));
    }
}
