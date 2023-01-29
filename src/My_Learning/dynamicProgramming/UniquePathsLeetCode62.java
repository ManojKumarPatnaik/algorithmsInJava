package My_Learning.dynamicProgramming;

public class UniquePathsLeetCode62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcode daily solution
	public int uniquePaths(int m, int n) {
		int N = m + n - 2;
		int r = m - 1; // I am taking the RR
		double ans = 1;

		for (int i = 1; i <= r; i++) {
			ans = ans * (N - r + i) / i;
		}

		return (int) ans;
	}
}
