package My_Learning.Arrays;

public class SingleNumberLeetCode136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Example 1:
	 * 
	 * Input: nums = [2,2,1] Output: 1 Example 2:
	 * 
	 * Input: nums = [4,1,2,1,2] Output: 4
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}

}
