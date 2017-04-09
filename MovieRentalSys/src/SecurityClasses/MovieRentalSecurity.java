/**
 * 
 */
package SecurityClasses;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * The MovieRentalSecurity class is used to create the different
 * users with different account types in the movie rental store
 * and credential verifications when users try to loggin to their
 * account
 * @author Lyrene Labor
 * @version April 2017
 *
 */
public class MovieRentalSecurity {
	
		/**
		 * newUser method takes a username and password and all other user info and creates 
		 * an account for that user with an account type based on the input type passed 
		 * to the method.
		 * @param username - the username of the user
		 * @param password - the password of the user
		 * @param type - the account type for the user
		 * @throws SQLException when an SQL error has occurred while adding a new user
		 * @throws Exception when any other error has occurred while adding a new user
		 */
		public void newUser(String username, String password, String type,
							String name, String address, String phone, String email ) throws SQLException, Exception{
			
			//get salt for password
			String salt = Utilities.getSalt();
			//get hash for password and salt
			byte[] hash = Utilities.hash(password,salt);
			double maxID = 0;
			Connection con = null;
			try{
				con = Utilities.getConnection();
				con.setAutoCommit(false);

				if(type.equalsIgnoreCase("Customer")){
					//the following will get the max customer id existing in the database
					String maxQuery = "SELECT MAX(CUSTOMER_ID) FROM moviestore_customer";
					PreparedStatement maxstmt = con.prepareStatement(maxQuery);
					ResultSet rs = maxstmt.executeQuery();	
					while(rs.next()){
						maxID = rs.getDouble("MAX(CUSTOMER_ID)");
					}
					maxID++;

					//the following will check if the user already exists in the customer table
					String nameQuery = "SELECT * FROM moviestore_customer WHERE"
										+ " fullname = ?";
					PreparedStatement namestmt = con.prepareStatement(nameQuery);
					namestmt.setString(1, name);
					ResultSet result = namestmt.executeQuery();
					if(result.next()){
						throw new SQLException("User already exists");
					}
	
					//the following will insert a new entry in the moviestore_customer table
					String query1 = "INSERT INTO moviestore_customer VALUES(?,?,?,?,?)";
					PreparedStatement stmt1 = con.prepareStatement(query1);
					stmt1.setDouble(1, maxID);
					stmt1.setString(2, name);
					stmt1.setString(3, address);
					stmt1.setString(4, phone);
					stmt1.setString(5, email);
					stmt1.executeUpdate();
				}

				//the following will insert a new entry in the users table
				String query2 = "INSERT INTO users VALUES(?,?,?,?)";
				PreparedStatement stmt2 = con.prepareStatement(query2);
				stmt2.setString(1, username);
				stmt2.setString(2, type);
				stmt2.setString(3, salt);
				stmt2.setBytes(4, hash);
				stmt2.executeUpdate();
				System.out.println("New user " + username + " added successfully");
				
				con.commit();			
			}catch(SQLException e){
				if(con!=null)
					con.rollback();
				System.out.println("An error occured while adding a new user. \n" + e.getMessage());
			}finally{
				if(con!=null){
					con.close();
				}
			}	
		}
		
		
		/**
		 * The overloaded newUser method will prompts the user to input
		 * a username and password and all other user info, and creates an account for that user
		 * and an entry in the moviestore customer or employee table
		 * based on the input type account.
		 * @param type - the account type
		 * @throws SQLException when an SQL error has occurred while adding a new user
		 * @throws Exception when any other error has occurred while adding a new user
		 */
		public void newUser(String type) throws SQLException, Exception{
			Scanner scan = null;
			String username = "";
			String password="";
			String name = "";
			String address="";
			String phone = "";
			String email = "";
			try{
				scan = new Scanner(System.in);
				System.out.println("Please enter your username");
				username = scan.nextLine();
				System.out.println("Please enter your password");
				password = scan.nextLine();
				System.out.println("Please enter your fullname");
				name = scan.nextLine();
				System.out.println("Please enter your address");
				address = scan.nextLine();
				System.out.println("Please enter your phone number");
				phone = scan.nextLine();
				System.out.println("Please enter your email");
				email = scan.nextLine();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			newUser(username,password,type,name,address,phone,email);			
		}
		
	
		
		
		/**
		 * login method will take a username and password returns true if they 
		 * belong to a valid user
		 * @param username - the username of the user
		 * @param password - the password of the user
		 * @return boolean true or false if valid user
		 * @throws SQLException when an SQL error has occurred while logging  
		 * @throws Exception when any other error has occurred while logging
		 */
		//Takes a username and password returns true if they belong to a valid user
		public boolean login(String username, String password)throws SQLException, Exception{
			
			Connection con = null;
			String salt = "";
			byte[] hash = null;
			try{
				con = Utilities.getConnection();
				PreparedStatement stmt1 = con.prepareStatement("SELECT salt,hash FROM users WHERE userid = ?");
				stmt1.setString(1, username);
				ResultSet rs1 = stmt1.executeQuery();
				
				while(rs1.next()){
					salt = rs1.getString("salt");
					hash = rs1.getBytes("hash");
				}
				
				byte[] generatedHash = Utilities.hash(password,salt);
				
				if(hash.length != generatedHash.length)
					return false;
							
				for(byte i = 0; i<hash.length; i++){
					if(hash[i] != generatedHash[i]){
						return false;
					}
				}
				System.out.println("Logged on successfully with user " + username);			
				return true;				
			}catch(Exception e){
				System.out.println("Cannot log on. Please try again.");
			}					
			return false;
		}
		
		
		
		/**
		 * The overloaded login method will prompt the user to input 
		 * their login info, returns true if they are a valid user, false otherwise
		 * @return boolean true or false if valid user
		 * @throws SQLException when an SQL error has occurred while logging
		 * @throws Exception when any other error has occurred while adding a new user
		 */
		//Prompts the user to input their login info, returns true if they are a valid user, false otherwise
		public boolean login() throws SQLException, Exception{
			Scanner scan= null;
			String username = "";
			String password = "";
			try{
				scan = new Scanner(System.in);
				System.out.println("Please enter your username");
				username = scan.nextLine();
				System.out.println("Please enter your password");
				password = scan.nextLine();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			return login(username, password);
		}
	

}
