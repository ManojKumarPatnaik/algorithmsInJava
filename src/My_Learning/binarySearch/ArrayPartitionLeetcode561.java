package My_Learning.binarySearch;

import java.util.Arrays;

public class ArrayPartitionLeetcode561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayPairSumNormal(int[] nums) {
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0; i < nums.length; i = i + 2) {
			ans += nums[i];
		}

		return ans;
	}

	// Bucket Sort
	public int arrayPairSum(int[] nums) {
		// bucket sort
		int maxNumberAllowed = 10000; // given in question -10^4 <= nums[i] <= 10^4
		int[] bucket = new int[2 * maxNumberAllowed + 1]; // we will create double size bucket since we have to handle
															// negative numbers also

		// fill bucket
		for (int num : nums) {
			bucket[10000 + num]++;
		}

		// iterate bucket
		boolean shouldPick = true;
		int sum = 0;
		for (int i = 0; i <= 20000; i++) {
			// pick one and skip one in sorted order array
			while (bucket[i] > 0) {
				if (shouldPick) {
					sum += (i - 10000);
				}
				shouldPick = !shouldPick; // flip the sign
				bucket[i]--;
			}
		}

		return sum;
	}

}
