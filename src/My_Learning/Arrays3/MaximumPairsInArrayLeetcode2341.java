package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumPairsInArrayLeetcode2341 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] numberOfPairs(int[] nums) {
		Arrays.sort(nums);// First sorting the array so that all the duplicates come together
		int pairs = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {// Now checking for the duplicate and if we have found one then
													// changing their values out of the range of nums[i] so that they
													// cannot be used again for pairing
				nums[i] = -1;
				nums[i - 1] = -1;
				pairs++;// Increasing the pair count
			}
		}
		// Now we have to return the pairs and the remaining numbers in the array
		return new int[] { pairs, nums.length - (2 * pairs) };
	}

}
