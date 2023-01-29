package My_Learning.bitManipulation;

public class MinimumOneBitOperationsToMakeIntegerLeetcode1611 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumOneBitOperations(int n) {
		if (n == 0)
			return 0;
		int b = 1;
		while ((b << 1) <= n)
			b = b << 1;
		return minimumOneBitOperations(n ^ b ^ (b >> 1)) + 1 + (b - 1);
	}

}
