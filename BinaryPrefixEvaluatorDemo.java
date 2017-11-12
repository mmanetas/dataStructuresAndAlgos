//Display the value in a suitable GUI component.

package homework;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BinaryPrefixEvaluatorDemo extends JFrame
{
    private JTextArea listView;
    private JTextField cmdTextField;
    private JTextField resultTextField;
    
    public BinaryPrefixEvaluatorDemo()
    {
        listView = new JTextArea();
        cmdTextField = new JTextField();
        resultTextField = new JTextField();
        
        // Create a panel and label for result field
        JPanel resultPanel = new JPanel(new GridLayout(1,2));
        resultPanel.add(new JLabel("Expression Result: "));
        resultPanel.add(resultTextField);
        resultTextField.setEditable(false);
        add(resultPanel, BorderLayout.NORTH);
        
        // Put the textArea in the center of the frame
        add(listView);
        listView.setEditable(false);
        listView.setBackground(Color.WHITE);
        
        // Create a panel and label for the command text field
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(new JLabel("Prefix expression: "));
        cmdPanel.add(cmdTextField);
        add(cmdPanel, BorderLayout.SOUTH);  
        cmdTextField.addActionListener(new CmdTextListener());
        
        // Set up the frame
        setTitle("Binary Prefix Evalution Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);       
     }
      
     /**
        Private class that responds to the command that 
        the user types into the command entry text field.
     */
     
     private class CmdTextListener
             implements ActionListener
     {            
         public void actionPerformed(ActionEvent evt)
         {
             String input = cmdTextField.getText();
             listView.append(input + " = " + PrefixEvaluator.evaluateExpression(input) + "\n");
             pack();
             return;
         }
    }
    
    public static void main(String[] args)
    {
        //Create instance of PrefixEvaluatorDemo class, so JFrame window is displayed
        new BinaryPrefixEvaluatorDemo();
    }
}