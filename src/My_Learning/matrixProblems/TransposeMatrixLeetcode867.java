package My_Learning.matrixProblems;

public class TransposeMatrixLeetcode867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] transpose(int[][] A) {
		if (A.length == A[0].length) {
			inPlace(A);
			return A;
		}
		int[][] B = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				B[j][i] = A[i][j];
			}
		}
		return B;
	}

	private void inPlace(int[][] A) {
		int col = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = col; j < A[0].length; j++) {
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
			col++;
		}
	}

}
