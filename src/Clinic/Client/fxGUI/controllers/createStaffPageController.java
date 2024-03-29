package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Credentials;
import Clinic.Core.Staff;
import Util.Exceptions.ServerException;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;

public class createStaffPageController extends baseController {

    public Session session;
    public GridPane createStaffPage;

    public TextField fnameField;
    public TextField lnameField;
    public DatePicker bdayField;
    public TextField sinField;
    public TextField addressField;
    public TextField idField;
    public TextField phoneField;
    public TextField userField;
    public TextField passField;

    @Override
    public void initWithData(Session _session) {
        session = _session;
    }

    public void createStaff() {

        Staff staff = new Staff(
            fnameField.getText(),
            lnameField.getText(),
            bdayField.getValue(),
            Integer.parseInt(sinField.getText()),
            addressField.getText(),
            0,
            phoneField.getText()
        );
        Credentials creds = new Credentials(userField.getText(), passField.getText());
        try {
            ClientSecretary client = session.getClient();
            client.createStaff(staff, creds, session.getToken());

            switchScene(createStaffPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);

        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}
