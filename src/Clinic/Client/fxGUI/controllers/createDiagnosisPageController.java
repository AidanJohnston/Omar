package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Appointment;
import Clinic.Core.Diagnosis;
import Clinic.Core.Prescription;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.xml.soap.Text;

public class createDiagnosisPageController extends baseController {

    private Session session;
    public TextField nameField;
    public DatePicker dateField;
    public TextField noteField;
    public Appointment appt;
    public GridPane createDiagnosisPage;

    public void initWithData(Session _session) {
        session = _session;
        appt = (Appointment)session.getDataObject();
    }

    public void createDiagnosis() {
        Diagnosis newDiag = new Diagnosis(
                nameField.getText(),
                dateField.getValue(),
                noteField.getText()
        );

        appt.setDiagnosis(newDiag);
        session.setDataObject(appt);
        switchScene(createDiagnosisPage, "../pages/createAppointmentPage.fxml", createAppointmentPageController.class, session);
    }
}
