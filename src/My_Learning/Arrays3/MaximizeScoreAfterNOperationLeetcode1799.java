package My_Learning.Arrays3;

public class MaximizeScoreAfterNOperationLeetcode1799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxScore(int[] nums) {
		int n = nums.length;
		Integer[] memo = new Integer[1 << n];
		return helper(1, 0, nums, memo);
	}

	private int helper(int operationNumber, int mask, int[] nums, Integer[] memo) {
		int n = nums.length;
		if (memo[mask] != null) {
			return memo[mask];
		}
		if (operationNumber > n / 2) {
			return 0;
		}

		int maxScore = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0) {
				for (int j = i + 1; j < n; j++) {
					if ((mask & (1 << j)) == 0) {
						int score = operationNumber * gcd(nums[i], nums[j]);
						maxScore = Math.max(maxScore,
								score + helper(operationNumber + 1, mask | (1 << i) | (1 << j), nums, memo));
					}
				}
			}
		}
		return memo[mask] = maxScore;
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}
