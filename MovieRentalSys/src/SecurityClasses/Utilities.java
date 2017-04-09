/**
 * 
 */
package SecurityClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * The Utilities class provides common methods used to connect to a database
 * and access and manipulate data from the database, generating hash and salt numbers.
 * @author Lyrene Labor
 * @version April 2017
 */
public class Utilities {
		
	private static String user;
	private static String pass;
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * getConnection makes a connection to an oracle database and returns the connection
	 * @return A Connection object
	 * @throws SQLException when an SQL error has occurred while making a database connection
	 * @throws Exception when any other connection problem has occurred 
	 */
	public static Connection getConnection() throws SQLException, Exception{
		config();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//jdbc:oracle:thin:@198.168.52.73:1521:orad11g
		Connection connection = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", user, pass);
		return connection;			
	}
	
	
	/**
	 * getSalt method will generate a random String and return it
	 * @return a String object
	 */
	public static String getSalt(){
		return new BigInteger(140, random).toString(32);
	}
	

	/**
	 * hash method will take a password and a salt a performs a one way hashing 
	 * on them, returning an array of bytes.
	 * @param password - the string password of a user
	 * @param salt - a random generated String
	 * @return an array of bytes representing the hash of the password
	 */
	public static  byte[] hash(String password, String salt){
		try{
			SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
			PBEKeySpec spec = new PBEKeySpec( password.toCharArray(), salt.getBytes(), 1024, 256 );

			SecretKey key = skf.generateSecret( spec );
			byte[] hash = key.getEncoded( );
			return hash;
		}catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
			throw new RuntimeException( e );
		}
	}

	
	
	/**
	 * config method will read the file containing the administrative username and password
	 * in order to connect to the database and retrieve the necessary information or make the
	 * necessary data manipulation
	 */
	private static void config(){
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader("config.txt");
			br = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<>();
			String sCurrentLine;

			br = new BufferedReader(new FileReader("config.txt"));
			
			//read each line of the config text and save each line in a list
			while ((sCurrentLine = br.readLine()) != null) {
				list.add(sCurrentLine);
			}
			user = list.get(0);
			pass = list.get(1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}
