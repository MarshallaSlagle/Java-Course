package model;

public class City 
{
	private String name;
	private int population;
	
	
	public City(String pNameCity, int pPopulation)
	{
		this.name = pNameCity;
		this.population = pPopulation;
	}


	public String getName() {
		return name;
	}


	public int getPopulation() {
		return population;
	}
	
	
	
	
}
