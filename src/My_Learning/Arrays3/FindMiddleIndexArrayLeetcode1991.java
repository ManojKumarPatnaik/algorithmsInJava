package My_Learning.Arrays3;

public class FindMiddleIndexArrayLeetcode1991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMiddleIndex(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int prefix = 0, suffix = 0;
		for (int i = 0; i < nums.length; i++) {
			suffix = sum - prefix;
			prefix += nums[i];
			if (prefix == suffix)
				return i;
		}
		return -1;
	}

}
