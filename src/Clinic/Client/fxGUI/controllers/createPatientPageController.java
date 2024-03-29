package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Credentials;
import Clinic.Core.Patient;
import Util.Exceptions.ServerException;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class createPatientPageController extends baseController{

    private Session session;
    public GridPane createPatientPage;

    public TextField fnameField;
    public TextField lnameField;
    public DatePicker bdayField;
    public TextField sinField;
    public TextField addressField;
    public TextField phoneField;
    public TextField hcnumField;
    public DatePicker hcexpField;
    public TextField provinceField;
    public TextField userField;
    public TextField passField;

    public void initWithData(Session _session){



        session = _session;


       hcnumField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {

                hcnumField.setText(oldValue);

            }
        });
        sinField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                sinField.setText(oldValue);
            }
        });
    }

    public void createPatient(){
        Patient newPatient = new Patient(
                fnameField.getText(),
                lnameField.getText(),
                bdayField.getValue(),
                Long.parseLong(sinField.getText()),
                addressField.getText(),
                phoneField.getText(),
                Long.parseLong(hcnumField.getText()),
                hcexpField.getValue(),
                provinceField.getText()
        );

        //USE SOMETHING LIKE THIS, WE DONT NEED TYPE OR ID HERE
        Credentials creds = new Credentials(userField.getText(), passField.getText());
        if(session.getDataObject().toString().equalsIgnoreCase("new")){
            try{
                ClientSecretary client = session.getClient();

                //JUST COMMENT THIS OUT IF U NEED TO TEST, SEAN NEEDS TO ADD CREDENTIALS
                //client.createPatient(newPatient, creds ,session.getToken());
                session.setToken(client.createAccount(newPatient,creds));
                switchScene(createPatientPage, "../pages/patientHomePage.fxml", patientHomePageController.class, session);

            }catch(ServerException e){
                System.out.println("Create account failed");
            }
        }else{
            try{
                ClientSecretary client = session.getClient();

                //JUST COMMENT THIS OUT IF U NEED TO TEST, SEAN NEEDS TO ADD CREDENTIALS
                client.createPatient(newPatient, creds ,session.getToken());

                switchScene(createPatientPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);

            }catch(ServerException e){
                System.out.println("Create patient failed");
            }
        }


    }

}
