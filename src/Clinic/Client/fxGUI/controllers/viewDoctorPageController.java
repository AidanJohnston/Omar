package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Util.Exceptions.ServerException;
import Util.UserType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;

public class viewDoctorPageController extends baseController {

    public Session session;

    public GridPane viewDoctorPage;

    public Label fname;
    public Label lname;
    public Label specialty;
    public Label rank;

    public Button back;

    @Override
    public void initWithData(Session _session) {
        session = _session;
        Doctor doctor = new Doctor();
        try {
            doctor = session.getClient().getDoctorWithID((int) session.getDataObject(), session.getToken());
        } catch (ServerException e) {
            e.printStackTrace();
        }

        fname.setText(doctor.getFname());
        lname.setText(doctor.getLName());
        specialty.setText(doctor.getSpecialty());
        rank.setText(doctor.getRank());
    }

    public void back() {
        if (session.getToken().getType() == UserType.DOCTOR) {
            switchScene(viewDoctorPage, "../pages/doctorHomePage.fxml", doctorHomePageController.class, session);
        }
        if (session.getToken().getType() == UserType.PATIENT) {
            switchScene(viewDoctorPage, "../pages/patientHomePage.fxml", patientHomePageController.class, session);
        }
        if (session.getToken().getType() == UserType.STAFF) {
            switchScene(viewDoctorPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
        }

    }
}
