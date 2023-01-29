package My_Learning.matrixProblems;

public class CheckMatrixObtainedLeetcode1886 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean findRotation(int[][] mat, int[][] target) {
		if (same(mat, target))
			return true;

		for (int i = 0; i < 4; i++) {
			if (same(mat, target))
				return true;
			else
				rotate(mat);
		}
		return false;
	}

	public boolean same(int mat[][], int target[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] != target[i][j])
					return false;
			}
		}
		return true;
	}

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			swap(matrix[i]);
		}
	}

	public void swap(int arr[]) {
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

}
