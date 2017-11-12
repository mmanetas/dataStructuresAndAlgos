/*
 * Write a program that allows the user to enter prefix expressions in a text field. The program reads the expression, evaluates it, and displays the value in a suitable GUI component. 
 * Assume that the user enters expressions that use only positive integers and the two operators + and *. 
 * Your program should use a stack to store values of sub-expressions as they are computed, and another stack to store operators that have not yet been applied.
 */

package homework;

import java.util.Stack;


public class PrefixEvaluator
{
	//Assume that the user enters expressions that use only positive integers and the two operators + and *
	private static final Character OPERATOR_MULTIPLICATION = '*';
	private static final Character OPERATOR_ADDITION = '+';
	
	//Push operators that have not yet been applied to operator stack
	private static Stack<Character> retrieveOperators(String s)
	{
		Stack<Character> operatorStack = new Stack<>();

		//Iterates through elements in the string, * or + stored on the operator stack
		for(char c : s.toCharArray())
		{
			if(c == OPERATOR_MULTIPLICATION || c == OPERATOR_ADDITION)
			{
				operatorStack.push(c);
			}
		}
		return operatorStack;
	}
	
	public static int evaluateExpression(String s)
	{
		//One stack to store values of sub-expressions as they are computed, and another stack to store operators that have not yet been applied
		Stack<Character> operatorStack = retrieveOperators(s); 		
		Stack<Integer> operandStack = new Stack<>();

		//String split into an array based on whitespace delimiter
		String[] strArray = s.split(" ");
	    
		//String array read from right to left
	    for(int i = strArray.length-1; i >= 0; i--)
	    {
	    	//Evaluate if operator is + or *
	    	if(strArray[i].equals(String.valueOf(OPERATOR_MULTIPLICATION)) || strArray[i].equals(String.valueOf(OPERATOR_ADDITION)))
	    	{
	    		//Pop two operands off the top of the stack
	    		int a = operandStack.pop();
	    		int b = operandStack.pop();
	    		
	    		//Pop the operator off the operatorStack
	    		char operator = operatorStack.pop();
	    		
	    		//If operator is '+', add both operands & push the result back on the operandStack; else, multiply and push result back on operandStack
	    		operandStack.push((operator==OPERATOR_ADDITION) ? a + b : a * b);
	    		
	    	//If operator is found, push the operand on the operandStack & move on to next value
	    	} else
	    	{
	    		operandStack.push(Integer.parseInt(strArray[i]));
	    	}
	    }		
	    //Return result after all operations are complete & only resulting value remains
		return operandStack.pop();
	}
}

