package model;
import java.util.*;


public class Laboratory 
{
	private ArrayList<Researcher> researchers;
	private String name;
	private int numberOfResearchers;
	
	
	/**
	 * Constructor Method used to initialize attributes to default values, when object of this class is instantiated.
	 * <b>pre: </b>NA<b>
	 * <b>post: </b>properties have been initialized<b>
	 */
	public Laboratory(String pNameLaboratory)
	{
		this.name = pNameLaboratory;
		this.numberOfResearchers =0;
		this.researchers = new ArrayList<Researcher>();
	}
	/**
	 * Method used to return name.
	 * <b>pre: </b> object has been initialized<b>
	 * <b>post: </b>name will be returned<b>
	 * @return String if the variable was successfully initialized.
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * Method used to return number of researchers.
	 * <b>pre: </b> list has been initialized<b>
	 * <b>post: </b>int will be returned<b>
	 * @return int if the variable was successfully initialized.
	 */
	public int getNumberOfResearchers() 
	{
		numberOfResearchers();
		return numberOfResearchers;
	}
	/**
	 * Method used to return arraylist.
	 * <b>pre: </b> list has been initialized<b>
	 * <b>post: </b>list will be returned<b>
	 * @return list if the list was successfully initialized.
	 */
	public ArrayList<Researcher> getResearchers() 
	{
		return researchers;
	}
	/**
	 * Method used to find an object of type Researcher in the ArrayList based on the youngest age.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A Researcher will be found in the Lab.<b>
	 * @return Researcher if the object was successfully found in the list. NULL or Exception if not otherwise true.
	 */
	public Researcher findYoungestResearcherInThisLab()
	{
		Researcher result = null;
		int min = 0;
		
		for(int i = 0; i < this.researchers.size(); i++)
		{
			if(this.researchers.get(i) != null)
			{
				result = this.researchers.get(i);
				min = this.researchers.get(i).getAge();
				break;
			}
		}
		
		for(int i = 0; i < this.researchers.size(); i++)
		{
			if(this.researchers.get(i) != null && this.researchers.get(i).getAge()<min)
			{
				result = this.researchers.get(i);
				min = this.researchers.get(i).getAge();
			}
		}
		
		return result;
	}
	/**
	 * Method used to find the average age of the lab.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A double will be returned<b>
	 * @return double average if the objects were successfully found in the list and calculated. 0.0 if not otherwise true.
	 */
	public double findAverageAgeInThisLab()
	{
		double result = 0.0;
		numberOfResearchers();
		
		for(int i = 0; i < this.researchers.size(); i++)
		{
			if(this.researchers.get(i) != null)
			{
				result = result + this.researchers.get(i).getAge();
			}
		}
		if(this.numberOfResearchers == 0)
		{
			return 0.0;
		}
		
		return result/this.numberOfResearchers;
	}
	/**
	 * Method used to find the number of researchers in the list.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>attribute will be set to value of the count<b>
	 */
	public void numberOfResearchers()
	{
		int count = 0;
		for(int i = 0; i < this.researchers.size(); i++)
		{
			if(this.researchers.get(i) != null)
			{
				count++;
			}
		}
		this.numberOfResearchers = count;
	}
	
	
	
	
}
