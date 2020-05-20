package model;

import java.util.ArrayList;

public class Album 
{
	private String name;
	private Genre genre;
	private double price;
	private int numberOfSongs;
	
	private Interpreter interpreter;
	private ArrayList <Song> songs;
	
	
	
	/**
	 * Constructor Method used to instantiate an object of the class Album.
	 * <b>pre: </b>Genre and ArrayList class' has been imported<b>
	 * <b>post: </b>An object of type album will be initialized<b>
	 * @param pName is a string that does not already exist in the Jukebox. pName!=null <br>
	 * @param pGenre is a Genre that does already exist in the Genre enum. <br>
	 * @param pPrice is a double. <br>
	 * @param pInterpreter is an Interpreter. <br>
	 */
	public Album(String pName, Genre pGenre, double pPrice, Interpreter pInterpreter)
	{
		name = pName;
		genre = pGenre;
		price = pPrice;
		interpreter = pInterpreter;
		numberOfSongs = 0;
		songs = new ArrayList <>();
	}
	
	/**
	 * Method used to add Song to song ArrayList.
	 * <b>pre: </b>ArrayList has been initialized<b>
	 * <b>post: </b>A boolean value will be returned.<b>
	 * @param pSong is an object of type Song that does not already exist in the Jukebox. <br>
	 * @return A boolean value based on the truthfulness of the addition to the Arraylist songs.
	 */
	public boolean addSong(Song pSong)
	{
		boolean response = false;
		
		
		if(pSong != null)
		{
			songs.add(pSong);
			this.numberOfSongs++;
			response = true;
		}
		
		
		return response;
	}
	
	/**
	 * Method used to search for a Song in the ArrayList.
	 * <b>pre: </b>ArrayList has been initialized<b>
	 * <b>post: </b>A song object will be returned.<b>
	 * @param pName is a string that does already exist in the Jukebox. <br>
	 * @return A song object of type Song containing the located song or null.
	 */
	public Song searchSong(String pName)
	{
		Song response = null;
		
		for(int i = 0; i < this.songs.size(); i++)
		{
			if(songs.get(i).getName().equalsIgnoreCase(pName));
			{
				response = songs.get(i);
				break;
			}
		}
		
		
		return response;
	}
	

	/**
	 * Method used to return getName attribute.
	 * <b>pre: </b>name has been initialized<b>
	 * <b>post: </b>A string will be returned.<b>
	 * @return A string containing the name of the album will be returned.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Method used to return getGenre attribute.
	 * <b>pre: </b>Genre has been initialized<b>
	 * <b>post: </b>A Genre will be returned.<b>
	 * @return A Genre containing the genre of the album will be returned.
	 */
	public Genre getGenre() 
	{
		return genre;
	}

	/**
	 * Method used to return getPrice attribute.
	 * <b>pre: </b>Price has been initialized<b>
	 * <b>post: </b>A double will be returned.<b>
	 * @return A double containing the price of the album will be returned.
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * Method used to return getNumberOfSongs attribute.
	 * <b>pre: </b>NumberOfSongs has been initialized<b>
	 * <b>post: </b>An int will be returned.<b>
	 * @return An int containing the NumberOfSongs in the album will be returned.
	 */
	public int getNumberOfSongs() 
	{
		return numberOfSongs;
	}

	/**
	 * Method used to return Interpreter attribute.
	 * <b>pre: </b>Interpreter has been initialized<b>
	 * <b>post: </b>An Interpreter will be returned.<b>
	 * @return An Interpreter containing the interpreter of the album will be returned.
	 */
	public Interpreter getInterpreter() 
	{
		return interpreter;
	}
	
	/**
	 * Method used to return songs ArrayList attribute.
	 * <b>pre: </b>songs has been initialized<b>
	 * <b>post: </b>Songs will be returned.<b>
	 * @return An arrayList containing the songs in the album will be returned.
	 */
	public ArrayList<Song> getSongs() 
	{
		return songs;
	}


	
	
	
}
