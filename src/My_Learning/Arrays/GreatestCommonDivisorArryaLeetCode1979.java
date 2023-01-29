package My_Learning.Arrays;

public class GreatestCommonDivisorArryaLeetCode1979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findGCD(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int n : nums) {
			min = Math.min(min, n);
			max = Math.max(max, n);
		}

		return getGCD(min, max);

	}

	public int getGCD(int m, int n) {
		if (m == 0)
			return n;

		return getGCD(n % m, m);
	}

}
