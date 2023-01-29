package My_Learning.dynamicProgramming;

public class ArithmaticSlices413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	We can find another sub problem: assume dp[i] is the number of arithmetic slices which are end with A[i]. then we have:
//		dp[i]=(A[i]-A[i-1] = = A[i-1]-A[i-2])? 1+dp[i-1] : 0, the code:
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

	// O(n) + O(1)
	public int numberOfArithmeticSlicesIterative(int[] A) {
		int curr = 0, sum = 0;
		for (int i=2; i<A.length; i++)
			if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
				curr += 1;
				sum += curr;
			} else {
				curr = 0;
			}
		return sum;
	}
}
