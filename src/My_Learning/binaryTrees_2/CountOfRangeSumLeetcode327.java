package My_Learning.binaryTrees_2;

public class CountOfRangeSumLeetcode327 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0)
			return 0;

		long[] sums = new long[nums.length + 1];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = nums[i - 1] + sums[i - 1];
		}

		return mergesortCountRangeSum(sums, lower, upper, 0, sums.length - 1);
	}

	private int mergesortCountRangeSum(long[] sums, int lower, int upper, int low, int high) {
		if (low >= high)
			return 0;

		int mid = low + (high - low) / 2;
		int res = mergesortCountRangeSum(sums, lower, upper, low, mid)
				+ mergesortCountRangeSum(sums, lower, upper, mid + 1, high);
		int i = mid + 1, j = mid + 1;

		// Time complexity: for i or j, it could only be moved from mid+1 to high,
		// so this is a two pointer problem, not 2 loops
		for (int k = low; k <= mid; k++) {
			while (i <= high && sums[i] - sums[k] < lower)
				i++;
			while (j <= high && sums[j] - sums[k] <= upper)
				j++;
			res += j - i;
		}

		mergeCountRangeSum(sums, low, high);
		return res;
	}

	private void mergeCountRangeSum(long[] sums, int low, int high) {
		int mid = low + (high - low) / 2;
		int i = low, j = mid + 1, k = 0;
		long[] arr = new long[high - low + 1];

		while (k < arr.length) {
			long num1 = i <= mid ? sums[i] : Long.MAX_VALUE;
			long num2 = j <= high ? sums[j] : Long.MAX_VALUE;

			arr[k++] = num1 <= num2 ? sums[i++] : sums[j++];
		}

		for (int p = 0; p < arr.length; p++)
			sums[p + low] = arr[p];
	}

}
