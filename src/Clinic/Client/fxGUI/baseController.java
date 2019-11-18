package Clinic.Client.fxGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class baseController {

    public Stage stage;
    public Parent root;

    public abstract void initWithData(Session _session);
    public <R extends baseController>void switchScene(Parent newRoot, String newFile, R type){
        switchScene(newRoot, newFile, type.getClass(), new Session(null,null, null));
    }

    public <R extends baseController> void switchScene(Parent newRoot, String newFile, Class<R> type, Session _session){

        try{
            stage = (Stage)newRoot.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(newFile));
            FXMLLoader loader = new FXMLLoader(getClass().getResource(newFile));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            R controller = loader.<R>getController();
            controller.initWithData(_session);

            stage.show();

        }catch(IOException ex){System.out.println("scene machine broke");}

    }

}
