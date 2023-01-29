package My_Learning.recusrion;

public class PalindromePartititonTwoLeetCode132 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCut(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int[] cut = new int[n];
		boolean[][] pal = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[n - 1];
	}
	
	// method-2 explained
	public int minCut2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        boolean[][] dp = buildMatrix(s, n);
        int[] totalCuts = new int[n];

        for (int j = 0; j < n; j++) {
            int cut = j;
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    cut = Math.min(cut, i == 0 ? 0 : totalCuts[i - 1] + 1);
                }
            }
            totalCuts[j] = cut;
        }

        return totalCuts[n - 1];
    }

    boolean[][] buildMatrix(String s, int n) {
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp;
    }
}
