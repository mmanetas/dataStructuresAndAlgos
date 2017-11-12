/*Write a recursive method that returns the number of 1’s in the binary representation of N.
Use the fact that this is equal to the number of 1’s in the representation of N / 2, plus 1, if N is odd.
Your method should be called ones and take in a single int, n. This method should be short. 
Certainly no more than 10 lines of code and you can get it done in 4.
Your method should return an int, the number of ones in the binary representation of n.
Call this method from a main method several times to show that it works correctly and display the results out to standard out.
Turn in a file called Ones.java and OnesTest.java (this class should have a main method).
*Make sure you are writing a recursive method to solve the problem.
You should not be using any additional Java library classes or methods.
*/

package homework;

public class Ones {
	
	//Return an int, the number of ones in the binary representation of n
	public int ones(int n)
	{
		//Base case of recursive method
		if(n == 0)
			return 0;
		//Binary representation is equal to the number of 1’s in the representation of N / 2, plus 1, if N is odd. Return an integer.
		else
			return ones(n / 2) + (n % 2);
	}
}