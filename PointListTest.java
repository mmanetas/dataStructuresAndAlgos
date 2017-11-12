package homework;

//import java.util.ArrayList;

public class PointListTest {

	public static void main(String[] args) {
		
		//Create various Point objects
		Point<Integer> pointA = new Point<Integer>(1,2);
		Point<Integer> pointB = new Point<Integer>(3,4);
		Point<Double> pointC = new Point<Double>(5.0,6.0);
		Point<String> pointD = new Point<String>("x","y");
		
		//Create various PointList objects
		PointList<Point<Integer>> testList = new PointList<Point<Integer>>();
		PointList<Point<Double>> testList2 = new PointList<Point<Double>>();
		PointList<Point<String>> testList3 = new PointList<Point<String>>();
		
		//Add points to PointLists
		testList.addPoint(pointA);
		testList.addPoint(pointB);
		testList2.addPoint(pointC);
		testList3.addPoint(pointD);
		
		//Display each object's coordinates
		testList.printPoint(pointA);
		testList.printPoint(pointB);
		testList2.printPoint(pointC);
		testList3.printPoint(pointD);
	}
}