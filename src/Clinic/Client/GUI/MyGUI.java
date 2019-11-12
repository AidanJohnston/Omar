package Clinic.Client.GUI;

import javax.swing.*;

import Clinic.Client.ClientSecretary;
import Clinic.Core.Token;

import java.awt.*;


public class MyGUI {
	
	public MyGUI(ClientSecretary _client, Token _token){
		JFrame frame = new JFrame("Test Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,1200);
		
		
		frame.getContentPane().add(BorderLayout.NORTH, new DoctorSearch(_client, _token));
		frame.getContentPane().add(BorderLayout.SOUTH, new LoginPanel(_client, _token));
		frame.setVisible(true);
		
		
	}
}
