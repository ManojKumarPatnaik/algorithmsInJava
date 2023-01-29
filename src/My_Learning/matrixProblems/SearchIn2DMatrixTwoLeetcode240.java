package My_Learning.matrixProblems;

public class SearchIn2DMatrixTwoLeetcode240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public boolean searchMatrix(int[][] matrix, int target) {
		// Starting from last element of first row (can also start from first element of
		// last row).
		int i = 0;
		int j = matrix[0].length - 1;

		while (j >= 0 && i < matrix.length) {
			if (matrix[i][j] < target) {
				i++;
			} else if (matrix[i][j] > target) {
				j--;
			}
			// Found the element, return true.
			else {
				return true;
			}
		}

		// Element not found, return false.
		return false;
	}

}
