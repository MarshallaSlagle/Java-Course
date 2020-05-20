package model;


public class Department 
{
	public static final int NUMBER_LABORATORIES = 25;
	private Laboratory laboratory[];
	
	/**
	 * Constructor Method used to initialize attributes to default values, when object of this class is instantiated.
	 * <b>pre: </b>NA<b>
	 * <b>post: </b>properties have been initialized<b>
	 */
	public Department()
	{
		laboratory = new Laboratory[NUMBER_LABORATORIES];
	}
	/**
	 * Method used to retrieve the number of labs within the array.
	 * <b>pre: </b>Array is initialized<b>
	 * <b>post: </b>value returned<b>
	 * @return integer value of the number of lab objects within the array.
	 */
	public int getNumLabs()
	{
		int result = 0;
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null)
			{
				result++;
			}
		}
		
		return result;
	}
	/**
	 * Method used to add an object of type Laboratory to the Array.
	 * <b>pre: </b> Array has been initialized<b>
	 * <b>post: </b>A Lab will be added to the List.<b>
	 * @param pNameLaboratory is a string that does not already exist in the department. pNameLaboratory!=null <br>
	 * @return true if the object was successfully added to the list. False or Exception if not otherwise true.
	 */
	public boolean addNewLaboratory(String pNameLaboratory) throws Exception
	{
		boolean result = false;
		boolean added = false;
		
		if(pNameLaboratory == null || pNameLaboratory.isBlank())
		{
			throw new Exception("NULL or Blank Name");
		}
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null)
			{
				added = laboratory[i].getName().equalsIgnoreCase(pNameLaboratory);
				
			}
		}
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] == null && added == false)
			{
				laboratory[i] = new Laboratory(pNameLaboratory);
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Method used to add an object of type Researcher to the ArrayList.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A Researcher will be added to the Lab.<b>
	 * @param pNameLaboratory is a string that does not already exist in the department. pNameLaboratory!=null <br>
	 * @param pName is a string that does not already exist in the department. pName!=null <br>
	 * @param pSurName is a string that does not already exist in the department. pSurName!=null <br>
	 * @param pAge is a integer that does not already exist in the department. pAge!=null <br>
	 * @return true if the object was successfully added to the list. False or Exception if not otherwise true.
	 */
	public boolean addNewResearcher(String pNameLaboratory, String pName, String pSurName, int pAge) throws Exception
	{
		boolean result = false;
	
		if(pNameLaboratory == null || pNameLaboratory.isBlank() || pName == null || pName.isBlank() || pSurName == null || pSurName.isBlank())
		{
			throw new Exception("NULL or Blank Name");
		}
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null && laboratory[i].getName().equalsIgnoreCase(pNameLaboratory))
			{
				boolean added = false;
				for(int j = 0; j < laboratory[i].getResearchers().size(); j++)
				{
					
					if(laboratory[i].getResearchers().get(j).getName().equalsIgnoreCase(pName) && laboratory[i].getResearchers().get(j).getSurName().equalsIgnoreCase(pSurName))
					{
						added = true;
						break;
					}
				}
				
				if(added == false)
				{
					laboratory[i].getResearchers().add(new Researcher(pName, pSurName, pAge));
					result = true;
					break;
				}
			}
		}
		return result;
	}
	/**
	 * Method used to find an object of type Researcher in the ArrayList based on the youngest age.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A Researcher will be found in the Lab.<b>
	 * @return Researcher if the object was successfully found in the list. NULL or Exception if not otherwise true.
	 */
	public Researcher findYoungestResearcher() throws Exception
	{
		try 
		{
		Researcher result = null;
		int min = 0;
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null && laboratory[i].findYoungestResearcherInThisLab() != null)
			{
				result = laboratory[i].findYoungestResearcherInThisLab();
				min = result.getAge();
				break;
			}
		}
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null && laboratory[i].findYoungestResearcherInThisLab() != null && laboratory[i].findYoungestResearcherInThisLab().getAge() < min)
			{
				result = laboratory[i].findYoungestResearcherInThisLab();
				min = result.getAge();
				
			}
		}
		
		if(result == null)
		{
			throw new Exception("Not found or No Researcher");
		}
		
		return result;
		}
		catch(Exception e)
		{
			throw new Exception("Not found or No Researcher");
		}
	}
	/**
	 * Method used to find the average age of the dept.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A double will be returned<b>
	 * @return double average if the objects were successfully found in the list and calculated. 0.0 if not otherwise true.
	 */
	public double averageAgeDepartment()
	{
		double result = 0.0;
		int count = 0;
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null)
			{
				result = result + laboratory[i].findAverageAgeInThisLab();
				count++;
			}
		}
		if(count == 0)
		{
			return 0.0;
		}
		
		return result/count;
		
	}
	/**
	 * Method used to find the average age of the lab.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A double will be returned<b>
	 * @param pNameLaboratory is a string that does not already exist in the department. pNameLaboratory!=null <br>
	 * @return double average if the objects were successfully found in the list and calculated. 0.0 if not otherwise true.
	 */
	public double averageAgeLaboratory(String pNameLaboratory) throws Exception
	{
		double result = 0;
		if(pNameLaboratory == null || pNameLaboratory.isBlank())
		{
			throw new Exception("NULL or Blank Name");
		}
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null && laboratory[i].getName().equalsIgnoreCase(pNameLaboratory))
			{
				result = laboratory[i].findAverageAgeInThisLab();
				break;
			}
		}
		
		return result;
	}
	/**
	 * Method used to find the most populated lab.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>A lab will be returned<b>
	 * @param pNameLaboratory is a string that does not already exist in the department. pNameLaboratory!=null <br>
	 * @return Laboratory if the objects were successfully found in the list and calculated. NULL if not otherwise true.
	 */
	public Laboratory mostPopulatedLaboratory()
	{
		Laboratory result = null;
		int max = 0;
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null && laboratory[i].getNumberOfResearchers() > max)
			{
				result = laboratory[i];
				max = laboratory[i].getNumberOfResearchers();
			}
		}
		return result;
	}
	/**
	 * Method used to find the number of researchers older then a provided number.
	 * <b>pre: </b> Array and ArrayList has been initialized<b>
	 * <b>post: </b>An int will be returned<b>
	 * @param pAge is an int that does not already exist in the department.<br>
	 * @return int if the objects were successfully found in the list and calculated. 0 if not otherwise true.
	 */
	public int OlderResearcher(int pAge)
	{
		int result = 0;
		
		for(int i = 0; i < laboratory.length; i++)
		{
			if(laboratory[i] != null)
			{
				for(int j = 0; j < laboratory[i].getResearchers().size(); j++)
				{
					if(laboratory[i].getResearchers().get(j).getAge() > pAge)
					{
						result++;
					}
				}
			}
		}
		
		return result;
	}
	
	
	
}
