package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumEarningsFromTaxiLeetcode2008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long maxTaxiEarnings(int n, int[][] rides) {
		Arrays.sort(rides, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		int m = rides.length;
		long[] dp = new long[m + 1];
		for (int idx = m - 1; idx >= 0; idx--) {
			int[] curRide = rides[idx];
			int nextAvailableRide = findNextAvailableRideBS(rides, idx, curRide[1]);
			long include = curRide[1] - curRide[0] + curRide[2] + dp[nextAvailableRide];
			long exclude = dp[idx + 1];
			dp[idx] = Math.max(include, exclude);
		}
		return dp[0];
	}

	private int findNextAvailableRideBS(int[][] rides, int lo, int preEnd) {
		int hi = rides.length;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (rides[mid][0] < preEnd)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

}
