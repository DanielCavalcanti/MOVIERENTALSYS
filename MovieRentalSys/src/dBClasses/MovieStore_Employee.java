/**
 * 
 */
package dBClasses;

import java.util.ArrayList;

/**
 * The MovieStore_Employee encapsulates the properties and attributes 
 * of an employee in a movie rental database
 * @author Lyrene Labor
 * @version April 2017
 */
public class MovieStore_Employee {

	private double empid;
	private String fullname;
	private double salary;
	private double managerid;
	private ArrayList<MovieStore_Employee> managed; //list of emps mananaged by current instance 
	private ArrayList<MovieRental> sales;
	
	/**
	 * The constructor initializes all attributes of an MovieStore_Employee object 
	 * @param empid - id of the employee
	 * @param fullname - first and last name of the employee
	 * @param salary - the yearly salary of the employee
	 */
	public MovieStore_Employee(double empid, String fullname, double salary, double managerid) {
		this.empid = empid;
		this.fullname = fullname;
		this.salary = salary;
		this.managerid = managerid;
		this.managed = new ArrayList<>();
		this.sales = new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieStore_Employee [empid=" + empid + ", fullname=" + fullname + ", salary=" + salary + ", managerid="
				+ managerid;
	}

	/**
	 * getEmpid returns the id of the employee
	 * @return the empid - double value
	 */
	public double getEmpid() {
		return empid;
	}
	
	/**
	 * addManaged adds a MovieStore_Employee object at the end of the list of
	 * employees that the employee is managing
	 * @param man
	 */
	public void addManaged(MovieStore_Employee man){
		this.managed.add(man);
	}

	/**
	 * getFullname returns the fullname of the employee
	 * @return the fullname - String value
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * getSalary returns the salary of the employee
	 * @return the salary - double value
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * getManaged returns the list of employees that the employee is managing
	 * @return the managers - list of MovieStore_Employee objects
	 */
	public ArrayList<MovieStore_Employee> getManaged() {
		return managed;
	}

	/**
	 * getSales returns the list of rents the employee has completed
	 * @return the sales - list of MovieRental objects
	 */
	public ArrayList<MovieRental> getSales() {
		return sales;
	}
	
	/**
	 * addSales adds a new rental object to the list of rentals completed by the employee
	 * @param mr - a MovieRental object
	 */
	public void addSales(MovieRental mr){
		this.sales.add(mr);
	}
	
	
	
	
	
}
