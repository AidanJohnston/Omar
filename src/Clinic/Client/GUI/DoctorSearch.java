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

public class DoctorSearch extends JPanel
{
	private JTextField input;
	private Token token;
	private JButton enter;
	private JLabel label;
	private ClientSecretary client;
	private ResultsPanel<Doctor> results;
	public DoctorSearch(ClientSecretary _client, Token _token) 
	{
		client = _client;
		token = _token;
		input = new JTextField(25);
		enter = new JButton("Enter");
		label = new JLabel("Enter Doctor ID");
		results = new ResultsPanel<Doctor>(new ArrayList<Doctor>());

		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				remove(results);
				results = new ResultsPanel<Doctor>(getDoctorResults(Integer.parseInt(input.getText())));
				add(results);
				revalidate();
			}
		});
		
		add(label);
		add(input);
		add(enter);
		add(results);
		this.setLayout(new FlowLayout());
		
	}
	private ArrayList<Doctor> getDoctorResults(int id) {
		try
		{
		return client.getDoctorWithID(id, token);
		} catch (IncorrectPayloadException e)
		{
			return new ArrayList<Doctor>();
		}
	}
}
