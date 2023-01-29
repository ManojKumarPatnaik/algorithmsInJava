package My_Learning.maths;

import java.util.Arrays;

public class AllocatesMailBoxLeetcode1478 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is used for dp calculatio mnmemory
	private static Integer[][][] memo;
	private int[] houses;
	private int k;
	// This is for sum calculation memory
	private static Integer[][] sum;

	public int minDistance(int[] houses, int k) {
		Arrays.sort(houses);
		memo = new Integer[houses.length][houses.length][k + 1];
		sum = new Integer[houses.length][houses.length];
		this.houses = houses;
		this.k = k;
		return dp(0, houses.length - 1, k);
	}

	private int dp(int start, int end, int k) {
		// BASE CASE: This means we will build a mail box right at the house, then the
		// cost for that house is 0.
		if (start == end)
			return 0;
		if (memo[start][end][k] != null)
			return memo[start][end][k];
		int cur = Integer.MAX_VALUE;
		if (k > 1) {
			// From current house, we try all the posibilties for the next mail box and
			// choose the least cost one.
			for (int i = start; i < end; i++) {
				// The cost for next mail box has two components.
				// First, from start to ith mail box. This part is straight forward just use the
				// median to calculate the cost.
				// Second, the cost after this mail box. This part we use recursion to
				// calculate. If we build a mail box at i,
				// then only k - 1 mail box left for the houses after i. So it equals to dp(i +
				// 1, k - 1).
				cur = Math.min(cur, findSum(start, i) + dp(i + 1, end, k - 1));
			}
		} else {
			// If k == 1, then that means we can not build any more mail box, then we just
			// use helper function to find the cost.
			cur = findSum(start, end);
		}
		memo[start][end][k] = cur;
		return memo[start][end][k];
	}

	// There is trick here: the MEDIAN point at the least distance sum to all the
	// others points in the line.
	// Using this information we can use a for loop to calculate the least
	// distance.Also we use a int matrix to avoid repeated calculation.
	private int findSum(int start, int end) {
		if (sum[start][end] != null) {
			return sum[start][end];
		}
		int medium = start + (end - start) / 2;
		int result = 0;
		for (int i = start; i <= end; i++) {
			result += Math.abs(houses[i] - houses[medium]);
		}
		sum[start][end] = result;
		return sum[start][end];
	}

}
