package My_Learning.matrixProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixCellInDistanceOrderLeetcode1030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

		Map<Integer, List<int[]>> map = new HashMap<>();

		int maxDistance = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int distance = calculateDistance(row, col, rCenter, cCenter);

				if (!map.containsKey(distance)) {
					List<int[]> list = new ArrayList<>();
					list.add(new int[] { row, col });
					map.put(distance, list);
					maxDistance = Math.max(maxDistance, distance);
				} else {
					List<int[]> points = map.get(distance);
					points.add(new int[] { row, col });
					map.put(distance, points);
				}

			}
		}

		int[][] result = new int[rows * cols][2];

		int x = 0;
		for (int i = 0; i <= maxDistance; i++) {
			for (int[] point : map.get(i)) {
				result[x++] = point;
			}

		}

		return result;

	}

	private int calculateDistance(int row, int col, int rCenter, int cCenter) {
		return Math.abs(row - rCenter) + Math.abs(col - cCenter);
	}

}
