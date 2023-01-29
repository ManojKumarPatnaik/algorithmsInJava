package My_Learning.Arrays3;

import java.util.Arrays;

public class MinLimitBallsInBagLeetcode1760 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumSize(int[] nums, int maxOperations) {
		Arrays.sort(nums);
		int len = nums.length;

		int low = 1, high = nums[len - 1];
		while (low < high) {
			int mid = (low + high) / 2;
			if (valid(nums, mid, maxOperations)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private boolean valid(int[] nums, int target, int maxOperations) {
		for (int i = nums.length - 1; i >= 0; --i) {
			int num = nums[i];
			if (num <= target)
				break;
			maxOperations -= (num + target - 1) / target - 1;
			if (maxOperations < 0)
				return false;
		}
		return true;
	}

}
