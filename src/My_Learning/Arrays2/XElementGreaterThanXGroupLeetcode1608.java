package My_Learning.Arrays2;

import java.util.Arrays;

public class XElementGreaterThanXGroupLeetcode1608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int specialArray(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int n = nums.length - i;
			boolean cond1 = n <= nums[i];
			boolean cond2 = (i - 1 < 0) || (n > nums[i - 1]);
			if (cond1 && cond2)
				return n;
		}
		return -1;
	}

}
