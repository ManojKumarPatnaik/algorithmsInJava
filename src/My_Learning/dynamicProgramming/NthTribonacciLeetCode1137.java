package My_Learning.dynamicProgramming;

public class NthTribonacciLeetCode1137 {

//	The Tribonacci sequence Tn is defined as follows: 
//
//		T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//		Given n, return the value of Tn.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(tribonacci(25));
	}

	public static int tribonacci(int n) {
		int[] arr = new int[n + 1];

		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;

		if (n >= 0 && n <= 2)
			return arr[n];

		return generateTribo(n, arr);
	}

	public static int generateTribo(int n, int[] arr) {

		if (n == 0 || n == 1 || n == 2)
			return arr[n];

		// DP since overlapping subproblems occur
		// draw recursion tree will get to know
		if (arr[n] != 0)
			return arr[n];

		arr[n] = generateTribo(n - 1, arr) + generateTribo(n - 2, arr) + generateTribo(n - 3, arr);

		return arr[n];
	}
	
	//method - 2
	//d = a+ b+ c
	public int tribonacciIterative(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
	
	//DP efficient method
	public int tribonacciDP(int n) {
        int dp[] = {0, 1, 1};
        for (int i = 3; i <= n; ++i)
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        return dp[n % 3];
    }
}
