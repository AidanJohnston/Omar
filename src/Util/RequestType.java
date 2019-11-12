package Util;

import java.lang.reflect.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class RequestType //Yo we're using this one its like 10000000 times better
{
    public static final String  SUCCESS,
                                LOGIN,
                                LOGOUT,
                                ERROR,
                                DIAGNOSIS_GET_ALL_PATIENT,
                                DIAGNOSIS_GET_ALL_DOCTOR,
                                DIAGNOSIS_UPDATE_GIVEN_REFERENCE,
                                DIAGNOSIS_CREATE_GIVEN_REFERENCE,
                                DIAGNOSIS_REMOVE_GIVEN_REFERENCE,
                                DOCTOR_GET_ALL,
                                DOCTOR_GET_GIVEN_ID,
                                DOCTOR_UPDATE_GIVEN_DOCTOR,
                                DOCTOR_CREATE_GIVEN_DOCTOR,
                                DOCTOR_REQUEST_GIVEN_NAME,
                                DOCTOR_REQUEST_GIVEN_TIME,
                                DOCTOR_REQUEST_GIVEN_DATE,
                                DOCTOR_REMOVE_GIVEN_DOCTOR,
                                PATIENT_GET_ALL;
    // etc.

public static final Collection<String> ALL_PATHS;
    static {
        ALL_PATHS = Collections.unmodifiableCollection(Arrays.asList(
            SUCCESS = "update",
            LOGIN = "login",
            LOGOUT = "logout",
            ERROR = "error",
            DIAGNOSIS_GET_ALL_PATIENT = "diagnosisGetAllPatient",
            DIAGNOSIS_GET_ALL_DOCTOR = "diagnosisGetAllDoctor",
            DIAGNOSIS_UPDATE_GIVEN_REFERENCE = "diagnosisUpdateGivenReference",
            DIAGNOSIS_CREATE_GIVEN_REFERENCE = "diagnosisCreateGivenReference",
            DIAGNOSIS_REMOVE_GIVEN_REFERENCE = "diagnosisRemoveGivenReference",
            DOCTOR_GET_ALL = "doctorGetAll",
            DOCTOR_GET_GIVEN_ID = "doctorGetGivenId",
            DOCTOR_UPDATE_GIVEN_DOCTOR = "doctorUpdateGivenDoctor",
            DOCTOR_CREATE_GIVEN_DOCTOR = "doctorCreateGivenDoctor",
            DOCTOR_REQUEST_GIVEN_NAME = "doctorRequestGivenName",
            DOCTOR_REQUEST_GIVEN_TIME = "doctorRequestGivenTime",
            DOCTOR_REQUEST_GIVEN_DATE = "doctorRequestGivenDate",
            DOCTOR_REMOVE_GIVEN_DOCTOR = "doctorRemoveGivenDoctor",
            PATIENT_GET_ALL = "patientGetAll"
            // etc.
        ));
    }
}
