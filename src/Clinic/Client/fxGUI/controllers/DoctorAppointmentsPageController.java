package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.LabelList;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Appointment;
import Util.Exceptions.ServerException;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class DoctorAppointmentsPageController extends baseController{

    public GridPane doctorAppointmentsPage;
    public VBox resultsBox;

    private Session session;

    public void initWithData(Session _session){
        session = _session;
        showAllAppointments();
    }

    public void showAllAppointments(){
        ArrayList<Appointment> appointments = (ArrayList<Appointment>)session.getDataObject();
        LabelList results = new LabelList(appointments, new Appointment());
        resultsBox.getChildren().add(results);
        doctorAppointmentsPage.getChildren().add(resultsBox);
    }

    public void logout(ActionEvent e)
    {
        try{
            ClientSecretary client = session.getClient();
            client.logout(session.getToken());
        }
        catch(ServerException ex){
            System.out.println("Logout Failed, doing it anyways");
        }
        switchScene(doctorAppointmentsPage, "../pages/loginPage.fxml", loginController.class, session);
    }
}
