package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class patientHomePageController extends baseController {

    private Session session;
    @FXML
    private GridPane patientHomePage;

    public void logout(ActionEvent actionEvent) {
        switchScene(patientHomePage, "../pages/loginPage.fxml", loginController.class, session);
    }

    @Override
    public void initWithData(Session _session) {
        session = _session;
    }
}
