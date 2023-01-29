package My_Learning.maths;

import java.util.Arrays;

public class SumOfMutatedArrayLeetcode1300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findBestValue(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0, right = arr[arr.length - 1];
		int minDifference = Integer.MAX_VALUE, result = 0;

		while (left <= right) {
			int middle = (left + right) / 2;
			int sum = sumAfterChanges(arr, middle);
			if (sum > target)
				right = middle - 1;
			else
				left = middle + 1;

			if ((Math.abs(sum - target) < minDifference)
					|| (Math.abs(sum - target) == minDifference && middle < result)) {
				minDifference = Math.abs(sum - target);
				result = middle;
			}
		}
		return result;
	}

	private int sumAfterChanges(int[] array, int value) {
		int sum = 0;
		for (int number : array) {
			sum += Math.min(number, value);
		}
		return sum;
	}
}
