package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Token;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.LoginFailedException;
import Util.Exceptions.ServerException;
import Util.UserType;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Clinic.Client.ClientSecretary;

public class staffHomePageController extends baseController{

    public GridPane staffHomePage;
    private Session session;


    public void initWithData(Session _session) {
        session = _session;
    }

    public void createDoctor(){
        switchScene(staffHomePage, "../pages/createDoctorPage.fxml", createDoctorPageController.class, session);
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
        switchScene(staffHomePage, "../pages/loginPage.fxml", loginController.class, session);
    }

}
