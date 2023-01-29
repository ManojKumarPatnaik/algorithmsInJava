package My_Learning.graph;

import java.util.Arrays;

public class LargestMatrixAfterRearrangementLeetcode1727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestSubmatrix(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = matrix[i - 1][j] + 1;
				}
			}
		}

		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			Arrays.sort(matrix[i]); // sort the Array : e.g. from [2,3,0, 1, 2,3] to [0,1,2,2,3,3]
			for (int j = 1; j <= matrix[0].length; j++) {
				count = Math.max(count, j * matrix[i][matrix[0].length - j]); // cauculate the max
			}
		}

		return count;
	}

}
