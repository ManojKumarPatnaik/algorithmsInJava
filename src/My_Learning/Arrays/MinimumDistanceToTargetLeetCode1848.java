package My_Learning.Arrays;

public class MinimumDistanceToTargetLeetCode1848 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMinDistance2(int[] arr, int target, int start) {
		int n = arr.length;

		int ans = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == target) {
				ans = Math.min(ans, Math.abs(i - start));
			}
		}

		return ans;

	}

	public int getMinDistance(int[] nums, int target, int start) {

		if (nums[start] == target)
			return 0;

		int left = start - 1;
		int right = start + 1;

		int n = nums.length;
		while (true) {
			if (left >= 0 && nums[left] == target)
				return start - left;
			if (right < n && nums[right] == target)
				return right - start;
			left -= 1;
			right += 1;
		}
	}

}
