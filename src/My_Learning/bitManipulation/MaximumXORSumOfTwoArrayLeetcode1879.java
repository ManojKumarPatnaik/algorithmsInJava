package My_Learning.bitManipulation;

public class MaximumXORSumOfTwoArrayLeetcode1879 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] dp;

	public int help(int i, int mask, int[] num1, int[] num2) {
		if (i == num1.length)
			return 0;
		int ans = Integer.MAX_VALUE;
		if (dp[i][mask] != -1) {
			return dp[i][mask];
		}

		for (int j = 0; j < num2.length; j++) {
			if ((mask & (1 << j)) == 0) {
				ans = Math.min(ans, (num1[i] ^ num2[j]) + help(i + 1, (mask | (1 << j)), num1, num2));
			}
		}

		dp[i][mask] = ans;
		return ans;
	}

	public int minimumXORSum(int[] nums1, int[] nums2) {
		dp = new int[14][20000];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return help(0, 0, nums1, nums2);
	}

}
