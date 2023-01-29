package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumHeightbyStackingCuboidsLeetcode1691 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxHeight(int[][] cuboids) {
		for (int[] cube : cuboids)
			Arrays.sort(cube);
		Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
		int N = cuboids.length, res = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = cuboids[i][2];
			res = Math.max(res, dp[i]);
		}
		for (int i = 1; i < N; i++)
			for (int j = 0; j < i; j++)
				if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1]
						&& cuboids[j][2] <= cuboids[i][2]) {
					dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
					res = Math.max(res, dp[i]);
				}
		return res;
	}

}
