package My_Learning.Arrays3;

public class MaximumSubarrayAscendingSumLeetcode1800 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxAscendingSum(int[] nums) {
		int res = nums[0], temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				temp += nums[i];
			else
				temp = nums[i];
			res = Math.max(res, temp);
		}
		return res;
	}

}
