package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PrefixEvaluationDemoWIP extends JFrame
{

	private class Node
	{
		String value; //represents operator in prefix evaluation
		Node left, right; //references point to the operator's operands
		Node (String v, Node l, Node r)
		{
			value = v;
			left = l;
			right = r;
		}
	}

	//passed scanner that contains the input expression (but assumes all characters are separated by white space) -- need to implement
	Node buildExpr(Scanner keyboard)
	{
		String s = keyboard.next();
		
		if (keyboard.hasNext())
		{
			return new Node (s, null, null); //if a number is entered in the scanner, it is formed into a node with null subexpressions
		}
		else //buildexpression recursively reads the scanner object & forms two expressions for the left & right subtrees
		{
			//s is an operator, so build a non-leaf tree
			Node lOp = buildExpr(keyboard);
			Node rOp = buildExpr(keyboard);
			return new Node(s, lOp, rOp);
		}
	}
	
	private int eval(Node tree)
	{
		if (tree.left == null && tree.right == null) //if it's a single leaf node, it must be a number
			return Integer.parseInt(tree.value); //converted to int & returned
		else
		{
			int lOp = eval(tree.left);
			int rOp = eval(tree.right);
			if (tree.value.equals("*"))
				return lOp * rOp;
			if (tree.value.equals("+"))
				return lOp + rOp;
			if (tree.value.equals("-"))
				return lOp - rOp;
			if (tree.value.equals("/"))
				return lOp / rOp;
		}
		return 0; //will never be reached
	}
	
	private JTextField inputTextField; //user enters prefix expression
	private JTextField resultTextField; //value of expression will appear
	
	@SuppressWarnings("unused")
	private class CmdTextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) //called whenever a new expression string is typed into the input text field
		{
			String pExpr = inputTextField.getText(); //method retrieves the string
			Node exprTree = buildExpr(new Scanner (pExpr)); //runs string through scanner object & uses method buildexpression to transform the string into binary tree representing the expression
			int value = eval(exprTree); //works with binary tree to product the value
			resultTextField.setText(String.valueOf(value)); //value is then displayed in the result text field
		}
	}	
	


}
