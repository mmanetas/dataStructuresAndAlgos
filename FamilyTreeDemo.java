package homework;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

@SuppressWarnings("serial")
public class FamilyTreeDemo extends JFrame
{
	private FamilyTree bTree = new FamilyTree();   
    private JLabel cmdResultLabel;
    private JTextField cmdResultTextField;
    
    private JLabel cmdLabel;
    private JTextField cmdTextField;   
    
    public FamilyTreeDemo()
    {
        setTitle("Family Tree");
        
        //cmd text and cmd Result label in South
        JPanel resultPanel = new JPanel(new GridLayout(1,2));
        cmdResultLabel = new JLabel("Command Result: ");
        cmdResultTextField = new JTextField();
        resultPanel.add(cmdResultLabel);
        resultPanel.add(cmdResultTextField);
        cmdResultTextField.setEditable(false);
        add(resultPanel, BorderLayout.SOUTH);
        
        // Leave center for binary tree view
        
        // cmd label and cmd text field in North
        cmdLabel = new JLabel("Command: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        ActionListener cmdLis = new CmdTextListener();
        cmdTextField.addActionListener(cmdLis);
        add(cmdPanel, BorderLayout.NORTH);
        
        // Set up the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
    }
    
    JPanel view = null;
    
    /**
	    This private inner class responds to commands
		 typed into the command entry text field.
    */
    private class CmdTextListener
	        implements ActionListener
	 {		  
       public void actionPerformed(ActionEvent evt)
       {
          String cmdStr = cmdTextField.getText();
          @SuppressWarnings("resource")
          Scanner keyboard = new Scanner(cmdStr);
          String cmd = keyboard.next();
          if (cmd.equals("root"))
          {
              String value = keyboard.next();
              bTree.root(value);
              if (view != null)
                 remove(view);
              view = bTree.getView();            
              add(view);
              pack();
              validate(); 
              cmdResultTextField.setText("Root = " + value);
          }
          if(cmd.equals("left"))
          {
        	  String parent = keyboard.next();
        	  String child = keyboard.next();
        	  bTree.addLeft(parent, child);
        	  if (view != null)
        		  remove(view);
        	  view = bTree.getView();            
        	  add(view);
        	  pack();
        	  validate(); 
        	  cmdResultTextField.setText("Child: " + child + " added to parent: " + parent + "'s left.");
          }
          if(cmd.equals("right"))
          {
        	  String parent = keyboard.next();
        	  String child = keyboard.next();
        	  bTree.addRight(parent, child);
        	  if (view != null)
        		  remove(view);
        	  view = bTree.getView();            
        	  add(view);
        	  pack();
        	  validate(); 
        	  cmdResultTextField.setText("Child: " + child + " added to parent: " + parent + "'s right.");
          }
          if(cmd.equals("descendants"))
          {
        	  String person = keyboard.nextLine();
        	  List<String> dList = bTree.getDescendants(person);
              if (view != null)
             	 remove(view);
              view = bTree.getView();            
              add(view);
              pack();
              validate(); 
              String s = bTree.toString(dList);
              cmdResultTextField.setText("Descendant(s) of " + s); 
          }
          if(cmd.equals("ancestors"))
          {
        	  String person = keyboard.nextLine();
        	  List<String> aList = bTree.getAncestors(person);
              if(view != null)
             	 remove(view);
              view = bTree.getView();            
              add(view);
              pack();
              validate();
              String s = bTree.toString(aList);
              cmdResultTextField.setText("Ancestor(s) of " + person + " : " + s);
          } 
    }
}	 
    
   /**
      The main method creates an instance of the 
	   FamilyTreeDemo class which causes it 
      to display its window.
   */

	public static void main(String[] args)
	{
		new FamilyTreeDemo();

	}
}
