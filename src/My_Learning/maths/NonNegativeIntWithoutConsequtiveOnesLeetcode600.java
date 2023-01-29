package My_Learning.maths;

import java.util.ArrayList;
import java.util.Collections;

public class NonNegativeIntWithoutConsequtiveOnesLeetcode600 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Integer dp[][][];

	public int findIntegers(int num) {
		ArrayList<Integer> dig = digits(num);
		dp = new Integer[64][2][2];
		return solve(dig, 0, 0, 0);
	}

	public int solve(ArrayList<Integer> dig, int pos, int tight, int prev) {
		if (pos == dig.size())
			return 1;
		if (dp[pos][tight][prev] != null)
			return dp[pos][tight][prev];
		int limit = 1, total = 0;
		if (tight == 0)
			limit = dig.get(pos);
		for (int i = 0; i <= limit; i++) {
			int newTight = tight;
			if (i < limit)
				newTight = 1;
			if (prev == 1 && i == 1)
				continue;
			total += solve(dig, pos + 1, newTight, i);
		}
		return dp[pos][tight][prev] = total;
	}

	public ArrayList<Integer> digits(int n) {
		ArrayList<Integer> a = new ArrayList<>();
		while (n > 0) {
			a.add(n % 2);
			n /= 2;
		}
		Collections.reverse(a);
		return a;
	}

}
