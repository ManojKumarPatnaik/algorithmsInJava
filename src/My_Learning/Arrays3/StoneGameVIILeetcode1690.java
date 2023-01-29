package My_Learning.Arrays3;

public class StoneGameVIILeetcode1690 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int stoneGameVII(int[] stones) {
		int n = stones.length, prefix[] = new int[n], dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			prefix[i] = stones[i] + (i > 0 ? prefix[i - 1] : 0);
		}

		for (int i = 0; i < n - 1; i++) {
			dp[i] = Math.max(stones[i], stones[i + 1]);
		}

		for (int l = 2; l < n; l++) {
			// length of current stone array = l + 1
			for (int i = 0; i < n - l; i++) {
				dp[i] = Math.max(prefix[i + l - 1] - (i > 0 ? prefix[i - 1] : 0) - dp[i], // sum(i, i + l - 1)
						prefix[i + l] - prefix[i] - dp[i + 1]);
			}
		}

		return dp[0];
	}

}
