package My_Learning.Arrays2;

import java.util.HashSet;

public class MaxNoOverLappingSubarraySumEqualK1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxNonOverlapping(int[] nums, int target) {
		int res = 0;
		HashSet<Integer> preSum = new HashSet<>();
		preSum.add(0);
		int prev = 0;
		for (int i = 0; i < nums.length; i++) {
			int val = prev + nums[i];
			if (preSum.contains(val - target)) {
				res++;
				preSum = new HashSet<>();
			}
			preSum.add(val);
			prev = val;
		}
		return res;
	}	

}
