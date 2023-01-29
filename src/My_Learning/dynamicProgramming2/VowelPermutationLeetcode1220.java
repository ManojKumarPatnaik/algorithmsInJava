package My_Learning.dynamicProgramming2;

public class VowelPermutationLeetcode1220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countVowelPermutation(int n) {
		int MOD = 1000_000_007;

		long[][] dp = new long[n + 1][5]; // dp[i][j] := a string of length 'i' ends with a vowel represented by index
											// 'j'

		// vowel & index mapping
		// a: 0
		// e: 1
		// i: 2
		// o: 3
		// u: 4

		// Initialize dp
		// 'a': dp[1][0] = 1
		// 'e': dp[1][1] = 1
		// 'i': dp[1][2] = 1
		// 'o': dp[1][3] = 1
		// 'u': dp[1][4] = 1
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}

		// Each vowel 'a' may only be followed by an 'e'.
		// Each vowel 'e' may only be followed by an 'a' or an 'i'.
		// Each vowel 'i' may not be followed by another 'i'.
		// Each vowel 'o' may only be followed by an 'i' or a 'u'.
		// Each vowel 'u' may only be followed by an 'a'.
		// === In other words:
		// 'a' can be followed by {'e'}
		// 'e' can be followed by {'a', 'i'}
		// 'i' can be followed by {'a', 'e', 'o', 'u'}
		// 'o' can be followed by {'i', 'u'}
		// 'u' can be followed by {'a'}
		// === In other words:
		// 'a' can follow {'e', 'i', 'u'}
		// 'e' can follow {'a', 'i'}
		// 'i' can follow {'e', 'o'}
		// 'o' can follow {'i'}
		// 'u' can follow {'i', 'o'}

		// State transition
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD; // 'a' can follow {'e', 'i', 'u'}
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; // 'e' can follow {'a', 'i'}
			dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD; // 'i' can follow {'e', 'o'}
			dp[i][3] = (dp[i - 1][2]) % MOD; // 'o' can follow {'i'}
			dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; // 'u' can follow {'i', 'o'}
		}

		long count = 0;

		for (long d : dp[n]) {
			count += d;
			count %= MOD;
		}

		return (int) count;
	}
}
