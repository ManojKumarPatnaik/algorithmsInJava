package My_Learning.Arrays2;

public class SetMisMatchLeetcode645 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findErrorNums(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			// the index we should to put abs(nums[i])
			int index = Math.abs(nums[i]) - 1;
			// if that position is already taken, i.e. negative
			// then it is duplicate
			if (nums[index] < 0) {
				res[0] = index + 1; // duplicate
			} else {
				// put it by marking negative
				nums[index] = -nums[index];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			// index i is not put, then i + 1 missing
			if (nums[i] > 0) {
				res[1] = i + 1;
			}
		}

		return res;
	}

}
