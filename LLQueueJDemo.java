package homework;

import java.util.Scanner;

public class LLQueueJDemo {

	public static void main(String[] args) {
		final int SIZE = 5;
		LLQueueJ queue = new LLQueueJ();
		String [] songs = new String [SIZE];
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your top " + songs.length + " favorite LL Cool J songs.");
		for (int i = 0; i < songs.length; i++)
		{
			System.out.print(String.format("Enter song number %d: ",(i+1)));
			songs[i] = keyboard.nextLine();
		}
		
		System.out.println("\nAdding your favorite songs: ");
		for (String s : songs)
		{
			System.out.println(s);
			queue.enqueue(s);
		}
		
		System.out.println("\nState of queue is: ");
		System.out.println(queue);
		
		System.out.println("\nI have to remove all of your choices, sorry.");
		while (!queue.empty())
		{
			queue.dequeue();
		}
		System.out.println("Now, the state of queue is empty: ");
		System.out.println(queue);
		
		System.out.println("Adding my favorite song.");
		queue.enqueue("Mama Said Knock You Out!");
		System.out.println("State of the queue is: " + queue);
	}

}
