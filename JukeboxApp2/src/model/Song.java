package model;

import java.util.ArrayList;

public class Song 
{
	private String name;
	private int duration;

	
	
	/**
	 * Constructor Method used to instantiate an object of the class Song.
	 * <b>pre: </b>ArrayList has been imported<b>
	 * <b>post: </b>An object of type Song will be initialized<b>
	 * @param pName is a string. <br>
	 * @param pDuration is an int. <br>
	 */
	public Song(String pName, int pDuration)
	{
		name = pName;
		duration = pDuration;
		
	}

	 
	/**
	 * Method used to return getName attribute.
	 * <b>pre: </b>name has been initialized<b>
	 * <b>post: </b>A string will be returned.<b>
	 * @return A string containing the name of the Song will be returned.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Method used to return getDuration attribute.
	 * <b>pre: </b>duration has been initialized<b>
	 * <b>post: </b>An int will be returned.<b>
	 * @return An int containing the duration of the song will be returned.
	 */
	public int getDuration() 
	{
		return duration;
	}
	
	
	
	
}
