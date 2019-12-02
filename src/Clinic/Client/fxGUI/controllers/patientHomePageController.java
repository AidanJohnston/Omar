package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.Session;
import Util.Exceptions.ServerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class patientHomePageController extends baseController {

    private Session session;
    @FXML
    private GridPane patientHomePage;

    public void logout(ActionEvent actionEvent) {
        try{
            ClientSecretary client = session.getClient();
            client.logout(session.getToken());
        }
        catch(ServerException ex){
            System.out.println("Logout Failed, doing it anyways");
        }
        switchScene(patientHomePage, "../pages/loginPage.fxml", loginController.class, session);
    }

    @Override
    public void initWithData(Session _session) {
        session = _session;
    }

    public void searchDoctor(ActionEvent actionEvent) {
        switchScene(patientHomePage, "../pages/displayDoctorsPage.fxml", displayDoctorsPageController.class, session);
    }
}
