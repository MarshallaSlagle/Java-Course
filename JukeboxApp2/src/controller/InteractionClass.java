package controller;

import model.Album;
import model.Genre;
import model.Interpreter;
import model.Jukebox;
import model.Region;
import model.Song;

import java.util.Scanner;

public class InteractionClass 
{
	/**
	 * Method used to select Genre option from enum.
	 * <b>pre: </b>Scanner and genre class' has been imported<b>
	 * <b>post: </b>A Genre will be returned<b>
	 * @return Genre value from enum, based on user input of array element.
	 */
	public static Genre chooseGenre()
	{
		Genre response = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Choose a Genre");
		
		for(int i = 0; i < Genre.values().length; i++)
		{
			System.out.println("Genre " + (i+1) + ": " + Genre.values()[i]);
		}
		while(true)
		{
			int choice = (input.nextInt()-1);
			if(choice >= 0 && choice <Genre.values().length)
			{
				response = Genre.values()[choice];
				break;
			}
			else
			{
				System.out.println("Please Enter a Valid Genre Option");
			}
		}
		
		return response;
	}
	/**
	 * Method used to select Region option from enum.
	 * <b>pre: </b>Scanner and Region class' has been imported<b>
	 * <b>post: </b>A Region will be returned<b>
	 * @return Region value from enum, based on user input of array element.
	 */
	public static Region chooseRegion()
	{
		Region response = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Choose a Region");
		
		for(int i = 0; i < Region.values().length; i++)
		{
			System.out.println("Region " + (i+1) + ": " + Region.values()[i]);
		}
		while(true)
		{
			int choice = (input.nextInt()-1);
			if(choice >= 0 && choice <Region.values().length)
			{
				response = Region.values()[choice];
				break;
			}
			else
			{
				System.out.println("Please Enter a Valid Region Option");
			}
		}
		
		return response;
	}
	

