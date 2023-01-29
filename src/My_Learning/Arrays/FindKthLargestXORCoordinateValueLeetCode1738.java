package My_Learning.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKthLargestXORCoordinateValueLeetCode1738 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Quick Select algorithm
	public int kthLargestValue(int[][] matrix, int k) {

		// This is basic checking done for the matrix.
		int m = matrix.length;
		if (m == 0)
			return -1;
		int n = matrix[0].length;
		if (n == 0)
			return -1;

		// This is the dp matrix which will contain all the xor values
		int[][] dp = new int[m][n];
		// We use this list to keep all the integers
		List<Integer> list = new ArrayList<>();

		// This is the base case . THe first element at (0,0) index doesnot have any
		// other values to xor with. We add that element to the list
		dp[0][0] = matrix[0][0];
		list.add(dp[0][0]);

		// This is for the first column. Our required value is the
		// dp[i-1][0]^matrix[i][0]. We do this for the whole first column
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
			list.add(dp[i][0]);
		}
		// This is for the first row. Our required value is the dp[0][i-1]^matrix[0][i].
		// We do this for the whole first row

		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] ^ matrix[0][i];
			list.add(dp[0][i]);
		}

		// For all the other elements the xor value would be
		// dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i][j].We add the elements to the
		// list.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
				list.add(dp[i][j]);
			}
		}

		// AS we need the Kth largest element , as we have sorted it in increasing order
		// the kth largest element will be m*n-k th element in the ascending order
		Collections.sort(list);

		return list.get(m * n - k);

	}

}
