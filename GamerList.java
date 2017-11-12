/*
 * Implement a class that maintains a list of the top ten performers in a video game. An entry on the list consists of a name and score, and the list is kept sorted in descending order of scores.
 * Use a class based on linked lists. The class should have a constructor that sets up an empty list, and a void insert(String name, int score) method that adds a name and a score pair to the list.
 * The insert method puts the entry in the proper position so that the list stays sorted by score. The list should have a maximum size of 10. After the list has 10 elements, an attempt to add a
 * name with a score that is less than or equal to the minimum score on the list is ignored, and adding a score that is greater than the minimum score causes an entry with the minimum score to be
 * dropped from the list.
 */

package homework;

public class GamerList
{
	private final int MAX_SIZE = 10;
	
	//The Node class stores list elements and a reference to the next node
	private class Node
	{
		String name;
		int score;
		Node next;
	
		//Store the gamer & score elements in the node & reference the successor node
		Node(String gamer, int s, Node n)
		{
			name = gamer;
			score = s;
			next = n;
		}
		
		//Store the gamer & score elements in the node
		Node(String gamer, int s)
		{
			//Call the other (sister) constructor
			this(gamer,s,null);
		}
	}
		
	private Node first;  // list head
	@SuppressWarnings("unused")
	private Node last;   // last element in list
		
	//Constructor sets up an empty list
	public GamerList()
	{
		first = null;
		last = null;
	}
	
    //Make sure the list is empty
	public boolean isEmpty()
	{        
		return first == null;       
	}
	
	//Return number of elements in the list
    public int size()
    {
        int count = 0;
        Node p = first;
        
        while (p != null)
        {
        	//There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }
    
    //Add elements at the end of the list or insert them in descending order based on score
    public void insert(String name, int score)
    {   
        if (isEmpty())
        {
            first = new Node(name, score);
            last = first;
        }
        else
        {
        	//Add elements to an existing list & utilize auxiliary reference initialized to head to traverse list
        	Node temp = new Node(name, score);
        	Node pred = first;
        	
        	if(score > pred.score)
        	{
        		temp.next = first;
        		first = temp;
        	}
        	else
        	{
        		while(pred.next != null && pred.next.score > score)
        		{
        			pred = pred.next;
        		}
        		
        		temp.next = pred.next;
	        	pred.next = temp;  
        	}
        	if(temp.next==null)
        	{
        		last = temp;
        	}
        }
        
        //Once list reaches max size, scores less than the minimum score are ignored, or new minimum will push out former minimum element
        if( size() > MAX_SIZE)
        {
            Node p = first;
            
            for( int i = 0; i < (MAX_SIZE - 1); i++)
            {
                p = p.next;
            }
            p.next = null;
            last = p;
        }
    }
	
    //Compute & return string representation of list
	public String toString()
	{
		StringBuilder sBuilder = new StringBuilder();
		Node p = first;
		while (p != null)
		{
			sBuilder.append(p.name + " " + p.score + "\n");
			p = p.next;
		}
		return sBuilder.toString();
	}
}
