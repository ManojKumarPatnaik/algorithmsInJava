package My_Learning.numberTheory;

import java.util.Arrays;

public class MinimumOperationToZero1658 {

	public int minOperations(int[] nums, int x) {
		int target = Arrays.stream(nums).sum() - x, size = -1, n = nums.length;
		for (int lo = -1, hi = 0, winSum = 0; hi < n; ++hi) {
			winSum += nums[hi];
			while (lo + 1 < nums.length && winSum > target) {
				winSum -= nums[++lo];
			}
			if (winSum == target) {
				size = Math.max(size, hi - lo);
			}
		}
		return size < 0 ? -1 : n - size;
	}

}
