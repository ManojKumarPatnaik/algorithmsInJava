package My_Learning.dynamicProgramming;

import java.util.Arrays;

public class MaximumThreeProductLeetCode628 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumProduct1(int[] arr) {
		int n = arr.length;

		if (n < 3)
			return 0;

		// int windowSize = 3;
		int ans = 0;
		int currentWindowAns = arr[0] * arr[1] * arr[2];
		ans = currentWindowAns;

		for (int i = 3; i < n - 1; i++) {
			int curr = arr[i];
			if (curr == 0) {
				currentWindowAns = 0;
			}

			currentWindowAns = (currentWindowAns / arr[i - 3]) * curr;

			ans = Math.max(ans, currentWindowAns);
		}

		return ans;
	}

	public int maximumProduct2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
	}

// Maximum product of three numbers is possible only when all three
	// numbers are positive or two numbers are negative and one is positive.
	public int maximumProduct3(int[] nums) {
		int min1, min2, max1, max2, max3;
		min1 = min2 = Integer.MAX_VALUE;
		max1 = max2 = max3 = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// Updating maximums
			if (max1 < nums[i]) {
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			} else if (max2 < nums[i]) {
				max3 = max2;
				max2 = nums[i];
			} else if (max3 < nums[i]) {
				max3 = nums[i];
			}

			// Updating minimums
			if (min1 > nums[i]) {
				min2 = min1;
				min1 = nums[i];
			} else if (min2 > nums[i]) {
				min2 = nums[i];
			}

		}

		return Math.max(max1 * max2 * max3, min1 * min2 * max1);
	}

}
