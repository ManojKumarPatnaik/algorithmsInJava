package My_Learning.maths;

public class FindTheSmallestDivisorInGivenThresholdLeetcode1283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = (int) 1e6;

		while (left < right) {
			int middle = left + (right - left) / 2;
			if (sumIsLessOrEqual(nums, middle, threshold))
				right = middle;
			else
				left = middle + 1;
		}

		return left;
	}

	private boolean sumIsLessOrEqual(int[] nums, int divisor, int threshold) {
		int sum = 0;
		for (int num : nums) {
			sum += (num + divisor - 1) / divisor;
		}

		return sum <= threshold;
	}

}
