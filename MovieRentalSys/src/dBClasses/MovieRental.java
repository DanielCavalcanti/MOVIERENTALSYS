/**
 * 
 */
package dBClasses;

import java.util.ArrayList;

/**
 * The MovieRental encapsulates the properties and behaviors 
 * of a movie rental action made in a movie rental database
 * @author Lyrene Labor
 * @version April 2017
 */
public class MovieRental {
	
	private double rentalid;
	private double empid;
	private double custid;
	private String rentdate;
	private String duedate;
	private boolean returned;
	private boolean delivered;
	private ArrayList<Movie> moviesInRental;
	
	/**
	 * The constructor initializes all attributes of a MovieRental object 
	 * @param rentalid - id of the rental
	 * @param empid - the id of the employee who made the sale
	 * @param custid - id of the customer who made the rent
	 * @param rentdate - date of the rent
	 * @param duedate - date of the due of the rend
	 * @param returned - boolean value if the rent has been returned or not
	 * @param delivered - boolean value if customer requested a delivery
	 */
	public MovieRental(double rentalid, double empid, double custid, String rentdate, String duedate, boolean returned,
			boolean delivered) {
		this.rentalid = rentalid;
		this.empid = empid;
		this.custid = custid;
		this.rentdate = rentdate;
		this.duedate = duedate;
		this.returned = returned;
		this.delivered = delivered;
		this.moviesInRental = new ArrayList<>();
	}

	/**
	 * getRentalid returns the id of the rent
	 * @return the rentalid - double value
	 */
	public double getRentalid() {
		return rentalid;
	}

	/**
	 * getEmpid returns the id of the employee who made the sale
	 * @return the empid - double value
	 */
	public double getEmpid() {
		return empid;
	}

	/**
	 * getCustid returns the id of the customer who made the rent
	 * @return the custid - double value
	 */
	public double getCustid() {
		return custid;
	}

	/**
	 * getRentdate returns the date of the rent
	 * @return the rentdate - String value
	 */
	public String getRentdate() {
		return rentdate;
	}

	/**
	 * getDuedate returns the date of the due of the rent
	 * @return the duedate - String value
	 */
	public String getDuedate() {
		return duedate;
	}

	/**
	 * getReturned returns the boolean true or false if rent has been returned or not
	 * @return the returned - boolean value
	 */
	public boolean getReturned() {
		return returned;
	}

	/**
	 * getDelivered returns the boolean true or false if customer requested a delivery
	 * @return the delivered 0 boolean value
	 */
	public boolean getDelivered() {
		return delivered;
	}

	/**
	 * getMoviesInRental returns the list of movies part of the rent
	 * @return the moviesInRental - a list of Movie objects
	 */
	public ArrayList<Movie> getMoviesInRental() {
		return moviesInRental;
	}
	
	/**
	 * addMovie adds a Movie object to the list of movies part of the rent
	 * @param m - a Movie Object
	 */
	public void addMovie(Movie m){
		this.moviesInRental.add(m);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieRental [rentalid=" + rentalid + ", empid=" + empid + ", custid=" + custid + ", rentdate="
				+ rentdate + ", duedate=" + duedate + ", returned=" + returned + ", delivered=" + delivered + "]";
	}
	
	

}
