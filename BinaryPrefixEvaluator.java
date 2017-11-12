package homework;

import java.util.Scanner;

public class BinaryPrefixEvaluator
{
	
	//Assume that the user enters expressions that use only positive integers and the two operators + and *
	private static final Character OPERATOR_MULTIPLICATION = '*';
	private static final Character OPERATOR_ADDITION = '+';
	
	
	private class Node
	{
		String value; //operator
		Node left, right; //operator's operands
		Node(String v, Node l, Node r)
		{
			value = v;
			left = l;
			right = r;
		}
	}
	
	//Pass a scanner that contains the input expression; assume all elements are separated by a whitespace
	Node buildExpr(Scanner sc)
	{
		//Read first element
		String s = sc.next();
		
		//Confirm element is numeric
		if (isNumeric(s))
			return new Node(s, null, null); //If true, number is formed into a Node with null sub-expressions & new Node is returned
		else
		{
			//s is an operator, so build a non-leaf tree
			//buildExpr recursively reads the Scanner object & forms two expressions for sub-trees
			Node leftOp = buildExpr(sc);
			Node rightOp = buildExpr(sc);
			return new Node(s, leftOp, rightOp); //Resulting node is returned
		}
	}

	public boolean isNumeric(String s)
	{
		return java.util.regex.Pattern.matches("\\d+", s);
	}
	
	//Recursively process tree to find value
	@SuppressWarnings("unused")
	private int eval(Node tree)
	{
		//If expression being evaluated consists of one-leaf node, the value is a operand
		if (tree.left == null && tree.right == null)
			return Integer.parseInt(tree.value); //Convert string value to int in order to solve expression
		else
		{
			int leftOperand = eval(tree.left);
			int rightOperand = eval(tree.right);
			if (tree.value.equals(OPERATOR_MULTIPLICATION))
				return leftOperand * rightOperand;
			if (tree.value.equals(OPERATOR_ADDITION))
				return leftOperand + rightOperand;
		}
		return 0; //Will never be reached
	}
}
