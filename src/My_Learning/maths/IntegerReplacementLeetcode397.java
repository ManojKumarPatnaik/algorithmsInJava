package My_Learning.maths;

import java.util.HashMap;

public class IntegerReplacementLeetcode397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int integerReplacement(int n) {
		return minOperations((long) n, new HashMap<>());
	}

	private int minOperations(long n, HashMap<Long, Integer> dp) {
		if (n == 1)
			return 0;
		if (n < 1)
			return Integer.MAX_VALUE;
		if (dp.containsKey(n))
			return dp.get(n);

		int curr = 0;
		if (n % 2 == 0) {
			curr = 1 + minOperations(n / 2, dp);
		} else {
			curr = 1 + Math.min(minOperations(n + 1, dp), minOperations(n - 1, dp));
		}
		dp.put(n, curr);
		return curr;
	}

}
