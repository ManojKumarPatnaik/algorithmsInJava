package My_Learning.strings;

import java.util.Arrays;

public class CountNumberOfTextsLeetcode2266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int mod = (1000000007);

	public int countTexts(String pressedKeys) {
		int[] key = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
		int n = pressedKeys.length();
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return solve(0, pressedKeys, key, dp);
	}

	public int solve(int ind, String s, int[] key, int[] dp) {
		if (ind == s.length()) {
			return 1;
		}
		if (dp[ind] != -1)
			return dp[ind];
		int count = 0;
		int num = s.charAt(ind) - '0';
		int rep = key[num];
		for (int i = 0; i < rep && ind + i < s.length() && s.charAt(ind) == s.charAt(ind + i); i++) {
			count += solve(ind + 1 + i, s, key, dp);
			count %= mod;
		}
		return dp[ind] = count;
	}

}
