package My_Learning.binarySearch;

import java.util.Arrays;

public class NumberOfSubsequenceSatisfiestheConditionLeetcode1498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSubseq(int[] nums, int target) {
		Arrays.sort(nums); // Sorting so that we can get the min and max directly
		int i = 0, j = nums.length - 1, count = 0, mod = (int) 1e9 + 7;
		int[] power = new int[nums.length]; // Calculating the power in the power array.
		power[0] = 1; // no. of subsequences formed using one no. is 1
		for (int idx = 1; idx < nums.length; idx++)
			power[idx] = (power[idx - 1] * 2) % mod;

		while (i <= j) {
			if (nums[i] + nums[j] <= target) {
				count = (count + power[j - i]) % mod;
				i++;
			} else if (nums[i] + nums[j] > target)
				j--;
		}
		return count;
	}	

}
