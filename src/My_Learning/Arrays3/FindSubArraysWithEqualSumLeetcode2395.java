package My_Learning.Arrays3;

import java.util.HashSet;

public class FindSubArraysWithEqualSumLeetcode2395 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean findSubarrays(int[] nums) {
		HashSet<Long> set = new HashSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			long sum = (long) (nums[i] + nums[i + 1]);
			if (set.contains(sum))
				return true;
			set.add(sum);
		}

		return false;
	}

}
