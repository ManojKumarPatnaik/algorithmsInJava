package My_Learning.Arrays3;

public class NumberOfWaysToSplitArrayLeetocde2270 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int waysToSplitArray(int[] nums) {
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}

		long leftSum = 0;
		int res = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			leftSum += nums[i];
			long rightSum = sum - leftSum;
			if (leftSum >= rightSum) {
				res++;
			}
		}
		return res;
	}

}
