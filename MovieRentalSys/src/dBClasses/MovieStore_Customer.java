/**
 * 
 */
package dBClasses;

import java.util.ArrayList;

/**
 * The MovieStore_Customer encapsulates the properties and attributes 
 * of an customer in a movie rental database
 * @author Lyrene Labor
 * @version April 2017
 *
 */
public class MovieStore_Customer {
	
	private double custid;
	private String fullname;
	private String address;
	private String phone;
	private String email;
	private ArrayList<MovieRental> rentals;
	
	/**
	 * The constructor initializes all attributes of an MovieStore_Customer object 
	 * @param custid - id of the customer
	 * @param fullname - the first and last name of the customer
	 * @param address - the address of the customer
	 * @param phone - the phone number of the customer
	 * @param email - the email of the customer
	 */
	public MovieStore_Customer(double custid, String fullname, String address, String phone, String email) {
		this.custid = custid;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.rentals = new ArrayList<>();
	}

	/**
	 * getCustid will return the id of the customer
	 * @return the custid - double value
	 */
	public double getCustid() {
		return custid;
	}

	/**
	 * getFullname returns the fullname of the customers
	 * @return the fullname - String value
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * getAddress returns the address of the customer
	 * @return the address - String value
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * getPhone returns the phone number of the customer
	 * @return the phone - String value
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * getEmail returns the email of the customer
	 * @return the email - String value
	 */
	public String getEmail() {
		return email;
	}
	
	

	/**
	 * getRentals returns the list of rentals made by the customer
	 * @return the rentals - list of MovieRental objects
	 */
	public ArrayList<MovieRental> getRentals() {
		return rentals;
	}
	
	/**
	 * addRental adds a new rental to the list of rentals made by the customer
	 * @param mr - a MovieRental object
	 */
	public void addRental(MovieRental mr){
		this.rentals.add(mr);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieStore_Customer [custid=" + custid + ", fullname=" + fullname + ", address=" + address + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
	

}
