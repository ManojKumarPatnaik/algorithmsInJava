package My_Learning.Arrays3;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame4Leetcode1871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Daily Leetcode solution
	public boolean canReach(String s, int min, int max) {
		if (s.charAt(s.length() - 1) == '1')
			return false;

		boolean[] dp = new boolean[s.length()];
		dp[dp.length - 1] = true;
		Queue<Integer> q = new LinkedList<>();
		for (int i = dp.length - 2; i >= 0; i--) {
			// remove the peek element if out of range
			if (!q.isEmpty() && q.peek() > i + max)
				q.remove();

			// add the new element in range to q if applicable
			if (i + min < s.length() && dp[i + min])
				q.add(i + min);

			// if q not empty, update dp table
			if (!q.isEmpty() && s.charAt(i) == '0')
				dp[i] = true;
		}

		return dp[0];
	}

}
