package My_Learning.Arrays3;

public class FibonnaciNumberLeetcode509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int fib(int N) {
		int[] dp = new int[3];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		if (N <= 2)
			return dp[N];

		for (int i = 3; i <= N; i++) {
			dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
		}

		return dp[N % 3];
	}

}
