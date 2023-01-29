package My_Learning.Arrays;

import java.util.Arrays;

public class MaximumPairsChainLengthLeetcode646 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLongestChain22(int[][] pairs) {
		int finalAns = Integer.MIN_VALUE;
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		for (int i = 0; i < pairs.length; i++) {
			int count = 1;
			for (int j = i; j < pairs.length; j++) {
				if (pairs[j][0] > pairs[i][1])
					count++;
			}
			finalAns = Math.max(count, finalAns);
		}

		return finalAns;
	}

	public int findLongestChainDP(int[][] pairs) {
		if (pairs == null || pairs.length == 0)
			return 0;
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		int[] dp = new int[pairs.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
			}
		}
		return dp[pairs.length - 1];
	}

	public int findLongestChain(int[][] pairs) {
		if (pairs.length == 0)
			return 0;
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		int pre = pairs[0][1];
		int count = 1;
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i][0] > pre) {
				count++;
				pre = pairs[i][1];
			}
		}
		return count;
	}

}
