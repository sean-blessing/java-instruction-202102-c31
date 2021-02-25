package ui;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import util.Console;

import business.Movie;

public class BmdbConsoleApp {
	private static final String MOVIE_FILE_NAME = "movies.txt";

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Bootcamp Movie Database!!!");
		String command = "";
		
		while (!command.equalsIgnoreCase("exit")) {
			System.out.println("MENU:");
			System.out.println("show - show all movies");
			System.out.println("add  - add a movie");
			System.out.println("exit - exit app");
			String[] validEntries = {"show","add","exit"};
			command = Console.getChoiceString("Command: ", validEntries);
			switch (command) {
			case "show":
				// read all records from file and print to screen
				List<Movie> movies = readMovieRecords();
				System.out.println("Movie List:");
				System.out.println("============");
				if (movies.size() != 0) {
					for (Movie m: movies) {
						System.out.println(m);
					}
				}
				else {
					System.out.println("Movie file empty.");
				}
				break;
			case "add":
				// prompt user for all fields for a new movie
				System.out.println("Add a Movie:");
				System.out.println("============");
				int id = Console.getInt("ID: ", 0, Integer.MAX_VALUE);
				String title = Console.getRequiredString("Title: ");
				String rating = Console.getRequiredString("Rating: ");
				int year = Console.getInt("Year: ", 0, Integer.MAX_VALUE);
				String director = Console.getRequiredString("Director: ");
				// create instance of movie
				Movie m = new Movie(id, title, rating, year, director);
				// call writeMovieRecord
				writeMovieRecord(m);
				//TODO add exception handling
				break;
			case "exit":
				break;
			}
		}
		System.out.println("Bye");

	}
	
	//p. 467
	private static void writeMovieRecord(Movie m) throws IOException {
		Path moviesPath = Paths.get(MOVIE_FILE_NAME);
		File moviesFile = moviesPath.toFile();
		
		PrintWriter out = new PrintWriter(
						  new BufferedWriter(
						  new FileWriter(moviesFile)));
		out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getRating()+"\t"+m.getYear()
					+"\t"+m.getDirector());
		out.close();
		
	}
	
	// read movie records and return a list of movies
	private static List<Movie> readMovieRecords() throws IOException {
		List<Movie> movies = new ArrayList<>();
		//p.477
		BufferedReader in = new BufferedReader(
							new FileReader(MOVIE_FILE_NAME));
		String line = in.readLine();
		while (line != null) {
			String[] fields = line.split("\t");
			// after split we should have 5 fields per line
			String idStr = fields[0];
			int id = Integer.parseInt(idStr);
			String title = fields[1];
			String rating = fields[2];
			String yearStr = fields[3];
			int year = Integer.parseInt(yearStr);
			String director = fields[4];
			
			Movie m = new Movie(id, title, rating, year, director);
			movies.add(m);
			
			//get the next line in the file
			line = in.readLine();
		}
		in.close();
		return movies;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
