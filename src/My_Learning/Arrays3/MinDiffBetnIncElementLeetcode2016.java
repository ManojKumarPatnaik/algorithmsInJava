package My_Learning.Arrays3;

public class MinDiffBetnIncElementLeetcode2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumDifference(int[] nums) {
		int curr = nums[0];
		int max_diff = -1;

		for (int i = 1; i < nums.length; i++) {

			if (curr >= nums[i]) {

				curr = nums[i];

			} else {

				int diff = 0;
				diff = nums[i] - curr;

				if (diff >= max_diff) {
					max_diff = diff;
				}

			}
		}

		return max_diff;
	}

}
