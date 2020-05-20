package model;

import java.util.ArrayList;

public class Jukebox 
{
	
	private int numberOfAlbums;
	private ArrayList <Album> albums;
	private ArrayList <Song> hits;
	
	/**
	 * Constructor Method used to instantiate an object of the class Jukebox.
	 * <b>pre: </b>Scanner and Region class' has been imported<b>
	 * <b>post: </b>An object of type Interpreter will be initialized<b>
	 * @param pName is a string. <br>
	 * @param pSurname is a string. <br>
	 * @param pAge is an int. <br>
	 * @param pRegion is a Region. <br>
	 */
	public Jukebox()
	{
		numberOfAlbums = 0;
		this.albums = new ArrayList<>();
		this.hits = new ArrayList<>();
		
	}
	
	/**
	 * Method used to return hits ArrayList attribute.
	 * <b>pre: </b>hits has been initialized<b>
	 * <b>post: </b>hits will be returned.<b>
	 * @return An arrayList containing the songs in the hits ArrayList will be returned.
	 */
	public ArrayList<Song> getHits() 
	{
		return hits;
	}

	/**
	 * Method used to return getNumberOfAlbums attribute.
	 * <b>pre: </b>NumberOfAlbums has been initialized<b>
	 * <b>post: </b>An int will be returned.<b>
	 * @return An int containing the NumberOfAlbums in the album will be returned.
	 */
	public int getNumberOfAlbums()
	{
		return numberOfAlbums;
	}
	
	/**
	 * Method used to add an object of the class Album.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type album will be initialized<b>
	 * @param pName is a string that does not already exist in the Jukebox. pName!=null <br>
	 * @param pGenre is a Genre that does already exist in the Genre enum. <br>
	 * @param pPrice is a double. <br>
	 * @param pInterpreter is an Interpreter. <br>
	 * @return A boolean value based on the truthfulness of the addition to the Arraylist albums.
	 */
	public boolean addAlbum(String pName, Genre pGenre, double pPrice, Interpreter pInterpreter)
	{
		boolean response = false;
		
		Album existingAlbum = searchAlbum(pName);
		if(existingAlbum == null)
		{
				albums.add(new Album(pName, pGenre, pPrice, pInterpreter));
				response = true;
				numberOfAlbums++;
		}
		
		return response;
	}
	
	/**
	 * Method used to search for an object of the class Album.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type album will be found<b>
	 * @param pNameAlbum is a string. <br>
	 * @return An object of type Album found or null.
	 */
	public Album searchAlbum(String pNameAlbum)
	{
		Album response = null;
		
		for(int i = 0; i < albums.size(); i++)
		{
			if(albums.get(i).getName().equalsIgnoreCase(pNameAlbum))
			{
				response = albums.get(i);
			}
		}	
		
		return response;
	}
	
	
	/**
	 * Method used to add an object of the class Song.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be initialized<b>
	 * @param pName is a string that does not already exist in the Jukebox. pName!=null <br>
	 * @param pGenre is a Genre that does already exist in the Genre enum. <br>
	 * @param pDuration is an int. <br>
	 * @param pNameAlbum is a string. <br>
	 * @return A boolean value based on the truthfulness of the addition to the Arraylist songs within the album object.
	 */
	public boolean addSong(String pName, int pDuration, String pNameAlbum)
	{
		boolean response = false;
		
		Album album = searchAlbum(pNameAlbum);
		
		Song song = searchSong(pName, pNameAlbum);
		
		if(album != null && song == null)
		{
			Song newSong = new Song(pName, pDuration);
			response = album.addSong(newSong);
		}
		
		
		return response;
	}
	
