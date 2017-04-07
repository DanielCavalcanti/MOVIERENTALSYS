/**
 * 
 */
package dBClasses;

import java.util.ArrayList;

/**
 * The Actor class encapsulates the attributes and properties 
 * of an actor in a movie rental database
 * @author Lyrene Labor
 * @version April 2017
 */
public class Actor {
	
	

	private double actorid;
	private String name;
	private String gender;
	private double age;
	private ArrayList<Movie> movies;
	
	/**
	 * The Actor constructor initializes all attributes of an actor object
	 * @param actorid - int value id of the actor
	 * @param name - string value of the name of the actor
	 * @param gender - string value of the gender of the actor
	 * @param age - int value of the age of the actor
	 */
	public Actor(double actorid, String name, String gender, double age) {
		this.actorid = actorid;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.movies = new ArrayList<>();
	}
	
	/**
	 * getMovies returns the list of movies the actor is starring at
	 * @return the movies - list of movie objects
	 */
	public ArrayList<Movie> getMovies() {
		return this.movies;
	}
	
	/**
	 * addMovie adds a movie in the list of movies that the actor is starring
	 * @param movie - a Movie object
	 */
	public void addMovie(Movie movie){
		this.movies.add(movie);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor [actorid=" + actorid + ", name=" + name + ", gender=" + gender + ", age=" + age + ", movies="
				+ movies + "]";
	}

	/**
	 * getActorid returns the id of the actor
	 * @return double value
	 */
	public double getActorid() {
		return actorid;
	}
	
	/**
	 * getName returns the name of the actor
	 * @return String value
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getGender returns the gender of the actor
	 * @return - String value
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * getAge returns the age of the actor
	 * @return - double value
	 */
	public double getAge() {
		return age;
	}
	
	
	
	

}
