/*
 * Test the score with a GUI similar to the LinkedList1Demo.java. The graphical interface should support a single command of the form "insert name score"
 */

package homework;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class GamerListDemo extends JFrame
{
	private GamerList gl;
	private JTextArea listView;
	private JTextField cmdTextField;
    private JTextField resultTextField;
	
    public GamerListDemo()
    {
    	gl = new GamerList();
    	listView = new JTextArea();
    	cmdTextField = new JTextField();
        resultTextField = new JTextField();
        
        // Create a panel and label for result field
        JPanel resultPanel = new JPanel(new GridLayout(1,2));
        resultPanel.add(new JLabel("Command Result"));
        resultPanel.add(resultTextField);
        resultTextField.setEditable(false);
        add(resultPanel, BorderLayout.NORTH);
        
        // Put the textArea in the center of the frame
        add(listView);
        listView.setEditable(false);
        listView.setBackground(Color.WHITE);
        
        // Create a panel and label for the command text field
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(new JLabel("Command:"));
        cmdPanel.add(cmdTextField);
        add(cmdPanel, BorderLayout.SOUTH);  
        cmdTextField.addActionListener(new CmdTextListener());
        
        // Set up the frame
        setTitle("Gamer List Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);       
     }
     
    //Private class that responds to the command user types into the command entry text field
    //GUI supports single command
     private class CmdTextListener implements ActionListener
     {
    	 public void actionPerformed(ActionEvent evt)
    	 {
        	 String cmdText = cmdTextField.getText();
             @SuppressWarnings("resource")
             Scanner keyboard = new Scanner(cmdText);
             String cmd = keyboard.next();
             
             if (cmd.equals("insert"))
             {
            	 if (keyboard.hasNext())
            	 {
            		 // add index element
            		 String name = keyboard.next();
                     int score = keyboard.nextInt();
                     gl.insert(name, score);
                 }
            	 
                 listView.setText(gl.toString());
                 pack();
                 return;
             }
         }
    }
    
	public static void main(String[] args)
	{
		//Create instance of GamerListDemo class, so JFrame window is displayed
		new GamerListDemo();
	}
}
