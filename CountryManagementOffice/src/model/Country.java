package model;

public class Country 
{
	public static final int Number_States = 50;
	private State states[];
	
	public Country()
	{
		this.states = new State[Number_States];
	}
	
	public boolean addState(String pName, double pArea)
	{
		boolean result = false;
		int availableStates = 0;
		for(int i = 0; i <states.length; i++)
		{
			if(states[i] == null)
			{
				availableStates++;
			}
		}
		
		for(int i = 0; i <states.length; i++)
		{
			if(states[i] == null && availableStates>0)
			{
				states[i] = new State(pName, pArea);
				result = true;
				break;
			}
		}
		
		
		return result;
	}
	
	public boolean addCity(String pNameState, String pNameCity, int pPopulation)
	{
		boolean result = false;

		for(int i = 0; i <states.length; i++)
		{
			if(states[i] != null && pNameState.equalsIgnoreCase(states[i].getName()))
			{
				states[i].addCityToState(pNameCity, pPopulation);
				result = true;
			}
		}
		
		
		
		return result;
	}
	

	public State findSmallestState()
	{
		State result = null;
		double area = 0;
		
		for(int i = 0; i <states.length; i++)
		{
			if(states[i] != null && states[i].getArea()  >  area)
			{
				result = states[i];
				area = states[i].getArea();
			}
		}
		
	
		
		return result;
	}
	
	public City findMostPopulatedCityCountry()
	{
		City result = null;
		int population = 0;
		
		for(int i = 0; i <states.length; i++)
		{
			if(states[i] != null)
			{
				for(int j = 0; j< states[i].getCities().size(); j++)
				{
					if(states[i].getCities().get(j) != null && states[i].getCities().get(j).getPopulation() > population)
					{
						result = states[i].getCities().get(j);
						population = states[i].getCities().get(j).getPopulation();
					}
				}
			}
		}
		
		
		return result;
	}
	
	public int findStatePopulation(String pName)
	{
		int result = 0;
		
		for(int i = 0; i <states.length; i++)
		{
			if(states[i] != null && pName.equalsIgnoreCase(states[i].getName()))
			{
				result = states[i].getPopulation();
			}
		}
		
		
		
		return result;
	}
	
	
	
}
