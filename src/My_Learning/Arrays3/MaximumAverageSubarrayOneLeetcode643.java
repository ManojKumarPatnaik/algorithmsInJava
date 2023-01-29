package My_Learning.Arrays3;

public class MaximumAverageSubarrayOneLeetcode643 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double findMaxAverage(int[] nums, int k) {
		int i = 0, j = 0;
		double max = Integer.MIN_VALUE;
		double sum = 0;
		while (j < nums.length) {
			sum += nums[j];
			if (j - i + 1 == k) {
				double temp = sum / k;
				max = Math.max(temp, max);
				sum -= nums[i];
				i++;
			}
			j++;
		}
		return max;
	}
}
