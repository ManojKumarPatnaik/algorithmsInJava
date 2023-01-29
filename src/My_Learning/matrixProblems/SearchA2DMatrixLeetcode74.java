package My_Learning.matrixProblems;

public class SearchA2DMatrixLeetcode74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean searchMatrixOptimizedBS(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			int beg = 0;
			int end = matrix[0].length - 1;

			while (beg <= end) {
				int mid = (beg + end) / 2;

				if (matrix[i][mid] == target) {
					return true;
				} else if (matrix[i][mid] > target) {
					end = mid - 1;
				} else {
					beg = mid + 1;
				}
			}
		}
		return false;
	}

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
