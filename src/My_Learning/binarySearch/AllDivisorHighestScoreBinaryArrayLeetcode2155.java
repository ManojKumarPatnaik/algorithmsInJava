package My_Learning.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class AllDivisorHighestScoreBinaryArrayLeetcode2155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> maxScoreIndices(int[] nums) {
		int ones = 0;
		for (int i = 0; i < nums.length; i++) {
			ones += nums[i];
		}
		int zeroes = nums.length - ones;
		int mx = ones;
		int i = 1;
		int left = 0, right = ones;
		while (i <= nums.length) {
			if (nums[i - 1] == 0) {
				left++;
			} else {
				right--;
			}

			mx = Math.max(left + right, mx);
			i++;
		}
		List<Integer> ans = new ArrayList<Integer>();
		i = 0;
		left = 0;
		right = ones;

		while (i < nums.length) {
			if (left + right == mx) {
				ans.add(i);
				if (nums[i] == 0) {
					left++;
				} else {
					right--;
				}

				i++;
			} else {
				if (nums[i] == 0) {
					left++;
				} else {
					right--;
				}

				i++;
			}
		}

		if (left + right == mx) {
			ans.add(nums.length);
		}
		return ans;
	}

}
