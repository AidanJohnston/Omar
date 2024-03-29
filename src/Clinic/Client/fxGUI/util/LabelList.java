package Clinic.Client.fxGUI.util;

import Clinic.Core.Appointment;
import Clinic.Core.Doctor;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LabelList extends FlowPane {

    private FlowPane container;

    private ArrayList<Label> labels;

    public LabelList(ArrayList<Doctor> doctors, Doctor d){
        //d is unused because java is dumb and thinks all methods with arraylist params are the same signature
        ArrayList<String> data = new ArrayList<String>();

        for(Doctor doc : doctors){
            data.add(doc.getFName());
        }
        init(data);
    }

    public LabelList(ArrayList<Appointment> appointments, Appointment a){
        //d is unused because java is dumb and thinks all methods with arraylist params are the same signature
        ArrayList<String> data = new ArrayList<String>();

        for(Appointment app : appointments){
            data.add(app.getPatient().getFName() + " " + app.getPatient().getLName() + " : " + app.getDate().toString());
        }
        init(data);
    }


    private LabelList(ArrayList<String> data){
        init(data);
    }

    public void init(ArrayList<String> data){

        this.setOrientation(Orientation.VERTICAL);
        labels = new ArrayList<Label>();

        for(String s : data){

            HBox box = new HBox();
            box.setStyle("-fx-border-color: #504f50; -fx-border-width: 3");

            Label label = new Label(s);
            labels.add(label);
            Button button = new Button("Go");
            box.getChildren().add(label);
            box.getChildren().add(button);

            this.getChildren().add(box);
        }

    }

}
