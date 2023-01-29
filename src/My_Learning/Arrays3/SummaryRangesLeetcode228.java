package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesLeetcode228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> summaryRanges(int[] nums) {
		int n = nums.length;
		List<String> al = new ArrayList<>();
		if (n == 0)
			return al;
		int i = 0;
		int j = 1;
		while (j < n) {
			if (nums[j] != nums[j - 1] + 1) {
				if (nums[i] == nums[j - 1]) {
					al.add("" + nums[i]);
					i = j;
				} else {
					al.add(nums[i] + "->" + nums[j - 1]);
					i = j;
				}
			}
			j++;
		}
		if (nums[i] == nums[j - 1]) {
			al.add("" + nums[i]);
		} else {
			al.add(nums[i] + "->" + nums[j - 1]);
		}
		return al;
	}

}
