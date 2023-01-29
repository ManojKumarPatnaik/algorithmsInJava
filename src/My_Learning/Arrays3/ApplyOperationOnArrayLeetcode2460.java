package My_Learning.Arrays3;

public class ApplyOperationOnArrayLeetcode2460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] applyOperations(int[] nums) {
		int k = 0;
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				nums[i] *= 2;
				nums[i + 1] = 0;
			}
			if (nums[i] != 0)
				nums[k++] = nums[i];
		}
		if (nums[n - 1] != 0)
			nums[k++] = nums[n - 1];

		for (int j = k; j < n; j++)
			nums[j] = 0;

		return nums;
	}

}
