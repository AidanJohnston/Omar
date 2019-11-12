package Clinic.Client.GUI;

import javax.swing.*;

import Clinic.Client.ClientSecretary;
import Clinic.Core.*;
import Util.*;
import Util.Exceptions.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginPanel extends JPanel {
    private JLabel title;
    private JLabel userLabel;
    private JLabel passLabel;
    private JButton submit;

    private JTextField userField;
    private JTextField passField;

    private Token token;
    private ClientSecretary client;

    public LoginPanel(ClientSecretary _client, Token _token){
        token = _token;
        client = _client;

        title = new JLabel();
        userLabel = new JLabel();
        passLabel = new JLabel();

        userField = new JTextField();
        passField = new JTextField();


        title.setText("Clinic Login");
        userLabel.setText("Username");
        passLabel.setText("Password");

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth = 3;
        gc.gridheight = 3;
        //c.weightx = 0.5;
        //c.weighty = 0.5;

        addAt(title, gc, 1,0);
        addAt(userLabel, gc, 0, 1);
        addAt(passLabel, gc, 0, 2);
        addAt(userField, gc, 1,1);
        addAt(passField, gc, 1, 2);


    }

    private void addAt(Component c, GridBagConstraints gc, int x, int y){
        gc.gridx = x;
        gc.gridy = y;
        this.add(c);
    }
}
