package My_Learning.LeetCodeQuestions;

public class FibbonaciNumbersLeetCode509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Solution 1: Iterative
	 * 
	 * Time complexity: O(n) Space complexity: O(1)
	 */

	public int fib(int N) {
		if (N <= 1)
			return N;

		int a = 0, b = 1;

		while (N-- > 1) {
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}

	/*
	 * Solution 2: Recursive
	 * 
	 * Time complexity: O(2^n)- since T(n) = T(n-1) + T(n-2)is an exponential time
	 * Space complexity: O(n) - space for recursive function call stack
	 */

//	class Solution {
//		public int fib(int N) {
//			if (N <= 1)
//				return N;
//			else
//				return fib(N - 1) + fib(N - 2);
//		}
//	}

	/*
	 * Solution 3: Dynamic Programming - Top Down Approach
	 * 
	 * Time complexity: O(n) Space complexity: O(n)
	 */

//	class Solution {
//		int[] fib_cache = new int[31];
//
//		public int fib(int N) {
//			if (N <= 1)
//				return N;
//			else if (fib_cache[N] != 0)
//				return fib_cache[N];
//			else
//				return fib_cache[N] = fib(N - 1) + fib(N - 2);
//		}
//	}
	/*
	 * Solution 4: Dynamic Programming - Bottom Up Approach
	 * 
	 * Time complexity: O(n) Space complexity: O(n)
	 */

	public int fibN(int N) {
		if (N <= 1)
			return N;

		int[] fib_cache = new int[N + 1];
		fib_cache[1] = 1;

		for (int i = 2; i <= N; i++) {
			fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
		}
		return fib_cache[N];
	}

}
