package My_Learning.Arrays;

public class SubtractSumProductLeetcode1281 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int subtractProductAndSum(int n) {
		return getDigitValue(n);
	}

	public int getDigitValue(int n) {
		int product = 1;
		int sum = 0;
		while (n != 0) {
			sum = sum + n % 10;
			product = product * (n % 10);

			n = n / 10;
		}

		return product - sum;
	}

}
