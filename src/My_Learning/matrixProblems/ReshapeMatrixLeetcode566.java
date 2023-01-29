package My_Learning.matrixProblems;

public class ReshapeMatrixLeetcode566 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// We can use matrix[index / width][index % width] for both the input and the
	// output matrix.
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int m = nums.length, n = nums[0].length;
		if (r * c != m * n)
			return nums;
		int[][] reshaped = new int[r][c];
		for (int i = 0; i < r * c; i++)
			reshaped[i / c][i % c] = nums[i / n][i % n];
		return reshaped;
	}

}
