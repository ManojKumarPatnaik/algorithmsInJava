package My_Learning.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class PowerOfTwoLeetcode231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Bit magic
	public boolean isPowerOfTwo(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}

	// Iterative
	public boolean isPowerOfTwoIterative(int n) {
		if (n <= 0)
			return false;
		while (n % 2 == 0)
			n /= 2;
		return n == 1;
	}

	// Recursive
	public boolean isPowerOfTwoRecursive(int n) {
		return n > 0 && (n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2)));
	}

	// Bit count
	public boolean isPowerOfTwoBitCount(int n) {
		return n > 0 && Integer.bitCount(n) == 1; // bitcount==1 in even number
	}

	// Lookup method
	public boolean isPowerOfTwoLookUp(int n) {
		// There are only 31 numbers in total for an 32-bit integer.
		return new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
				65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,
				134217728, 268435456, 536870912, 1073741824)).contains(n);

	}

}
