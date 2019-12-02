package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Appointment;
import Clinic.Core.Doctor;
import Clinic.Core.Patient;
import Clinic.Core.Token;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.LoginFailedException;
import Util.Exceptions.ServerException;
import Util.UserType;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Clinic.Client.ClientSecretary;
import java.time.LocalTime;

import java.util.ArrayList;

public class createAppointmentPageController extends baseController{

    public Session session;
    public GridPane createAppointmentPage;

    private ArrayList<Patient> availablePatients;
    private ArrayList<Doctor> availableDoctors;

    public ComboBox<Patient> patientBox;
    public ComboBox<Doctor> doctorBox;
    public DatePicker dayField;
    public TextField timeField;

    public void initWithData(Session _session){
        session = _session;
        popAvailable();

        patientBox.getItems().addAll(availablePatients);
        doctorBox.getItems().addAll(availableDoctors);
    }

    private void popAvailable(){
        try{
            ClientSecretary client = session.getClient();
            availableDoctors = client.getDoctorAll(session.getToken());
            availablePatients = client.getPatientAll(session.getToken());
        }catch(ServerException ex){
            System.out.println("Failed getting doctors or patients");
        }

    }

    public void createAppointment() {
        Appointment newAppointment = new Appointment(
                patientBox.getValue(),
                doctorBox.getValue(),
                dayField.getValue(),
                timeField.getText(),
                null,
                null
        );

        try{
            ClientSecretary client = session.getClient();
            client.makeAppointment(session.getToken(),newAppointment);

            switchScene(createAppointmentPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
        }catch(ServerException ex){
            System.out.print("Failed Making appointment");
        }

    }


}
