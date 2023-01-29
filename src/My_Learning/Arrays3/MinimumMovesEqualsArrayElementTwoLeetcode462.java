package My_Learning.Arrays3;

import java.util.Arrays;

public class MinimumMovesEqualsArrayElementTwoLeetcode462 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		int count = 0;
		while (i < j) {
			count += nums[j] - nums[i];
			i++;
			j--;
		}
		return count;
	}

}
