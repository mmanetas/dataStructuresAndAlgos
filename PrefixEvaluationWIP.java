package homework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PrefixEvaluationWIP extends JFrame implements ActionListener
{
	JTextField expression = new JTextField(25);
	JTextField result = new JTextField(25);
	
	public void CmdTextListener()
	{
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Enter prefix formula: "));
		content.add(expression);
		
		JButton calculateExpression = new JButton("Calculate");
		
		calculateExpression.setActionCommand("Calculate");
		calculateExpression.addActionListener(this);
		
		content.add(calculateExpression);
		content.add(new JLabel("Result"));
		content.add(result);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Stack<String> stackA = new Stack<String>();
			String[] operands = expression.getText().split("\\s+");
			for (String ops : operands)
				stackA.add(ops);
		
			int total = 0;
			int operand1 = Integer.parseInt(stackA.pop());
			int operand2 = Integer.parseInt(stackA.pop());
		
			Stack<String> stackB = new Stack<String>();
			String operators = stackB.pop();
			if(operators.equals("+"))
			{
				total = operand1 + operand2;
			}
			else
			{
				total = operand1 * operand2;
			}
		
			while(stackB.size() > 1)
			{
				operand2 = Integer.parseInt(stackB.pop());
				operators = stackB.pop();
			
				if(operators.equals("+"))
				{
					total = total + operand2;
				}
				else if (operators.equals("*"))
				{
					total = total * operand2;
				}
				else
				{
					throw new IllegalArgumentException("Operator unknown");
				}
			}
			String stringResult = String.valueOf(total);
			result.setText(stringResult);
		}
		catch (Exception ioe)
		{
			JOptionPane.showMessageDialog(rootPane, ioe);
		}
	}


	public static void main(String[] args)
	{
		PrefixEvaluationWIP gui = new PrefixEvaluationWIP();
		gui.CmdTextListener();
	}
}
	
	
	
	
	
	/*PrefixEvaluator()
	{
		ArrayList<String> tokens = new ArrayList<String>();
	}
	
	public void 
	public static int evaluate(String s)
	{
		Stack<Integer> stackA = new Stack<Integer>();
		Stack<String> stackB = new Stack<String>();
		
		int[] sA; //operands
	    char[] sB; //operators
	    
		//push expression onto the stacks
		for(String s : sB)
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
	    for(int i = intArray.size() -1 ; i--...) {
	       stackA.push(intArray[i]);
	    }
	}
	String[] expression;
	
	
	
	//private class Node();
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
	
//	public boolean isNumber(String s)
	{
	}
	
	//passed scanner that contains the input expression (but assumes all characters are separated by white space) -- need to implement
	Node buildExpr(Scanner keyboard)
	{
		String s = keyboard.next();
		if (isNumber(s))
			return new Node (s, null, null); //if a number is entered in the scanner, it is formed into a node with null subexpressions
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
	
	/*public static void main(String[] args)
	{
		double RPNtoDouble(String[] tokens)
		{        
			Stack<String> stack = new Stack<String>();
	         
			// For each token
			for (String token : tokens) 
			{
				// If the token is a number push it onto the stack
				if (!isOperator(token)) 
				{
					stack.push(token);                
				}
				else
				{
					// Pop the two top entries
					Double d2 = Double.valueOf( stack.pop() );
					Double d1 = Double.valueOf( stack.pop() );
	                 
					//Get the result
					Double result = token.compareTo("+") == 0 ? d1 + d2 : 
	                            token.compareTo("-") == 0 ? d1 - d2 :
	                            token.compareTo("*") == 0 ? d1 * d2 :
	                                                        d1 / d2;               
	                                 
					// Push result onto stack
					stack.push( String.valueOf( result ));                                                
				}                        
			}     
	    return Double.valueOf(stack.pop());
	}*/