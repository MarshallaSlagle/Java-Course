package controller;
import java.util.*;
import model.*;

public class InteractionClass 
{

	public static void main(String[] args) 
	{
		Country country = new Country();
		
		Scanner input = new Scanner(System.in);
		boolean appStatus = true;
		
		while(appStatus)
		{
			System.out.println("Welcome Luke to your Country!");
			System.out.println("Please select one of the following actions:");
			System.out.println("Add a new State [Press 1]");
			System.out.println("Add a new City [Press 2]");
			System.out.println("Find the smallest state [Press 3]");
			System.out.println("Find the most populated city [Press 4]");
			System.out.println("find population of state [Press 5]");
			System.out.println("Exit the Application [Press Q]");
			
			char option = input.nextLine().charAt(0);
			
			if(option == '1')
			{
				System.out.println("Please enter your state's name:");
				String name = input.nextLine();
				System.out.println("Please enter your state's area:");
				double area = input.nextDouble();
				input.nextLine();
				boolean addition = country.addState(name, area);
				if(addition)
				{
					System.out.println("Your State has been added");
				}
				else
				{
					System.out.println("Your State was not added");
				}
				
			
				
			}
			else if(option == '2')
			{
				System.out.println("Please enter your state's name:");
				String stateName = input.nextLine();
				System.out.println("Please enter your city's name:");
				String cityName = input.nextLine();
				System.out.println("Please enter your city's population:");
				int cityPop = input.nextInt();
				input.nextLine();
				boolean addition = country.addCity(stateName, cityName, cityPop);
				if(addition)
				{
					System.out.println("Your City has been added");
				}
				else
				{
					System.out.println("Your City was not added");
				}
			
			}
			else if(option == '3')
			{
				State smallState = country.findSmallestState();
				if(smallState != null)
				{
					System.out.println("The Smallest State is:");
					System.out.println("Name: " + smallState.getName());
					System.out.println("Area: " + smallState.getArea());
					System.out.println("State Population: " + smallState.getPopulation());
					System.out.println("Number of Cities: " + smallState.getNumberOfCities());
					if(smallState.findMostPopulationCityState() != null)
					{
						System.out.println("Most Populated City: " + smallState.findMostPopulationCityState().getName());
					}
				}
				else
				{
					System.out.println("The Smallest State was not found");
				}
			
			}
			else if(option == '4')
			{
				City popCity = country.findMostPopulatedCityCountry();
				if(popCity != null)
				{
					System.out.println("The most populated City is:");
					System.out.println("Name: " + popCity.getName());
					System.out.println("Population: " + popCity.getPopulation());
				}
				else
				{
					System.out.println("The most populated City was not found");
				}
			
			}
			else if(option == '5')
			{
				System.out.println("Please enter your state's name:");
				String stateName = input.nextLine();
				int pop = country.findStatePopulation(stateName);
				System.out.println("Population: " + pop);
			
			}
			
			
			
			else if (option == 'Q')
			{
				break;
			}
			
			System.out.println("\n\t** Return to Main Menu [Enter 1]");
			System.out.println("\t** Exit Program        [Enter 2]");
			while(true)
			{
				int response = input.nextInt();
				if(response == 1)
				{
					input.nextLine();
					break;
				}
				if(response == 2)
				{
					System.out.println("Responce excepted exiting application");
					appStatus = false;
					break;
				}
				System.out.println("Error. Please Enter a Valid Option");
				
			}
			
			
			
		}
		System.out.println("Your Program Has Exited");
		
		
	}
	
	
}
