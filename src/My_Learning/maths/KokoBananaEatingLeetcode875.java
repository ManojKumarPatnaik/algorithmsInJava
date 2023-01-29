package My_Learning.maths;

public class KokoBananaEatingLeetcode875 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minEatingSpeed(int[] piles, int h) {
		long end = 0;
		for (int n : piles) {
			if (n > end) {
				end = n;
			}
		}

		long start = 1;
		double ans = end;

		while (start <= end) {
			double count = 0;
			double mid = start + (end - start) / 2;

			for (double num : piles) {
				count += Math.ceil(num / mid);
			}

			if (count > h) {
				start = (long) mid + 1;
			} else {
				end = (long) mid - 1;
				ans = mid;
			}

		}
		return (int) ans;

	}

}
