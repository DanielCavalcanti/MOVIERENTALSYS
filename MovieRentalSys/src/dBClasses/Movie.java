/**
 * 
 */
package dBClasses;

import java.util.ArrayList;

/**
 * The Movie class holds the properties and attributes
 * of a movie object in a movie rental database such as
 * the title, the category, the number of copies available,
 * the rating
 * @author Lyrene Labor
 * @version April 2017
 */
public class Movie {
	
	//column names
	private int movieid;
	private String title;
	private String category;
	private int qty;
	private int rating;
	private ArrayList<Actor> actorsInMovie;
	
	/**
	 * Contructor initializes all attributes of a movie object
	 * @param movieid - int value representing the id of the movie in the database
	 * @param title - the title of the movie
	 * @param category - the category of the movie
	 * @param qty - number of copies available of the movie in the database
	 * @param rating - the rating of the movie
	 */
	public Movie(int movieid,String title,String category,int qty,int rating){
		this.movieid = movieid;
		this.title = title;
		this.category = category;
		this.qty = qty;
		this.rating = rating;
	}

	/**
	 * getActorsInMovie returns the list of actors starring in the movie
	 * @return the actorsInMovie
	 */
	public ArrayList<Actor> getActorsInMovie() {
		return actorsInMovie;
	}
	
	/**
	 * addActor adds an actor object to the end of the list of actors of the movie
	 * @param actor - An actor object
	 */
	public void addActor(Actor actor){
		this.actorsInMovie.add(actor);
	}

	/**
	 * getMovieid returns the id value of the movie
	 * @return int value
	 */
	public int getMovieid() {
		return movieid;
	}

	/**
	 * getTitle method returns the title of the book
	 * @return String value
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * getCategory returns the category of the movie
	 * @return String value
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * getQty returns the number of copies available of the movie in the database
	 * @return int value
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * getRating returns the rating of the movie
	 * @return int value
	 */
	public int getRating() {
		return rating;
	}
	
	/**
	 * toString returns the string representation of the movie's attributes
	 */
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", title=" + title + ", category=" + category + ", qty=" + qty
				+ ", rating=" + rating + "]";
	}
	
	

}
