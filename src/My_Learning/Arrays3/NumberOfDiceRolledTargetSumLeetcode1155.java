package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDiceRolledTargetSumLeetcode1155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int MOD = 1000000000 + 7;
	Map<String, Integer> memo = new HashMap<>();

	public int numRollsToTarget(int d, int f, int target) {
		if (d == 0 && target == 0) {
			return 1;
		}
		if (d == 0 || target == 0) {
			return 0;
		}
		String str = d + " " + target;
		if (memo.containsKey(str)) {
			return memo.get(str);
		}
		int res = 0;
		for (int i = 1; i <= f; i++) {
			if (target >= i) {
				res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;
			} else {
				break;
			}
		}
		memo.put(str, res);
		return res;
	}

	// BottomUp
	public int numRollsToTargetDP(int d, int f, int target) {
		int MOD = (int) Math.pow(10, 9) + 7;
		long[][] dp = new long[d + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= d; i++) {
			for (int j = 0; j <= target; j++) {
				for (int k = 1; k <= f; k++) {
					if (j >= k) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
					} else {
						break;
					}
				}
			}
		}
		return (int) dp[d][target];
	}

	// Space Optimized
	int mod = 1_000_000_007;

	public int numRollsToTargetSpaceOptimized(int d, int f, int target) {
		long[] dp = new long[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= d; i++) {
			for (int j = target; j >= 0; j--) {
				dp[j] = 0;
				for (int k = 1; k <= f; k++) {
					if (j >= k) {
						dp[j] = (dp[j] + dp[j - k]) % mod;
					} else {
						break;
					}
				}
			}
		}
		return (int) dp[target];
	}

}
