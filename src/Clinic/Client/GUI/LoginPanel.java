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

        /*
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth = 3;
        gc.gridheight = 3;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        //gc.ipadx = 10;
        //gc.ipady = 10;
        this.setPreferredSize(new Dimension(40,400));

        addAt(title, gc, 1,0);
        addAt(userLabel, gc, 0, 1);
        addAt(passLabel, gc, 0, 2);
        addAt(userField, gc, 1,1);
        addAt(passField, gc, 1, 2);
*/
        GridBagLayout layout = new GridBagLayout();

        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JButton("Button 1"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(new JButton("Button 2"),gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new JButton("Button 3"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(new JButton("Button 4"),gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(new JButton("Button 5"),gbc);

        this.setVisible(true);




    }

    private void addAt(Component c, GridBagConstraints gc, int x, int y){
        gc.gridx = x;
        gc.gridy = y;
        this.add(c);
    }
}
