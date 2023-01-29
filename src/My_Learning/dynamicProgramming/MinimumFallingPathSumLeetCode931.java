package My_Learning.dynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSumLeetCode931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minFallingPathSum(int[][] matrix) {
		int finalAns = Integer.MAX_VALUE;

		for (int i = 0; i < matrix.length; i++) {
			int tempAns = solve(matrix, 0, i, 0);
			finalAns = Math.min(tempAns, finalAns);
		}

		return finalAns;
	}

	public int solve(int[][] matrix, int row, int col, int tempA) {
		// base case
		// base
		if (col < 0 || col >= matrix[0].length)
			return Integer.MAX_VALUE;
		if (row == matrix.length)
			return tempA;

		int temp1 = solve(matrix, row + 1, col - 1, matrix[row][col] + tempA);
		int temp2 = solve(matrix, row + 1, col, matrix[row][col] + tempA);
		int temp3 = solve(matrix, row + 1, col + 1, matrix[row][col] + tempA);

		return Math.min(temp3, Math.min(temp1, temp2));
	}

	public int minFallingPathSum1(int[][] matrix) {
		for (int i = matrix.length - 2; i >= 0; i--) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] += Math.min(j > 0 ? matrix[i + 1][j - 1] : Integer.MAX_VALUE, Math.min(matrix[i + 1][j],
						j < matrix[0].length - 1 ? matrix[i + 1][j + 1] : Integer.MAX_VALUE));
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < matrix[0].length; i++)
			min = Math.min(min, matrix[0][i]);

		return min;
	}

	public int minFallingPathSum2(int[][] A) {
		for (int i = 1; i < A.length; ++i)
			for (int j = 0; j < A.length; ++j)
				A[i][j] += Math.min(A[i - 1][j],
						Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
		return Arrays.stream(A[A.length - 1]).min().getAsInt();
	}

}
