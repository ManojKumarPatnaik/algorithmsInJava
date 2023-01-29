package My_Learning.Arrays3;

public class RunningSum1DArrayLeetcode1480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] runningSum(int[] nums) {
		int[] ans = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				ans[i] = nums[i];
				continue;
			}

			ans[i] = nums[i] + ans[i - 1];
		}

		return ans;
	}

}
