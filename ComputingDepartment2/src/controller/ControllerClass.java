package controller;

import model.*;
import view.Frame;

public class ControllerClass 
{
	private Department department;
	private Frame frame;
	
	
	public ControllerClass()
	{
		department = new Department();
		frame = new Frame(this);
		frame.setVisible(true);
	}
	
	
	public void reqAddLab(String pLabName)
	{
		try 
		{
			boolean result = department.addNewLaboratory(pLabName);
			String message = "Your Lab has been Successfully added";
			int n = department.getNumLabs();
			frame.refreshInfoPanel(n);
			if(result == false)
			{
				message = "Your Lab was not added";
			}
			frame.displayMassageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}	
	}
	
	public void reqAddResearcher(String pLaboratory, String pFirstName, String pLastName, int pAge)
	{
		try 
		{
			boolean result = department.addNewResearcher(pLaboratory, pFirstName, pLastName, pAge);
			String message = "Your Researcher was successfully added to the lab";
			int n = department.getNumLabs();
			frame.refreshInfoPanel(n);
			if(result == false)
			{
				message = "Your researcher was not added";
			}
			frame.displayMassageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqYoungResearch()
	{
		try 
		{
			Researcher result = department.findYoungestResearcher();
			String message = "The Youngest Researcher in the Dept is " + result.getName();
			int n = department.getNumLabs();
			frame.refreshInfoPanel(n);
			frame.displayMassageToUser(message);
			
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqResearchAverage()
	{
		try 
		{
			double result = department.averageAgeDepartment();
			String message = "The Average age of the Dept is " + result + "year(s) old";
			int n = department.getNumLabs();
			frame.refreshInfoPanel(n);
			frame.displayMassageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqLargestLab()
	{
		try 
		{
			Laboratory result = department.mostPopulatedLaboratory();
			String message;
			if(result != null)
			{
				message = "The Most Populated Laboratory is: " + result.getName();
			}
			else
			{
				message = "Not Found";
			}
			int n = department.getNumLabs();
			frame.refreshInfoPanel(n);
			frame.displayMassageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqOlderResearch(int pAge)
	{
		try 
		{
			int result = department.OlderResearcher(pAge);
			String message = ("The Number of Researchers older then the input is: " + result);
			
			int n = department.getNumLabs();
			frame.refreshInfoPanel(n);
			frame.displayMassageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		ControllerClass c = new ControllerClass();
	}
	
	
	
}
