package My_Learning.Arrays;

public class SumBeautyOfArrayLeetCode2012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumOfBeauties(int[] nums) {
		int n = nums.length;
		int minOnRight[] = new int[n];
		minOnRight[n - 1] = nums[n - 1];

		// loop for maintaing values of minimum on the right
		for (int i = n - 2; i >= 2; i--) {
			// minimum is either the number itself or the minimum that is on right of this
			// element we are traversing
			minOnRight[i] = Math.min(minOnRight[i + 1], nums[i]);
		}

		int maxOnLeft = nums[0];
		int ans = 0;
		for (int i = 1; i < n - 1; i++) {
			if (nums[i] > maxOnLeft && nums[i] < minOnRight[i + 1])
				ans += 2;
			else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1])
				ans += 1;
			maxOnLeft = Math.max(nums[i], maxOnLeft);
		}

		return ans;
	}

}
