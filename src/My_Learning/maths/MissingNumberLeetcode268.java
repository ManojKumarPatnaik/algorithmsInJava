package My_Learning.maths;

import java.util.Arrays;

public class MissingNumberLeetcode268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

}
