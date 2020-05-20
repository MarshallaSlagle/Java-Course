package model;

public class Interpreter 
{

	private String name;
	private String surname;
	private int age;
	private Region region;
	
	/**
	 * Constructor Method used to instantiate an object of the class Interpreter.
	 * <b>pre: </b>SRegion class has been imported<b>
	 * <b>post: </b>An object of type Interpreter will be initialized<b>
	 * @param pName is a string. <br>
	 * @param pSurname is a string. <br>
	 * @param pAge is an int. <br>
	 * @param pRegion is a Region. <br>
	 */
	public Interpreter(String pName, String pSurname, int pAge, Region pRegion)
	{
		name = pName;
		surname = pSurname;
		age = pAge;
		region = pRegion;
	}

	/**
	 * Method used to return getName attribute.
	 * <b>pre: </b>name has been initialized<b>
	 * <b>post: </b>A string will be returned.<b>
	 * @return A string containing the name of the Interpreter will be returned.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Method used to return getRegion attribute.
	 * <b>pre: </b>Region has been initialized<b>
	 * <b>post: </b>A Region will be returned.<b>
	 * @return A Region containing the region of the Interpreter will be returned.
	 */
	public Region getRegion() 
	{
		return region;
	}

	/**
	 * Method used to return getSurname attribute.
	 * <b>pre: </b>Surname has been initialized<b>
	 * <b>post: </b>A string will be returned.<b>
	 * @return A string containing the Surname of the Interpreter will be returned.
	 */
	public String getSurname() 
	{
		return surname;
	}

	/**
	 * Method used to return getAge attribute.
	 * <b>pre: </b>age has been initialized<b>
	 * <b>post: </b>An int will be returned.<b>
	 * @return An int containing the age of the Interpreter will be returned.
	 */
	public int getAge() 
	{
		return age;
	}
	
	
	
}
