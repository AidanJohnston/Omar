package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Util.Exceptions.ServerException;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class displayDoctorsPageController extends baseController {

    public  Session session;
    GridPane viewDoctors;
    public TextField name;
    public TextField date;

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

    }

    public void searchDoctorName(ActionEvent actionEvent) {

    }

    public void view(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) {
        switchScene(viewDoctors, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
    }
}
