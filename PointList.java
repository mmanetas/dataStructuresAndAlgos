/*Write a class named PointList that keeps a list of Point objects in an ArrayList.
 * The PointList class should accept any object that is an instance of the Point class, or a subclass of Point.
 * Demonstrate the class in an application.
*/
package homework;

import java.util.ArrayList;

public class PointList<E>
{
	private ArrayList<Point<?>> myList = new ArrayList<Point<?>>();
	
	public void addPoint(Point<?> p)
	{
		myList.add(p);
	}
	
	/*public void removeEndPoint(Point<?> p)
	{
		myList.remove(p);
	}
	*/
	
	public void printPoint(Point<?> p)
	{
		System.out.println("X coordinate: " + p.getX());
		System.out.println("Y coordinate: " + p.getY());
		System.out.println();
	}
}

