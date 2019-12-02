package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.*;
import Util.Exceptions.ServerException;
import Util.UserType;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import Clinic.Client.ClientSecretary;

import java.util.ArrayList;

public class createAppointmentPageController extends baseController{

    public Session session;
    public GridPane createAppointmentPage;

    private boolean isnewAppointment;

    private ArrayList<Patient> availablePatients;
    private ArrayList<Doctor> availableDoctors;

    public ComboBox<Patient> patientBox;
    public ComboBox<Doctor> doctorBox;
    public DatePicker dayField;
    public TextField timeField;

    public void initWithData(Session _session){
        session = _session;
        popAvailable();
        if(session.getDataObject() == null){
            isnewAppointment = true;
        }
        else{
            isnewAppointment = false;
            Appointment app =(Appointment) session.getDataObject();
            patientBox.setValue(app.getPatient());
            doctorBox.setValue(app.getDoctor());
            dayField.setValue(app.getDate());
            timeField.setText(app.getTime());
        }

        patientBox.getItems().addAll(availablePatients);
        doctorBox.getItems().addAll(availableDoctors);
    }

    private void popAvailable(){
        try{
            ClientSecretary client = session.getClient();
            availableDoctors = client.getDoctorAll(session.getToken());
            availablePatients = client.getPatientAll(session.getToken());
        }catch(ServerException ex){
            System.out.println("Failed getting doctors or patients");
        }

    }

    public void createAppointment() {
        Appointment appointment = new Appointment();
        if(isnewAppointment){
            appointment = new Appointment(
                    patientBox.getValue(),
                    doctorBox.getValue(),
                    dayField.getValue(),
                    timeField.getText(),
                    null,
                    null
            );

            try{
                ClientSecretary client = session.getClient();
                client.makeAppointment(session.getToken(), appointment);

                if(session.getToken().getType() == UserType.STAFF)switchScene(createAppointmentPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
                if(session.getToken().getType() == UserType.PATIENT)switchScene(createAppointmentPage, "../pages/patientHomePage.fxml", patientHomePageController.class, session);


            }catch(ServerException ex){
                System.out.print("Failed Making appointment");
            }
        }
        else{
            appointment = (Appointment)session.getDataObject();
            appointment.setPatient(patientBox.getValue().getID());
            appointment.setDoctor(doctorBox.getValue());
            appointment.setDate(dayField.getValue());
            appointment.setTime(timeField.getText());

            try{
                ClientSecretary client = session.getClient();
                if(appointment.getID()==0){
                    client.makeAppointment(session.getToken(), appointment);
                }else{
                    client.editAppointment( appointment, session.getToken());
                }


                switchScene(createAppointmentPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
            }catch(ServerException ex){
                System.out.print("Failed Making appointment");
            }
        }



    }

    public void addScript() {
        if(isnewAppointment){
            session.setDataObject(new Appointment(
                    patientBox.getValue(),
                    doctorBox.getValue(),
                    dayField.getValue(),
                    timeField.getText(),
                    null,
                    null
            ));
        }
        switchScene(createAppointmentPage, "../pages/createPrescriptionPage.fxml", createPrescriptionPageController.class, session);
    }

    public void addDiagnosis() {
        if(isnewAppointment){
            session.setDataObject(new Appointment(
                    patientBox.getValue(),
                    doctorBox.getValue(),
                    dayField.getValue(),
                    timeField.getText(),
                    null,
                    null
            ));
        }
        switchScene(createAppointmentPage, "../pages/createDiagnosisPage.fxml", createDiagnosisPageController.class, session);
    }
}
