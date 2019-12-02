package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Appointment;
import Clinic.Core.Prescription;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class createPrescriptionPageController extends baseController{

    public Appointment appt;
    public GridPane createPrescriptionPage;
    public TextField nameField;
    public TextField noteField;
    public TextField instructionField;
    public DatePicker dateField;

    private Session session;

    public void initWithData(Session _session){
        session = _session;
        appt = (Appointment)session.getDataObject();
    }

    public void createPrescription() {
        Prescription newScript = new Prescription(
                nameField.getText(),
                dateField.getValue(),
                noteField.getText(),
                instructionField.getText()
        );

        appt.setPrescription(newScript);
        session.setDataObject(appt);
        switchScene(createPrescriptionPage, "../pages/createAppointmentPage.fxml", createAppointmentPageController.class, session);
    }
}
