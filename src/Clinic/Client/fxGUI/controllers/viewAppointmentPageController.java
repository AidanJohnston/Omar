package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Appointment;
import Clinic.Core.Prescription;
import Util.Exceptions.ServerException;
import Util.RequestType;
import Util.UserType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class viewAppointmentPageController extends baseController{

    public Session session;

    public GridPane viewAppointmentPage;
    public ComboBox<Appointment> appointmentCombo;

    public Button search;
    public Button edit;

    public Label doctorName;
    public Label date;
    public Label time;
    public Label diagnosis;
    public Label prescription;

    ArrayList<Appointment> appointmentArrayList;

    public void initWithData(Session _session) {
        if(session.getToken().getType().equals(UserType.STAFF)) {
            try {
                appointmentArrayList = session.getClient().getAllAppointment(session.getToken());
            } catch (ServerException e) {
                e.printStackTrace();
            }
            appointmentCombo.getItems().addAll(appointmentArrayList);
        }
        if(session.getToken().getType().equals(UserType.DOCTOR)) {
            try {
                appointmentArrayList = session.getClient().getAllAppointment(session.getToken());
            } catch (ServerException e) {
                e.printStackTrace();
            }
            appointmentCombo.getItems().addAll(appointmentArrayList);
        }
        if(session.getToken().getType().equals(UserType.PATIENT)) {
            try {
                appointmentArrayList = session.getClient().getAppointmentPatientAll(session.getToken(), session.getToken().getUserID());
            } catch (ServerException e) {
                e.printStackTrace();
            }
            edit.setDisable(true);
            appointmentCombo.getItems().addAll(appointmentArrayList);
        }
    }


    public void search() {
        doctorName.setText(appointmentCombo.getValue().getDoctor().toString());
        date.setText(appointmentCombo.getValue().getDate().toString());
        time.setText(appointmentCombo.getValue().getTime());
        diagnosis.setText(appointmentCombo.getValue().getDiagnosis().getName());
        prescription.setText(appointmentCombo.getValue().getPrescription().getName());
    }


    public void edit() {
        session.setDataObject(appointmentCombo.getValue());
        switchScene(viewAppointmentPage, "../page/createAppointmentPage.fxml", createAppointmentPageController.class, session);
    }
}
