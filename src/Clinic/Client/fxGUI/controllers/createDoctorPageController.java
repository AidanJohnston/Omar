package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
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

import java.time.LocalDate;
import java.util.Date;

public class createDoctorPageController extends baseController{

    public Session session;
    public GridPane createDoctorPage;

    public TextField fnameField;
    public TextField lnameField;
    public DatePicker bdayField;
    public TextField sinField;
    public TextField addressField;
    public TextField idField;
    public TextField phoneField;
    public TextField specField;
    public TextField rankField;

    public void initWithData(Session _session) {
        session = _session;
    }

    public void createDoctor(ActionEvent actionEvent) {

        Doctor newDoctor = new Doctor(
                fnameField.getText(),
                lnameField.getText(),
                bdayField.getValue(),
                Integer.parseInt(sinField.getText()),
                addressField.getText(),
                phoneField.getText(),
                specField.getText()
        );
        newDoctor.setRank(rankField.getText());
        System.out.println("AGHJ");

        try{
            ClientSecretary client = session.getClient();
            client.createDoctor(newDoctor, session.getToken());

            switchScene(createDoctorPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);

        }catch(ServerException ex){
            System.out.println("Adding Doctor Failed");
        }
    }


}
