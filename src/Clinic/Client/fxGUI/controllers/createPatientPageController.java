package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Patient;
import Util.Exceptions.ServerException;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class createPatientPageController extends baseController{

    private Session session;
    public GridPane createPatientPage;

    public TextField fnameField;
    public TextField lnameField;
    public DatePicker bdayField;
    public TextField sinField;
    public TextField addressField;
    public TextField idField;
    public TextField phoneField;
    public TextField hcnumField;
    public DatePicker hcexpField;
    public TextField provinceField;

    public void initWithData(Session _session){
        session = _session;
    }

    public void createPatient(){
        Patient newPatient = new Patient(
                fnameField.getText(),
                lnameField.getText(),
                bdayField.getValue(),
                Integer.parseInt(sinField.getText()),
                addressField.getText(),
                phoneField.getText(),
                Integer.parseInt(hcnumField.getText()),
                hcexpField.getValue(),
                provinceField.getText()
        );

        try{
            ClientSecretary client = session.getClient();
            //client.
            throw new ServerException("");
        }catch(ServerException e){

        }

    }

}
