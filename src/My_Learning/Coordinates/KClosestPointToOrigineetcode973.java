package My_Learning.Coordinates;

import java.util.PriorityQueue;

public class KClosestPointToOrigineetcode973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] kClosest(int[][] points, int k) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> getDistance(p1).compareTo(getDistance(p2)));

		for (int i = 0; i < points.length; i++) {
			pq.add(points[i]);
		}

		int[][] result = new int[k][2];

		for (int i = 0; i < k; i++) {
			result[i] = pq.poll();
		}

		return result;
	}

	private Double getDistance(int[] point) {
		return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
	}

}
