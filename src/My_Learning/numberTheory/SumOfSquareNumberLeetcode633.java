package My_Learning.numberTheory;

public class SumOfSquareNumberLeetcode633 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean judgeSquareSum(int c) {
		long l = 0;
		long r = (long) Math.sqrt(c);
		while (l <= r) {
			long sum = (l * l) + (r * r);
			if (sum > c) {
				r--;
			} else if (sum < c) {
				l++;
			} else {
				return true;
			}
		}
		return false;
	}
}
