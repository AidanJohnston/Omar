package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Clinic.Core.*;
import Clinic.Server.Data.DataReader;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.NotImplementedYetException;
import Util.Exceptions.ServerException;
import Util.RequestType;
import Util.UserType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class TestClientSecreary {
    private Token token;
    private ClientSecretary clientSecretary;
    public TestClientSecreary() throws ServerException {

        this.clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);

        this.token = clientSecretary.login("seans", "s");
    }


    @Test
    public void testLogin() throws ServerException {
        Assert.assertTrue(token.getType().equals(UserType.STAFF));
    }

    @Test
    public void test_GetAllAppointment() throws ServerException {
        ArrayList<Appointment> appointmentArrayList = clientSecretary.getAllAppointment(token);

        ArrayList<Appointment> list = new ArrayList<>();

        list.add(new Appointment(new DataReader().readPatients().get(0), new DataReader().readDoctors().get(0), LocalDate.of(2020, 12, 2), "05:02", new Diagnosis(), new Prescription()));
        list.add(new Appointment(new DataReader().readPatients().get(1), new DataReader().readDoctors().get(1), LocalDate.of(2018, 12, 2), "13:30", new Diagnosis("Sick", LocalDate.of(2018, 12, 2), "You are sick"), new Prescription("Drug", LocalDate.of(2018, 12, 2), "Cures being sick", "Take once an hour")));

        System.out.println(appointmentArrayList);
        System.out.println(list);

        System.out.println(list.equals(appointmentArrayList));

        Assert.assertTrue(appointmentArrayList.equals(list));
    }

    @Test
    public void TestgetAppointmentsDoctorAll() throws ServerException {
        ArrayList<Appointment> appointmentArrayList = clientSecretary.getAppointmentsDoctorAll(token, 2);

        ArrayList<Appointment> list = new ArrayList<>();
        list.add(new Appointment(new DataReader().readPatients().get(1), new DataReader().readDoctors().get(1), LocalDate.of(2018, 12, 2), "13:30", new Diagnosis("Sick", LocalDate.of(2018, 12, 2), "You are sick"), new Prescription("Drug", LocalDate.of(2018, 12, 2), "Cures being sick", "Take once an hour")));

        Assert.assertThat(appointmentArrayList, is(list));
    }

    @Test
    public void TestgetCurrentAppointmentPatient() throws ServerException {

        ArrayList<Appointment> appointmentArrayList = clientSecretary.getCurrentAppointmentPatient(token, 52352);

        ArrayList<Appointment> list = new ArrayList<>();
        list.add(new Appointment(new DataReader().readPatients().get(1), new DataReader().readDoctors().get(1), LocalDate.of(2018, 12, 2), "13:30", new Diagnosis("Sick", LocalDate.of(2018, 12, 2), "You are sick"), new Prescription("Drug", LocalDate.of(2018, 12, 2), "Cures being sick", "Take once an hour")));

        Assert.assertThat(appointmentArrayList, is(list));
    }

    @Test
    public void TestgetAppointmentPatientAll() throws ServerException {

        ArrayList<Appointment> appointmentArrayList = clientSecretary.getAppointmentPatientAll(token, 14);

        ArrayList<Appointment> list = new ArrayList<>();
        list.add(new Appointment(new DataReader().readPatients().get(1), new DataReader().readDoctors().get(1), LocalDate.of(2018, 12, 2), "13:30", new Diagnosis("Sick", LocalDate.of(2018, 12, 2), "You are sick"), new Prescription("Drug", LocalDate.of(2018, 12, 2), "Cures being sick", "Take once an hour")));

        Assert.assertThat(appointmentArrayList, is(list));
    }

    @Test
    public void TestgetDoctorAll() throws ServerException {

        ArrayList<Doctor> appointmentArrayList = clientSecretary.getDoctorAll(token);

        ArrayList<Doctor> list = new ArrayList<>();

        list.add(new Doctor("Aidan", "Johnston", LocalDate.of(1999, 5, 27), 420, "25 Street rd.", 129, "8076303284", "Surgery", "Head Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0)));
        list.add(new Doctor("Sean", "Dunlop", LocalDate.of(1999, 7, 23), 403, "658 Boulevard street", 2, "87630483", "Pharmacist", "Second Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0)));

        Assert.assertEquals(list, appointmentArrayList);
    }

    @Test
    public void TestgetDoctorWithID() throws ServerException {

        Doctor appointmentArrayList = clientSecretary.getDoctorWithID(2, token);
        Doctor doctor = new Doctor("Sean", "Dunlop", LocalDate.of(1999, 7, 23), 403, "658 Boulevard street", 2, "87630483", "Pharmacist", "Second Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0));

        Assert.assertEquals(doctor, appointmentArrayList);
    }

    @Test
    public void TestgetAppointmentsCurrentDoctor() throws ServerException {

        ArrayList<Appointment> appointmentArrayList = clientSecretary.getAppointmentsCurrentDoctor(2, token);

        ArrayList<Appointment> list = new ArrayList<>();
        list.add(new Appointment(new DataReader().readPatients().get(1), new DataReader().readDoctors().get(1), LocalDate.of(2018, 12, 2), "13:30", new Diagnosis("Sick", LocalDate.of(2018, 12, 2), "You are sick"), new Prescription("Drug", LocalDate.of(2018, 12, 2), "Cures being sick", "Take once an hour")));

        Assert.assertEquals(list, appointmentArrayList);
    }

    @Test
    public void TestgetPatientAll() throws ServerException {

        ArrayList<Appointment> appointmentArrayList = clientSecretary.getAppointmentsCurrentDoctor(2, token);

        ArrayList<Patient> list = new ArrayList<>();

        list.add(new Patient("Dawson", "Aevo", LocalDate.of(2000, 3, 26 ), 696969, "420 oh heck yeah Street", 14, "80-7259803", 2525, LocalDate.of(2020, 1, 12), "ON"));
        list.add(new Patient("Aidan", "Johnston", LocalDate.of(1999, 5, 25), 2525, "Hey there this is an adress",  52352, "607-2343", 242, LocalDate.of(2020, 12, 23), "ON"));

        Assert.assertEquals(list, appointmentArrayList);
    }

    @Test
    public void TestsearchDoctorName() throws ServerException {

        ArrayList<Doctor> appointmentArrayList = clientSecretary.searchDoctorName("Sean", token);

        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor("Sean", "Dunlop", LocalDate.of(1999, 7, 23), 403, "658 Boulevard street", 2, "87630483", "Pharmacist", "Second Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0)));

        Assert.assertEquals(list, appointmentArrayList);
    }
    @Test
    public void TestsearchDoctorDate() throws ServerException {

        ArrayList<Doctor> appointmentArrayList = clientSecretary.searchDoctorDate(LocalDate.of(2018, 12 ,2), token);
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor("Sean", "Dunlop", LocalDate.of(1999, 7, 23), 403, "658 Boulevard street", 2, "87630483", "Pharmacist", "Second Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0)));

        Assert.assertEquals(list, appointmentArrayList);
    }

}
