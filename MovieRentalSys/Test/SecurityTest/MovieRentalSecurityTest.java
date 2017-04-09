/**
 * 
 */
package SecurityTest;

import java.util.Scanner;

import SecurityClasses.*;

/**
 * @author Lyrene Labor
 *
 */
public class MovieRentalSecurityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MovieRentalSecurity ms = new MovieRentalSecurity();
		Scanner scan = null;
		String choice = ""; 
		try{
			scan = new Scanner(System.in);	
			while(!choice.equals("3")){
				System.out.println("Please select a choice 1 - 3 from the menu");
				System.out.println("1 - Log on to an account");
				System.out.println("2 - Create a new account");
				System.out.println("3 - Quit program");
								
				choice = scan.nextLine();
				
				if(choice.equals("1")){
					if(!ms.login())
						System.out.println("Wrong password or username entered. Try again.");
				}
				else if(choice.equals("2")){
					ms.newUser("Customer");
				}
				else if(choice.equals("3")){
					break;
				}
				else{
					System.out.println("Invalid menu choice, try again!");
				}
				
				System.out.println();
				System.out.println();
				System.out.println();
			}
			System.out.println("quitting application, bye bye!");
		}catch(Exception e){
			System.out.println("Error! " + e.getMessage());
		}finally{
			if(scan!=null)
				scan.close();
		}
		

	}

}
