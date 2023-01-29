package My_Learning.Arrays3;

public class MinWaysTOMakeArrIncreasingLeetcode1827 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minOperations(int[] nums) {
		int c = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= nums[i - 1]) {
				c += nums[i - 1] - nums[i] + 1;
				nums[i] = nums[i - 1] + 1;
			}
		}

		return c;
	}
}
