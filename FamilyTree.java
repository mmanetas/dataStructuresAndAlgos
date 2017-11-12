/*Write a program, with a graphical user interface, that allows users to create genealogy trees and work with them.
Each person in this genealogy tree will be restricted to having at most two children. The nodes of the tree will store string values,
which are interpreted as names of people. The program should support the following commands:

root name: adds name as the root of the tree. This must be the first command entered: it creates a tree with a single node, whose value field holds name.
	The created node becomes the root of the genealogy tree. The command is ignored if it is entered after the tree has been created
left parent child: adds a new node child as the left child of the node with name parent. The command is ignored if there is no node with the name parent in the tree,
	or if there is such a node, but it already has a left child.
right parent child: adds a new node child as the left child of the node with name parent. The command is ignored if there is no node with the name parent in the tree,
	or if there is such a node, but it already has a right child.
descendants person: displays a list of all descendants of the node with name person. The command is ignored if there is no node in the tree with that name
ancestors person: displays a list of all ancestors of the node with the name person. The command is ignored if there is no node in the tree with that name.
*/


package homework;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class FamilyTree extends JTree
{
	//Checks to see if method is the first command because root name must be the first command entered
	private boolean isFirstCommand = false;
	class Node
	{
		String value;
		Node left, right;
		
		//Constructor for leaf nodes; initializes node
		Node(String val)
		{
			value = val;
			left = null;
			right = null;
		}
		
		//Constructor for non-leaf nodes
		Node(String val, Node leftChild, Node rightChild)
		{
			value = val;
			left = leftChild;
			right = rightChild;
		}
	}
	
	//Root of family tree
	private Node root = null;
	
	//Adds value to the tree by calling & passing to root method
	public boolean root(String v)
	{
		if(root == null)
		{
			isFirstCommand = true;
			root = new Node(v);
			return true;
		}
		else
			return false;
	}
	
	//Determine if value is in tree
	private Node contains(String s, Node node)
	{
		Node n = null;
		if(node == null)
			return null;
		if(node.value.equals(s.trim()))
			return node;
		if(node.left != null)
			n = contains(s, node.left);
		if(n == null)
			n = contains(s, node.right);
		return n;
	}
	
	public boolean addLeft(String p, String c)
	{
		if(!isFirstCommand)
			return false;
		Node n = contains(p, root);
		//Command is ignored if there is no node with the name parent in the tree, or if there is such a node, but it already has a left child
		if(n==null || n.left != null)
			return false;
		//Add a new node child as the left child of the node with name parent.
		n.left = new Node(c);
		return true;
	}
  
	//Adds value to tree after locating parent
	public boolean addRight(String p, String c)
	{
		Node n = contains(p, root);
		//Command is ignored if there is no node with the name parent in the tree, or if there is such a node, but it already has a right child
		if(n==null || n.right != null)
			return false;
		//Add a new node child as the right child of the node with name parent.
		n.right = new Node(c);
		return true;
	}
	
	public List<String> getAncestors(String s)
	{
		List<String> list = new ArrayList<>();
		Node n = contains(s, root);
		if(n == null)
			return list;
		populateAncestorsList(list, root, n);
		return list;
  }
  
    public String toString(List<String> list)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	for(String s : list)
    		sb.append(s + "\n");
    	return sb.toString();
    }
	
	//Displays a list of all ancestors of the node with the name person. The command is ignored if there is no node in the tree with that name.
	public boolean populateAncestorsList(List<String> list, Node n, Node s)
	{
		if(n==null)
			return false;
		if(n.equals(s))
      		return true;
		if(populateAncestorsList(list, n.left, s))
		{
			list.add(n.value);
			return true;
		}
		if(populateAncestorsList(list, n.right, s))
		{
			list.add(n.value);
			return true;
		}
		return false;
	}
	
	public List<String> getDescendants(String s)
	{
		List<String> list = new ArrayList<>();
		Node n = contains(s, root);
		if(n == null)
			return list;
		populateDescendantsList(list, n);
		return list;
	}
  
	//displays a list of all descendants of the node with name person. The command is ignored if there is no node in the tree with that name
	private void populateDescendantsList(List<String> list, Node n)
	{
		if(n==null)
			return;
		list.add(n.value);
		if(n.left!=null)
		{
			populateDescendantsList(list, n.left);
		}
		if(n.right!=null)
		{
			populateDescendantsList(list, n.right);
		}
	}
	
	private class BTreeDisplay extends JPanel
	{
		BTreeDisplay(Node tree)
		{           
			setBorder(BorderFactory.createEtchedBorder());
			setLayout(new BorderLayout());
			if(tree != null) 
			{          
				String value = String.valueOf(tree.value);  
				int pos = SwingConstants.CENTER;
				JLabel rootLabel = new JLabel(value, pos);                         
				add(rootLabel, BorderLayout.NORTH);
				JPanel panel = new JPanel(new GridLayout(1, 2));
				panel.add(new BTreeDisplay(tree.left));
				panel.add(new BTreeDisplay(tree.right));    
				add(panel);
			}       
		}   
	}
	
	public JPanel getView()
	{
		return new BTreeDisplay(root);       
	}   
}