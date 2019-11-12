package Clinic.Client.GUI;

import javax.swing.*;

import Clinic.Core.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ResultsPanel <T> extends JPanel
{
	private ArrayList<ResultsEntry> entries;
	
	public ResultsPanel(ArrayList<T> items) {
		
		entries = new ArrayList<ResultsEntry>();
		for (T item : items) {

			try {
				entries.add(ResultsEntry.class.getConstructor(item.getClass()).newInstance(item));
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Results:"));
		for(ResultsEntry e : entries){
			add(e);
		}
		revalidate();
	}
	
}

class ResultsEntry extends JPanel
{
	private String text;
	private JLabel label;
	private JButton button;
	
	public ResultsEntry(String _text) {
		
		System.out.println(_text + "was received");
		text = _text;
		label = new JLabel(text);
		button = new JButton("Go");
		
		add(label);
		add(button);
		
	}

	public ResultsEntry(Object o)
	{
		this(o.toString());
		System.out.print("Oops you used the object constructor");
	}

	public ResultsEntry(Doctor d) {

		this(String.format("%s %s : %s", d.getFname(), d.getLName(), d.getSpecialty()));

	}

	public ResultsEntry(Patient p) {

		this(String.format("%s %s", p.getFname(), p.getLName()));

	}
}