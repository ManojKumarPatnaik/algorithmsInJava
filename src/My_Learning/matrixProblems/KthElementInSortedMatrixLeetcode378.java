package My_Learning.matrixProblems;

import java.util.Arrays;

public class KthElementInSortedMatrixLeetcode378 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(int[][] matrix, int k) {
		// The approach is make a 1D array and sort it and find the required smallest
		// array
		int[] arr = new int[matrix.length * matrix[0].length];
		int p = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				arr[p] = matrix[i][j];
				p++;
			}
		}
		Arrays.sort(arr);
		return arr[k - 1];// because indexing starts from 0 we decrease k by 1
	}

}
