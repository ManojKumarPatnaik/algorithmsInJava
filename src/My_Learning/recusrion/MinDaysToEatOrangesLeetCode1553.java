package My_Learning.recusrion;

import java.util.HashMap;
import java.util.Map;

public class MinDaysToEatOrangesLeetCode1553 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> dp = new HashMap<>();

	public int minDays(int n) {
		dp.put(0, 0);
		dp.put(1, 1);
		dp.put(2, 2);
		return solve(n);
	}

	private int solve(int n) {
		if (dp.containsKey(n)) {
			return dp.get(n);
		}
		int ans = Integer.MAX_VALUE;
		if (n % 2 == 0 && n % 3 == 0) {
			ans = Math.min(ans, 1 + Math.min(solve(n / 2), solve(n / 3)));
		} else if (n % 3 == 0) {
			ans = Math.min(ans, 1 + Math.min(solve(n - 1), solve(n / 3)));
		} else if (n % 2 == 0) {
			if ((n - 1) % 3 == 0) {
				ans = Math.min(ans, 1 + Math.min(solve(n / 2), solve(n - 1)));
			} else {
				ans = Math.min(ans, Math.min(1 + solve(n / 2), 2 + solve(n - 2)));
			}
		} else {
			ans = Math.min(ans, 1 + solve(n - 1));
			if ((n - 2) % 3 == 0) {
				ans = Math.min(ans, 2 + solve(n - 2));
			}
		}
		dp.put(n, ans);
		return dp.get(n);
	}

}
