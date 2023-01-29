package My_Learning.Arrays;

import java.util.Arrays;

public class MissingNumberLeetCode268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Example 1:
	 * 
	 * Input: nums = [3,0,1] Output: 2 Explanation: n = 3 since there are 3 numbers,
	 * so all numbers are in the range [0,3]. 2 is the missing number in the range
	 * since it does not appear in nums. Example 2:
	 * 
	 * Input: nums = [0,1] Output: 2 Explanation: n = 2 since there are 2 numbers,
	 * so all numbers are in the range [0,2]. 2 is the missing number in the range
	 * since it does not appear in nums.
	 */
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);

		int mask = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((mask ^ nums[i]) != 0)
				return mask;
			mask++;
		}

		return mask;
	}

	/*
	 * //FOllowUp the input array is sorted and find the missing number. Below is
	 * the version using binary search. The idea is to find the first number such
	 * that index != nums[index]
	 * 
	 */	public int missingNumberFollowUp(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

}
