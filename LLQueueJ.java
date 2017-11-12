package homework;

public class LLQueueJ {
	
	@SuppressWarnings("serial")
	class EmptyQueueException extends RuntimeException
	{    
	}
	
	private class Node
	{
		String value;
		Node next;
		Node (String v, Node n)
		{
			value = v;
			next = n;
		}
	}
	
	private Node front = null;
	private Node rear = null;
	
	public void enqueue (String s)
	{
		if (rear != null)
		{
			rear.next = new Node (s, null);
			rear = rear.next;
		}
		else
		{
			rear = new Node (s, null);
			front = rear;
		}
	}
	
	public boolean empty()
	{
		return front == null;
	}
	
	public String dequeue()
	{
		if (empty())
			throw new EmptyQueueException();
		else
		{
			String value = front.value;
			front = front.next;
			if (front == null)
				rear = null;
			return value;
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		Node p = front;
		while (p != null)
		{
			sb.append(p.value + "\n");
			p = p.next;
		}
		return sb.toString();
	}
}
