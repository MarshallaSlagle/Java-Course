package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControllerClass;


public class Frame extends JFrame
{
	private ActionsPanel jpActions;
	private InfoPanel jpInfo;
	
	private ControllerClass controller;
	
	public Frame(ControllerClass pController)
	{
		controller = pController;
		setLayout(new BorderLayout());
		jpActions = new ActionsPanel(this);
		jpInfo = new InfoPanel();
		add(jpActions, BorderLayout.CENTER);
		add(jpInfo, BorderLayout.SOUTH);
		
		setTitle("Computing Deparment");
		setSize(new Dimension(600,270));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
	public void displayMassageToUser(String pMessage)
	{
		JOptionPane.showMessageDialog(this, pMessage);
	}
	
	public void displayErrorToUser(String pMessage)
	{
		JOptionPane.showMessageDialog(this, pMessage, "Warning!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void requestAddLab()
	{
		String labName = JOptionPane.showInputDialog(this, "Please input the Lab name: ");
		controller.reqAddLab(labName);
	}
	
	public void requestAddResearcher()
	{
		String laboratory = JOptionPane.showInputDialog(this, "Please input the Laboratory Name: ");
		String firstName = JOptionPane.showInputDialog(this, "Please input the First Name: ");
		String lastName = JOptionPane.showInputDialog(this, "Please input the Last Name: ");
		try
		{
			String txt = JOptionPane.showInputDialog(this, "Please input the Age: ");
			int age = Integer.parseInt(txt);
			controller.reqAddResearcher(laboratory, firstName, lastName, age);
		}
		catch(Exception e)
		{
			displayErrorToUser("InValid Age!");
		}
	}
	
	public void requestYoungResearch()
	{
		controller.reqYoungResearch();
	}

	public void requestResearchAverage()
	{
		controller.reqResearchAverage();
	}
	
	public void requestLargestLab()
	{
		controller.reqLargestLab();
	}
	
	public void requestOlderResearch()
	{
		try
		{
			String txt = JOptionPane.showInputDialog(this, "Please input the Age: ");
			int age = Integer.parseInt(txt);
			controller.reqOlderResearch(age);
		}
		catch(Exception e)
		{
			displayErrorToUser("In Valid Age!");
		}
	}
	
	public void refreshInfoPanel(int pNumberOfLabs)
	{
		
		jpInfo.updateNumber(pNumberOfLabs);
	}
	
}
