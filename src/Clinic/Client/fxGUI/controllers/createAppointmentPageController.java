package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Clinic.Core.Patient;
import Clinic.Core.Token;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.LoginFailedException;
import Util.Exceptions.ServerException;
import Util.UserType;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Clinic.Client.ClientSecretary;

import java.util.ArrayList;

public class createAppointmentPageController extends baseController{

    public Session session;
    public GridPane createAppointmentPage;

    private ArrayList<Patient> availablePatients;
    private ArrayList<Doctor> availableDoctors;


    

    public void initWithData(Session _session){
        session = _session;
        popAvailable();
    }



    private void popAvailable(){
        try{
            ClientSecretary client = session.getClient();
            availableDoctors = client.getDoctorAll(session.getToken());
            availablePatients = client.getPatientAll(session.getToken());
        }catch(ServerException ex){
            System.out.println("Failed gettng doctors or patients");
        }
    }


}
