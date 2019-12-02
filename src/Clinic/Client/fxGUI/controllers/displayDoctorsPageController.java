package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Util.Exceptions.ServerException;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class displayDoctorsPageController extends baseController {

    public Session session;
    GridPane viewDoctors;
    public TextField doctorName;
    public TextField doctorDate;

    public Button nameButton;
    public Button dateButton;

    public ArrayList<Doctor> doctorList;
    public ComboBox<Doctor> doctorDisplay;

    @Override
    public void initWithData(Session _session) {
        session = _session;

        try{
            doctorList = session.getClient().getDoctorAll(session.getToken());
        } catch (ServerException e) {
            e.printStackTrace();
        }

        doctorDisplay.getItems().addAll(doctorList);
    }

    public void searchDoctorDate(ActionEvent actionEvent) {
        try{
            doctorList = session.getClient().searchDoctorDate(LocalDate.parse(doctorDate.getText()), session.getToken());
        } catch (ServerException e) {
            e.printStackTrace();
        }

        doctorDisplay.getItems().addAll(doctorList);
    }

    public void searchDoctorName(ActionEvent actionEvent) {
        try{
            doctorList = session.getClient().searchDoctorName(doctorName.getText(), session.getToken());
        } catch (ServerException e) {
            e.printStackTrace();
        }

        doctorDisplay.getItems().addAll(doctorList);
    }

    public void view(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) {
        switchScene(viewDoctors, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
    }
}
