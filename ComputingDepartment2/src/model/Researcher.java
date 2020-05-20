package model;


public class Researcher 
{
	private String name;
	private String surName;
	private int age;
	
	
	/**
	 * Constructor Method used to initialize attributes to default values, when object of this class is instantiated.
	 * <b>pre: </b>NA<b>
	 * <b>post: </b>properties have been initialized<b>
	 */
	public Researcher(String pName, String pSurName, int pAge)
	{
		this.name = pName;
		this.surName = pSurName;
		this.age = pAge;
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
	 * Method used to return Surname.
	 * <b>pre: </b> object has been initialized<b>
	 * <b>post: </b>Surname will be returned<b>
	 * @return String if the variable was successfully initialized.
	 */
	public String getSurName()
	{
		return surName;
	}
	/**
	 * Method used to return age.
	 * <b>pre: </b> object has been initialized<b>
	 * <b>post: </b>age will be returned<b>
	 * @return int if the variable was successfully initialized.
	 */
	public int getAge() 
	{
		return age;
	}
	

}
