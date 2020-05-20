package model;
import java.util.*;


public class State 
{
	private String name;
	private double area;
	private int population;
	private int numberOfCities;
	private ArrayList<City> cities;
	
	public double getArea() {
		return area;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public State(String pName, double pArea)
	{
		this.name = pName;
		this.area = pArea;
		this.cities = new ArrayList<City>();
	}

	public String getName() 
	{
		return name;
	}

	public int getNumberOfCities() 
	{
		int count = 0;
		for(int i = 0; i <cities.size(); i++)
		{
			if(cities.get(i) != null)
			{
				count++;
			}
		}
		this.numberOfCities = count;
		return numberOfCities;
	}
	
	public int getPopulation() 
	{
		int pop = 0;
		for(int i = 0; i <cities.size(); i++)
		{
			if(cities.get(i) != null)
			{
				pop = pop + cities.get(i).getPopulation();
			}
		}
		this.population = pop;
		return population;
	}
	
	public City findMostPopulationCityState()
	{
		City result = null;
		int maxPopulation = 0;
		
		for(int i = 0; i <cities.size(); i++)
		{
			if(cities.get(i) != null && cities.get(i).getPopulation() >  maxPopulation)
			{
				population = cities.get(i).getPopulation();
				result = cities.get(i);
			}
		}
		
		
		return result;
	}
	
	public boolean addCityToState(String pNameCity, int pPopulation)
	{
		boolean result = false;
		
		cities.add(new City(pNameCity, pPopulation));
		result = true;
		
		
		
		return result;
	}
	
	
}
