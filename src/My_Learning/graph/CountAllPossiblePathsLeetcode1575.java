package My_Learning.graph;

import java.util.Arrays;

public class CountAllPossiblePathsLeetcode1575 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long mod = 1000000007;
	long[][] dp;

	public long dfs(int[] lo, int s, int e, int f, int n) {
		if (f < 0)
			return 0;
		if (dp[s][f] != -1)
			return dp[s][f];
		long ans = 0;
		if (s == e)
			ans += 1;
		for (int i = 0; i < n; i++)
			if (i != s)
				ans += dfs(lo, i, e, f - (Math.abs(lo[i] - lo[s])), n) % mod;
		return dp[s][f] = ans % mod;
	}

	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		dp = new long[locations.length + 1][fuel + 1];
		for (int i = 0; i < locations.length; i++)
			Arrays.fill(dp[i], -1);
		return (int) dfs(locations, start, finish, fuel, locations.length);
	}
}
