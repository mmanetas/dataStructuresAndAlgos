
package homework;

import java.util.Scanner;

public class OnesTest {

	public static void main(String[] args) {
		int n = 0; //Initialize n
		String input; //To hold a line of input
		char choice; //To hold a single character
		
		do
		{
			//Create instance of Ones object
			Ones test = new Ones();
		
			//Prompt user to enter an integer
			System.out.println("Please enter an integer: ");
			
			//Create instance of Scanner
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			n = keyboard.nextInt(); //Scanner captures integer entered by user
			
			//Consume the remaining newline character
			keyboard.nextLine();
		
			//Display results to std out
			System.out.println("Total number of 1's in binary representation of n: " + test.ones(n) + "\n");
			
			//Call this method from a main method several times to show that it works correctly and display the results out to standard out.
			System.out.println("Do you want to do this again? (Y or N)");
			input = keyboard.nextLine();
			choice = input.charAt(0);
		} while (Character.toUpperCase(choice) == 'Y');
	}
}
