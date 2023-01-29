package My_Learning.strings;

public class CheckIfOriginalStringExistsInEncodedSLeetcode2060 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Boolean[][][] dp;

	boolean dfs(int i, int j, int diff, String s1, String s2) {
		if (i >= s1.length() && j >= s2.length() && diff == 0)
			return true;
		// diff > 0, j > i
		// diff < 0, i > j
		// System.out.println(" == " + diff + " " + (diff+1000) + " " + dp[i][j][diff +
		// 1000]);

		if (dp[i][j][diff + 1000] != null) {
			return dp[i][j][diff + 1000];
		}

		boolean res = false;
		if (i < s1.length()) {
			if (Character.isDigit(s1.charAt(i))) {
				int value = 0, count = 0;
				while (i + count < s1.length() && count < 3 && Character.isDigit(s1.charAt(i + count))) {
					value = value * 10 + (s1.charAt(i + count) - '0');
					count++;
					if (dfs(i + count, j, diff - value, s1, s2))
						res = true;
				}
			} else {
				if (diff > 0) {
					if (dfs(i + 1, j, diff - 1, s1, s2))
						res = true;
				} else if (diff == 0 && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
					if (dfs(i + 1, j + 1, diff, s1, s2))
						res = true;
				}
			}
		}

		if (j < s2.length()) {
			if (Character.isDigit(s2.charAt(j))) {
				int value = 0, count = 0;
				while (j + count < s2.length() && count < 3 && Character.isDigit(s2.charAt(j + count))) {
					value = value * 10 + (s2.charAt(j + count) - '0');
					count++;
					if (dfs(i, j + count, diff + value, s1, s2))
						res = true;
				}
			} else {
				if (diff < 0) {
					if (dfs(i, j + 1, diff + 1, s1, s2))
						res = true;
				}
			}
		}

		return dp[i][j][diff + 1000] = res;
	}

	public boolean possiblyEquals(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		dp = new Boolean[m + 1][n + 1][2001];
		return dfs(0, 0, 0, s1, s2);
	}

}
