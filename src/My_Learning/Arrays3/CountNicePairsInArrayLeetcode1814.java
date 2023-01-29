package My_Learning.Arrays3;

import java.util.HashMap;

public class CountNicePairsInArrayLeetcode1814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int MOD = 1000000007;

	public int rev(int n) {
		int r = 0;
		while (n > 0) {
			r = r * 10 + n % 10;
			n = n / 10;
		}
		return r;
	}

	// n1+Rn2=Rn1+n2
	// That means n1-Rn1=n2-Rn2;
	// Hence we will look for N-Rev(N) in 0-(j-1)th range.
	public int countNicePairs(int[] nums) {
		HashMap<Integer, Integer> revMap = new HashMap();
		int cnt = 0;
		for (int j = 0; j < nums.length; j++) {
			int lhs = nums[j] - rev(nums[j]);
			int prevCnt = revMap.getOrDefault(lhs, 0);
			// For this jTh number if we find any entry in map then
			// the current number can create that many new pairs
			// (all those entries are for numbers below jTh index)
			// NOTE : Pairs are for i < j
			cnt += prevCnt;
			// Update count to keep it in mode
			// This is just to pass test cases, we can do at end too.
			// Which is not very clear in description.
			cnt = cnt % MOD;
			// Update counts of numbers with same (N-rev(N)) value so far.
			revMap.put(lhs, prevCnt + 1);
		}

		return cnt;
	}

}
