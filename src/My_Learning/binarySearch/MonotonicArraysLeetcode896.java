package My_Learning.binarySearch;

public class MonotonicArraysLeetcode896 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMonotonic(int[] nums) {
		int max = nums[0], n = nums.length;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, nums[i]);
		}
		if (max == nums[0]) {
			for (int i = 1; i < n - 1; i++) {
				if (nums[i] < nums[i + 1]) {
					return false;
				}
			}
		} else if (max == nums[n - 1]) {
			for (int i = 0; i < n - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
