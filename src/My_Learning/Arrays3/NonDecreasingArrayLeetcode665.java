package My_Learning.Arrays3;

public class NonDecreasingArrayLeetcode665 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkPossibility(int[] nums) {
		int n = nums.length, count = 0;

		for (int i = 0; i + 1 < n; i++) {
			if (nums[i] > nums[i + 1]) {
				count++;
				if (i > 0 && nums[i + 1] < nums[i - 1])
					nums[i + 1] = nums[i];
				else
					nums[i] = nums[i + 1];
			}
		}

		return count <= 1;
	}

}
