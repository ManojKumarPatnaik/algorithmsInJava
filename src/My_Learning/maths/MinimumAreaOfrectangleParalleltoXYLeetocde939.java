package My_Learning.maths;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaOfrectangleParalleltoXYLeetocde939 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minAreaRect(int[][] points) {
		HashMap<Integer, Set<Integer>> hashmap = new HashMap<>(); // Key => Integer | Value => Set

		for (int single_point[] : points) // Iterate through every single point & store the coordinates in map
		{
			if (!hashmap.containsKey(single_point[0])) { // Check if x coordinate of the single point already
															// exisits as a Key in hasmap.
				hashmap.put(single_point[0], new HashSet<Integer>()); // Insert a new Key (equal to x coordinate) in
																		// the hashmap with corresponding Value
																		// (equal to newly created empty HashSet).
			}
			hashmap.get(single_point[0]).add(single_point[1]); // Insert y coordinate into Value (HashSet)
																// corresponding to Key (equal to x coordinate)
			/*
			 * Explanation : single_point => refering to a single point [x,y] x-coordinate
			 * of a single point => single_point[0] y-coordinate of a single point =>
			 * single_point[1]
			 * 
			 * Key => x coordinate of a point => single_point[0]
			 * 
			 * Value => HashSet of y coordinates => hashmap.get(Key) =>
			 * hashmap.get(x-coordinate of a single point) => hashmap.get(single_point[0])
			 * 
			 * Insert y coordinate into corresponding Value (HashSet) =>
			 * Value.add(y-coordinate of a single point) =>
			 * hashmap.get(Key).add(y-coordinate of a single point) =>
			 * hashmap.get(x-coordinate of a single point).add(y-coordinate of a single
			 * point) => hashmap.get(single_point[0]).add(single_point[1])
			 */
		}

		int minimum_area = Integer.MAX_VALUE; // Vairable to store the minimum area

		for (int i = 0; i < points.length; i++) { // Iterator corresponding to different A points
			for (int j = 0; j < points.length; j++) { // Iterator corresponding to different B points

				int x1 = points[i][0], y1 = points[i][1]; // Coordinates of Point A

				int x2 = points[j][0], y2 = points[j][1]; // Coordinates of Point B

				if (x1 != x2 && y1 != y2) // Point A & B must form a diagonal of the rectangle.
					if (hashmap.get(x1).contains(y2) // Check if D exists in hashmap
							&& hashmap.get(x2).contains(y1)) // Check if C exists in hashmap
						/*
						 * Explanation : Check existence of y2 in Value (HashSet) corresponding to x1
						 * Key => Value.contains(y-coordinate of point B) =>
						 * hashmap.get(Key).contains(y-coordinate of point B) =>
						 * hashmap.get(x-coordinate of point A).contains(y-coordinate of point B) =>
						 * hashmap.get(x1).contains(y2) => Checks if point D exists in hashmap Check
						 * existence of y1 in Value (HashSet) corresponding to x2 Key =>
						 * Value.contains(y-coordinate of point A) =>
						 * hashmap.get(Key).contains(y-coordinate of point A) =>
						 * hashmap.get(x-coordinate of point B).contains(y-coordinate of point A) =>
						 * hashmap.get(x2).contains(y1) => Checks if point C exists in hashmap
						 */
						minimum_area = Math.min(minimum_area, Math.abs(x1 - x2) * Math.abs(y1 - y2)); // Store the
																										// minimum
																										// area
																										// possible
			}
		}
		return minimum_area != Integer.MAX_VALUE ? minimum_area : 0; // Return 0 if no rectangle exists
	}

}
