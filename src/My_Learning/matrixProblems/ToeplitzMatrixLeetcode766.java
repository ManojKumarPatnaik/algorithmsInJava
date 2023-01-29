package My_Learning.matrixProblems;

public class ToeplitzMatrixLeetcode766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to check toeplitz matrix
	// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
	// same elements.
	public boolean isToeplitzMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				if (matrix[i][j] != matrix[i - 1][j - 1])
					return false;
		return true;
	}

}
