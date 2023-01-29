package My_Learning.maths;

public class NumberOfDigitOneLeetcode233 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		return ones;
	}

}
