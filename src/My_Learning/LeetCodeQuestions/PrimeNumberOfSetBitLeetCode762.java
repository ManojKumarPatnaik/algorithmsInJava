package My_Learning.LeetCodeQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberOfSetBitLeetCode762 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countPrimeSetBits(int l, int r) {
		Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /* , 23, 29 */ ));
		int cnt = 0;
		for (int i = l; i <= r; i++) {
			int bits = 0;
			for (int n = i; n > 0; n >>= 1)
				bits += n & 1;
			cnt += primes.contains(bits) ? 1 : 0;
		}
		return cnt;

	}

	public int countSetBit(int n) {
		int setBit = 0;

		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1)
				setBit++;
			n = n >> 1;
		}

		return setBit;
	}

}
