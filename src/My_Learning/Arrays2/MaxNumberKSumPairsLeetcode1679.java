package My_Learning.Arrays2;

import java.util.Arrays;

public class MaxNumberKSumPairsLeetcode1679 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int counter = 0;
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == k) {
				counter++;
				i++;
				j--;
			} else if (nums[i] + nums[j] > k) {
				j--;
			} else
				i++;
		}

		return counter;

	}

}
