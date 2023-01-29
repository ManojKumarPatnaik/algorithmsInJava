package My_Learning.bitManipulation;

public class ConcatenationOfBinaryNumberLeetcode1680 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int concatenatedBinary(int n) {
		int MOD = 1_000_000_007;
		long sum = 0;
		for (int i = 1; i <= n; i++)
			sum = (sum * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % MOD;
		// sum = ((sum << Integer.toBinaryString(i).length()) + i) % MOD;

		return (int) sum;
	}

}
