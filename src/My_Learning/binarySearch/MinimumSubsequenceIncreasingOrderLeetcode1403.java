package My_Learning.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceIncreasingOrderLeetcode1403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> minSubsequence(int[] nums) {
		List<Integer> lst = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			sum = sum + nums[i];
			int j = i - 1;
			int total = 0;
			while (j >= 0) {
				total = total + nums[j];
				j--;
			}
			if (sum <= total)
				lst.add(nums[i]);
			else {
				lst.add(nums[i]);
				break;
			}
		}
		return lst;
	}

}
