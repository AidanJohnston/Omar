package Clinic.Client.fxGUI;

import Clinic.Core.Doctor;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

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
            data.add(doc.getFname());
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
            Label label = new Label(s);
            labels.add(label);
            getChildren().add(label);
            this.setOrientation(Orientation.HORIZONTAL);
            Button button = new Button("Go");
            getChildren().add(button);
        }
            //getChildren().addAll(labels);

    }

}
