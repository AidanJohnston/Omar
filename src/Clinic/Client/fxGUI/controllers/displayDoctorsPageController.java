package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Clinic.Core.User;
import Util.Exceptions.ServerException;
import Util.UserType;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class displayDoctorsPageController extends baseController {

    public Session session;
    public GridPane displayDoctorsPage;
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
        doctorDisplay.getItems().removeAll(doctorList);
        try{
            doctorList = session.getClient().searchDoctorDate(LocalDate.parse(doctorDate.getText()), session.getToken());
        } catch (ServerException e) {
            e.printStackTrace();
        }


        doctorDisplay.getItems().addAll(doctorList);
    }

    public void searchDoctorName(ActionEvent actionEvent) {
        doctorDisplay.getItems().removeAll(doctorList);
        try{
            doctorList = session.getClient().searchDoctorName(doctorName.getText(), session.getToken());
        } catch (ServerException e) {
            e.printStackTrace();
        }

        doctorDisplay.getItems().addAll(doctorList);
    }

    public void view(ActionEvent actionEvent) {
        session.setDataObject(doctorDisplay.getValue().getID());
        switchScene(displayDoctorsPage, "../pages/viewDoctorPage.fxml", viewDoctorPageController.class, session);
    }

    public void back() {
        if(session.getToken().getType() == UserType.DOCTOR){
            switchScene(displayDoctorsPage, "../pages/doctorHomePage.fxml", doctorHomePageController.class, session);
        }
        if(session.getToken().getType()== UserType.PATIENT){
            switchScene(displayDoctorsPage, "../pages/patientHomePage.fxml", patientHomePageController.class, session);
        }

    }
}
