/*package homework;

import java.util.Stack;

public class PrefixExpressionEvaluator {
	
	public static int evaluateExpression(String s)
	{
		char[] element = s.toCharArray();
		
		Stack<Integer> operands = new Stack<Integer>();
		
		Stack<Character> operators = new Stack<Character>();
		
		for(int i = 0; i < element.length; i++)
		{
			if(element[i] == '+' || element[i] == '*')
			{
				operators.push(element[i]);
			}
		}
		
		//Remove operators from the string
		//s.replaceAll("[+*]","");
		
		//Push the operands from the string
		for(int i = 0; i < element.length - 1; i--)
		{
			StringBuffer sb = new StringBuffer();
			operands.push(Integer.parseInt(sb.toString()));
		}
		while (!operands.empty())
		{
			int op2 = operands.pop();
			int op1 = operands.pop();
			char optr = operators.pop();
			int result = evaluateResult(op2, op1, optr);
		}
	}	
	
	public int evaluateResult(int operator2, int operator1, char topOperand)
	{
		int result = 0;
		
		int op2 = operator2;
		int op1 = operator1;
		
		if(toString(topOperand.equals('+'))
		{
			result = op2 + op1;
		}
		else (topOperand.equals('*'))
		{
			result = op2 * op1;
		}
			return result;
	}
}

  /*public static int evaluates(String s) {
	    int[] stackA; //operands
	    char[] stackB; //operators
	  
	    for(int i = 0; i < s.length();i++)
	    {
	      if(s.charAt(i) == '+' || s.charAt(i) == '*' )
	      {
	         stackB.push(s.charAt(i));
	      }
	    }
	    //remove all + and * from the string
	    s.replaceAll("[+*]","");
	    
	    //get the operands out of the string
	    String[] strArray = s.split(" ");
	    int[] intArray = new int[strArray.length];
	    for(int i = 0; i < strArray.length; i++) {
	        intArray[i] = Integer.parseInt(strArray[i]);
	    }
	    
	    //push the operands on the stackA
	    for(int i = 0; i < intArray.length -1 ; i--) {
	       stackA.push(intArray[i]);
	  }
	/*prefix = +23 (operations before numbers)

	enter prefix expression

	read, evalute in jframe




	+23 = 5
	+ 2 35 


	+ * * 1 2 12 9 = 

	Write a program that allows the user to enter prefix expressions in a text field. The program reads the expression, evaluates it, and displays the value in a suitable GUI component. 
	Assume that the user enters expressoins that use only positive integers and the two operators + and *. 
	Your program should use a stack to store values of sub-expressions as they are computed, and another stack to store operators that have not yet been applied.

	* + 16 4 + 1 3 = 80
	- + * 2 3 * 5 4 9

	stack A (same as one in the video) //put on stack in reverse



	stack B (operators not yet used)  //put on stack front to back
	1) - + * *



	//how this program will work
	take input, read from front to back. push any operators onto stack B  //STACK (bottom -> top)
	A) empty
	B) - + * *
	read input from back to front. push operands onto stack A. if you see a character matching an operator, pop the top of stack B and use that operator
	ex.
	A) 9 4 5
	B) - + * * 
	(hit multiplication operator, pop the top of stack B and apply to stack A)
	A) 9 20
	B) - + *
	(push 3 and 2 onto stack A. see the next operator, we pop off top of Stack B and use the operator we popped off stack B)
	A) 9 20 6
	B) - +

	A) 9 26
	B) -

	A) 17
	B)empty
	push A
	
	//organize code!
*/

