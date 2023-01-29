package My_Learning.matrixProblems;

public class DiagonalSumLeetcode1572 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int diagonalSum(int[][] mat) {
		int n = mat[0].length - 1;
		int sum = 0;
		for (int row = 0; row < mat.length; row++) {

			if (row != (n - row))
				sum += mat[row][row] + mat[row][n - row];
			else
				sum += mat[row][row];

		}

		return sum;
	}
}
