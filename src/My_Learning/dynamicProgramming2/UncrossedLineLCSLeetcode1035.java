package My_Learning.dynamicProgramming2;

import java.util.Arrays;

public class UncrossedLineLCSLeetcode1035 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int[][] dp;

	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		dp = new int[nums1.length][nums2.length];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return lcs(nums1, nums2, nums1.length - 1, nums2.length - 1);
	}

	private int lcs(int[] arr1, int[] arr2, int i, int j) {
		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int ans;
		if (arr1[i] == arr2[j]) {
			ans = 1 + lcs(arr1, arr2, i - 1, j - 1);
		} else {
			ans = Math.max(lcs(arr1, arr2, i, j - 1), lcs(arr1, arr2, i - 1, j));

		}

		return dp[i][j] = ans;
	}

}