	public static void main(String[] args)
	{
		
		Jukebox mode1 = new Jukebox();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to JukeboxApp!");
		
		
		
		boolean continueExecution = true;
		while(continueExecution == true)
		{
		
		
		System.out.println("Please select one of the following actions:");
		System.out.println("Add a new album [1]");
		System.out.println("Add a new song to an existing album [2]");
		System.out.println("Search for an existing album [3]");
		System.out.println("Retrieve the most expensive album [4]");
		System.out.println("Retrieve the number of existing albums [5]");
		System.out.println("Mark an existing song as a Jukebox Hit [6]");
		System.out.println("Search for an existing Song [7]");
		System.out.println("Search for a hit Song [8]");
		System.out.println("Remove an album [9]");
		System.out.println("Remove a song [10]");
		System.out.println("Remove a hit [11]");
		System.out.println("Retrieve the least expensive album [12]");
		System.out.println("Retrieve the longest song in album [13]");
		System.out.println("Retrieve the shortest song in album [14]");
		System.out.println("Retrieve the longest hit [15]");
		System.out.println("Retrieve the shortest hit [16]");
		System.out.println("Retrieve the number of existing hits [17]");
		
		String txtResponse = input.nextLine();
		int response = Integer.parseInt(txtResponse);
		
		if(response == 1) //Add a new album
		{
			System.out.println("Let's create the interpreter first.");
			System.out.println("What is the name of the interpreter?");
			String nameInterpreter = input.nextLine();
			System.out.println("What is the surename of the interpreter?");
			String surnameInterpreter = input.nextLine();
			System.out.println("What is the age of the interpreter?");
			String txtAge = input.nextLine();
			int ageInterpreter = Integer.parseInt(txtAge);
			System.out.println("What is the Region of the interpreter?");
			Region regionInterpreter = chooseRegion();
			
			Interpreter interpreter = new Interpreter(nameInterpreter, surnameInterpreter, ageInterpreter, regionInterpreter);
				
			System.out.println("Perfect! Now, let's create the Album.");
			System.out.println("What is the name of the album?");
			String nameAlbum = input.nextLine();
			System.out.println("What is the genre of the album?");
			Genre genreAlbum = chooseGenre();
			System.out.println("What is the price of the album?");
			String txtPrice = input.nextLine();
			double priceAlbum = Double.parseDouble(txtPrice);
				
			boolean methodAnswer  = mode1.addAlbum(nameAlbum, genreAlbum, priceAlbum, interpreter);
			
			if(methodAnswer == true)
			{
				System.out.println("Amazing! Your album was successfully added to the Jukebox! :-)");
			}
			else
			{
				System.out.println("I am sorry:-( ...The album was not added to the Jukebox.");
			}
			
			
			
		}
		else if(response ==2) //Add a new song to an existing album
		{
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			System.out.println("Please input the name of the Song:");
			String nameSong = input.nextLine();
			
			System.out.println("Please input the duration of the Song:");
			String txtDuration = input.nextLine();
			int durationSong = Integer.parseInt(txtDuration);
			
			boolean methodResponse = mode1.addSong(nameSong, durationSong, nameAlbum);
			if(methodResponse == true)
			{
				System.out.println("Amazing! Your song was succesfully added to the Album!  :-)");
			}
			else
			{
				System.out.println("I am sorry:-( ...The Song was not added to the Album.");
			}
			
			
		
		}
		else if(response ==3) //Search for existing album
		{
			
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			Album searchedAlbum = mode1.searchAlbum(nameAlbum);
			
			if(searchedAlbum == null)
			{
				System.out.println("We are sorry, but there is not an album with the name: " + nameAlbum);
			}
			else
			{
				System.out.println("The album named " + nameAlbum + " has the following details:");
				System.out.println("\t a. Genre: " + searchedAlbum.getGenre());
				System.out.println("\t b. Price: " + searchedAlbum.getPrice());
				System.out.println("\t c. Number of Songs: " + searchedAlbum.getNumberOfSongs());
				System.out.println("\t d. Interpreter: " + searchedAlbum.getInterpreter().getName());
				System.out.println("\t e. Region: " + searchedAlbum.getInterpreter().getRegion());
			}
			
		
			
		}
		else if(response ==4) //Most expensive album
		{
			
			
			Album mostExpensive = mode1.getMostExpensiveAlbum();
			if(mostExpensive == null)
			{
				System.out.println("There are no albums in the jukebox yet :-(");
			}
			else
			{
				System.out.println("The most expensive album is named " + mostExpensive.getName() + " and has the following details:");
				System.out.println("\t a. Genre: " + mostExpensive.getGenre());
				System.out.println("\t b. Price: " + mostExpensive.getPrice());
				System.out.println("\t c. Number of Songs: " + mostExpensive.getNumberOfSongs());
				System.out.println("\t d. Interpreter: " + mostExpensive.getInterpreter().getName());
			}
			
			
		}
		else if(response == 5) //Number of existing albums
		{
			
			int numberOfAlbums = mode1.getNumberOfAlbums();
			System.out.println("The number of existing albums is: "+ numberOfAlbums);
			
			
		}
		else if(response == 6) //add hit
		{
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			System.out.println("Please input the name of the Song:");
			String nameSong = input.nextLine();
			
			boolean result = mode1.addHitSong(nameSong, nameAlbum);
			if(result == true)
			{
				System.out.println("Song Added as a hit successfully :-)");
			}
			else
			{
				System.out.println("Song was not added as a hit :-(");
			}
			
			
		}
		else if(response == 7) //search song
		{
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			System.out.println("Please input the name of the Song:");
			String nameSong = input.nextLine();
			
			Song result = mode1.searchSong(nameSong, nameAlbum);
			if(result != null)
			{
				Album searchedAlbum = mode1.searchAlbum(nameAlbum);
				System.out.println("Song was found successfully :-)");
				System.out.println("The song named " + nameSong + " has the following details:");
				System.out.println("\t a. Duration: " + result.getDuration());
				System.out.println("The song is located in the album named " + nameAlbum + " which has the following details:");
				System.out.println("\t a. Genre: " + searchedAlbum.getGenre());
				System.out.println("\t b. Price: " + searchedAlbum.getPrice());
				System.out.println("\t c. Number of Songs: " + searchedAlbum.getNumberOfSongs());
				System.out.println("\t d. Interpreter: " + searchedAlbum.getInterpreter().getName());
				System.out.println("\t e. Region: " + searchedAlbum.getInterpreter().getRegion());
				
				
			}
			else
			{
				System.out.println("Song was not found :-(");
			}
			
			
		}
		else if(response == 8) //search hit
		{
			
			System.out.println("Please input the name of the Song:");
			String nameSong = input.nextLine();
			
			Song result = mode1.searchHitSong(nameSong);
			if(result != null)
			{
				System.out.println("Song was found successfully :-)");
				System.out.println("The song named " + nameSong + " has the following details:");
				System.out.println("\t a. Duration: " + result.getDuration());
				
			}
			else
			{
				System.out.println("Song was not found :-(");
			}
			
			
		}
		else if(response == 9) //remove album
		{
			
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			boolean result = mode1.removeAlbum(nameAlbum);
			
			if(result == true)
			{
				System.out.println("The Album was removed :-)");
			}
			else
			{
				System.out.println("The Album was not removed :-(");
			}
			
		}
		else if(response == 10) //remove song
		{
			
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			System.out.println("Please input the name of the Song:");
			String nameSong = input.nextLine();
			
			boolean result = mode1.removeSong(nameSong, nameAlbum);
			
			if(result == true)
			{
				System.out.println("The Song was removed :-)");
			}
			else
			{
				System.out.println("The Song was not removed :-(");
			}
			
		}
		else if(response == 11) //remove hit
		{
			
			System.out.println("Please input the name of the Song:");
			String nameSong = input.nextLine();
			
			boolean result = mode1.removeHit(nameSong);
			
			if(result == true)
			{
				System.out.println("The Hit was removed :-)");
			}
			else
			{
				System.out.println("The Hit was not removed :-(");
			}
			
		}
		else if(response ==12) //least expensive album
		{
			
			
			Album leastExpensive = mode1.getLeastExpensiveAlbum();
			if(leastExpensive == null)
			{
				System.out.println("There are no albums in the jukebox yet :-(");
			}
			else
			{
				System.out.println("The least expensive album is named " + leastExpensive.getName() + " and has the following details:");
				System.out.println("\t a. Genre: " + leastExpensive.getGenre());
				System.out.println("\t b. Price: " + leastExpensive.getPrice());
				System.out.println("\t c. Number of Songs: " + leastExpensive.getNumberOfSongs());
				System.out.println("\t d. Interpreter: " + leastExpensive.getInterpreter().getName());
			}
			
			
		}
		else if(response == 13) //longest song in album
		{
			
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			Song result = mode1.longestSong(nameAlbum);
			
			if(result != null)
			{
				System.out.println("Song was found successfully :-)");
				System.out.println("The song named " + result.getName() + " has the following details:");
				System.out.println("\t a. Duration: " + result.getDuration());
			}
			else
			{
				System.out.println("A Song was not found :-(");
			}
			
		}
		else if(response == 14) //shortest song in album
		{
			
			System.out.println("Please input the name of the album:");
			String nameAlbum = input.nextLine();
			
			Song result = mode1.shortestSong(nameAlbum);
			
			if(result != null)
			{
				System.out.println("Song was found successfully :-)");
				System.out.println("The song named " + result.getName() + " has the following details:");
				System.out.println("\t a. Duration: " + result.getDuration());
			}
			else
			{
				System.out.println("A Song was not found :-(");
			}
			
		}
		else if(response == 15) //longest hit
		{
				
			Song result = mode1.longestHit();
			
			if(result != null)
			{
				System.out.println("Hit was found successfully :-)");
				System.out.println("The Hit named " + result.getName() + " has the following details:");
				System.out.println("\t a. Duration: " + result.getDuration());
			}
			else
			{
				System.out.println("A Song was not found :-(");
			}
			
		}
		else if(response == 16) //shortest hit
		{
			Song result = mode1.shortestHit();
			if(result != null)
			{
				System.out.println("Hit was found successfully :-)");
				System.out.println("The Hit named " + result.getName() + " has the following details:");
				System.out.println("\t a. Duration: " + result.getDuration());
			}
			else
			{
				System.out.println("A Song was not found :-(");
			}
		}
		else if(response == 17) //Number of existing hits
		{
			int numberOfHits = mode1.getNumberHits();
			System.out.println("The number of existing Hits is: "+ numberOfHits);
		}
		
		
		
		System.out.println("Do you want to contine using the app? (Y/N)");
		String responseContinue = input.nextLine();
		
		if(responseContinue.equals("N"))
		{
			continueExecution = false;
		}
		
		
	}
		System.out.println("App Exited");
	}
	
	
	
}
