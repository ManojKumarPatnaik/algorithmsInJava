package My_Learning.numberTheory;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatioLeetcode1792 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Cmp());
		for (int[] c : classes)
			queue.offer(c); // add all to priority queue
		for (; extraStudents > 0; extraStudents--) { // add extra student to class that will max increase the average
			int[] c = queue.poll();
			c[0]++;
			c[1]++;
			queue.offer(c);
		}
		double result = 0;
		while (!queue.isEmpty()) { // Calculate sum of pass ratios
			int[] c = queue.poll();
			result += (double) c[0] / c[1];
		}
		return result / classes.length; // return average
	}

	class Cmp implements Comparator<int[]> { // to sort in descending order of diff when 1 is added to class
		public int compare(int[] x, int[] y) {
			double xDiff = (double) (x[0] + 1) / (x[1] + 1) - (double) x[0] / x[1],
					yDiff = (double) (y[0] + 1) / (y[1] + 1) - (double) y[0] / y[1];
			return xDiff > yDiff ? -1 : 1;
		}
	}

}
