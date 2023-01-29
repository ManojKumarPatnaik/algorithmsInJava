package My_Learning.dynamicProgramming2;

public class ArithmaticSlicesLeetcode413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfArithmeticSlices(int[] A) {
		int n = A.length;
		if (n < 3) {
			return 0;
		}
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = 0;
		int sum = 0;
		for (int i = 2; i < n; i++) {
			if ((A[i] - A[i - 1]) == (A[i - 1] - A[i - 2])) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 0;
			}
			sum += dp[i];
		}
		return sum;
	}

}