	/**
	 * Method used to search for an object of the class Song.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be found<b>
	 * @param pNameAlbum is a string. <br>
	 * @param pName is a string. <br>
	 * @return An object of type Song found or null.
	 */
	public Song searchSong(String pName, String pNameAlbum)
	{
		Song result = null;
		Album searched = searchAlbum(pNameAlbum);
		
		if(searched != null)
		{
			for(int i = 0; i < searched.getSongs().size(); i++)
			{
				if(searched.getSongs().get(i).getName().equalsIgnoreCase(pName))
				{
					result = searched.getSongs().get(i);
				}
			}
		}
		
		
		return result;
	}
	
	/**
	 * Method used to search for an object of the class Album that is the most expensive.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type album will be found<b>
	 * @return An object of type Album found or null.
	 */
	public Album getMostExpensiveAlbum()
	{
		Album mostExpensiveAlbum = null;
		double maxPrice = 0.0;
		
		for(int i = 0; i < albums.size(); i++)
		{
			if(albums.get(i).getPrice()>maxPrice)
			{
				mostExpensiveAlbum = albums.get(i);
				maxPrice = albums.get(i).getPrice();
			}
		}
		
		return mostExpensiveAlbum;
	}
	
	/**
	 * Method used to add an object of the class Song to the hits arrayList.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be initialized<b>
	 * @param pName is a string that does not already exist in the Jukebox. pName!=null <br>
	 * @param pNameAlbum is a string. <br>
	 * @return A boolean value based on the truthfulness of the addition to the Arraylist hits.
	 */
	public boolean addHitSong(String pName, String pNameAlbum)
	{
		boolean result = false;
		
		Song song = searchSong(pName, pNameAlbum);
		
		if(song != null)
		{
			this.hits.add(song);
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Method used to search for an object of the class Song in the ArrayList hits.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be found<b>
	 * @param pName is a string. <br>
	 * @return An object of type Song found or null.
	 */
	public Song searchHitSong(String pName)
	{
		Song result = null;
		
		for(int i = 0; i < hits.size(); i++)
		{
			if(hits.get(i).getName().equalsIgnoreCase(pName))
			{
				result = hits.get(i);
			}
		}
		
		return result;
	}
	
	/**
	 * Method used to remove an object of the class Album from the ArrayList albums.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type album will be removed<b>
	 * @param pNameAlbum is a string <br>
	 * @return A boolean value based on the truthfulness of the removal from the Arraylist albums.
	 */
	public boolean removeAlbum(String pNameAlbum)
	{
		boolean result = false;
		
		Album searched = searchAlbum(pNameAlbum);
		
		if(searched != null)
		{
			result = this.albums.remove(searched);
			numberOfAlbums--;
		}
		
		
		return result;
	}
	
	/**
	 * Method used to remove an object of the class Song from the ArrayList songs within an album object.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type song will be removed<b>
	 * @param pNameSong is a string <br>
	 * @param pNameAlbum is a string <br>
	 * @return A boolean value based on the truthfulness of the removal from the Arraylist songs within an album object.
	 */
	public boolean removeSong(String pNameSong, String pNameAlbum)
	{
		boolean result = false;
		
		Album searchedAlbum = searchAlbum(pNameAlbum);
		Song searchedSong = searchSong(pNameSong, pNameAlbum);
		
		if(searchedAlbum != null && searchedSong != null)
		{
			result = searchedAlbum.getSongs().remove(searchedSong);
		}
		
		
		return result;
	}
	
	/**
	 * Method used to remove an object of the class Song from the ArrayList hits.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type song will be removed<b>
	 * @param pNameSong is a string <br>
	 * @return A boolean value based on the truthfulness of the removal from the Arraylist hits.
	 */
	public boolean removeHit(String pNameSong)
	{
		boolean result = false;
		
		Song searchedSong = searchHitSong(pNameSong);
		
		if(searchedSong != null)
		{
			result = this.hits.remove(searchedSong);
		}
		
		
		return result;
	}
	
	/**
	 * Method used to search for an object of the class Album that is the least expensive.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type album will be found<b>
	 * @return An object of type Album found or null.
	 */
	public Album getLeastExpensiveAlbum()
	{
		Album leastExpensiveAlbum = null;
		double minPrice = 0.0;
		
		for(int i = 0; i < albums.size(); i++)
		{
			if(albums.get(i)!=null)
			{
				leastExpensiveAlbum = albums.get(i);
				minPrice = albums.get(i).getPrice();
				break;
			}
		}
		
		for(int i = 0; i < albums.size(); i++)
		{
			if(albums.get(i).getPrice()<minPrice)
			{
				leastExpensiveAlbum = albums.get(i);
				minPrice = albums.get(i).getPrice();
			}
		}
		
		return leastExpensiveAlbum;
	}
	
	/**
	 * Method used to search for an object of the class Song in the ArrayList albums that is the longest in duration.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be found<b>
	 * @param pNameAlbum is a string. <br>
	 * @return An object of type Song found or null.
	 */
	public Song longestSong(String pNameAlbum)
	{
		Song result = null;
		
		Album searched = searchAlbum(pNameAlbum);
		int max = 0;
		if(searched != null)
		{
			for(int i =0; i < searched.getSongs().size(); i++)
			{
				if(searched.getSongs().get(i).getDuration()>max)
				{
					result = searched.getSongs().get(i);
					max = searched.getSongs().get(i).getDuration();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Method used to search for an object of the class Song in the ArrayList albums that is the shortest in duration.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be found<b>
	 * @param pNameAlbum is a string. <br>
	 * @return An object of type Song found or null.
	 */
	public Song shortestSong(String pNameAlbum)
	{
		Song result = null;
		
		Album searched = searchAlbum(pNameAlbum);
		int max = 0;
		if(searched != null)
		{
			for(int i =0; i < searched.getSongs().size(); i++)
			{
				if(searched.getSongs().get(i) != null)
				{
					result = searched.getSongs().get(i);
					max = searched.getSongs().get(i).getDuration();
					break;
				}
			}
			
			for(int i =0; i < searched.getSongs().size(); i++)
			{
				if(searched.getSongs().get(i).getDuration()<max)
				{
					result = searched.getSongs().get(i);
					max = searched.getSongs().get(i).getDuration();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Method used to search for an object of the class Song in the ArrayList hits that is the longest.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be found<b>
	 * @return An object of type Song found or null.
	 */
	public Song longestHit()
	{
		Song result = null;
	
		int max = 0;

			
			for(int i =0; i < hits.size(); i++)
			{
				if(hits.get(i) != null && hits.get(i).getDuration()>max)
				{
					result = hits.get(i);
					max = hits.get(i).getDuration();
				}
			}
		
		return result;
	}
	
	/**
	 * Method used to search for an object of the class Song in the ArrayList hits that is the shortest.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An object of type Song will be found<b>
	 * @return An object of type Song found or null.
	 */
	public Song shortestHit()
	{
		Song result = null;
	
		int min = 0;
			
		for(int i =0; i < hits.size(); i++)
		{
			if(hits.get(i) != null)
			{
				result = hits.get(i);
				min = hits.get(i).getDuration();
				break;
			}
		}
			
			for(int i =0; i < hits.size(); i++)
			{
				if(hits.get(i) != null && hits.get(i).getDuration()<min)
				{
					result = hits.get(i);
					min = hits.get(i).getDuration();
				}
			}
		
		return result;
	}
	
	/**
	 * Method used to get the number of objects in the ArrayList hits.
	 * <b>pre: </b>Genre and ArrayList class' have been imported<b>
	 * <b>post: </b>An int of the number of Songs in hits will be returned<b>
	 * @return An int of the number of Songs in hits will be returned or 0.
	 */
	public int getNumberHits()
	{
		int result = 0;
		for(int i = 0; i < hits.size(); i++)
		{
			if(hits.get(i) != null)
			{
				result++;
			}
		}
		return result;
	}
	
	
}
