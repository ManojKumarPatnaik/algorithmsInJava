package My_Learning.Arrays3;

public class MaximumValueAtGivenIndexLeetcode1802 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isPossible(int n, int index, int maxSum, int value) {
		int leftValue = Math.max(value - index, 0);
		int rightValue = Math.max(value - ((n - 1) - index), 0);

		long sumBefore = (long) (value + leftValue) * (value - leftValue + 1) / 2;
		long sumAfter = (long) (value + rightValue) * (value - rightValue + 1) / 2;

		return sumBefore + sumAfter - value <= maxSum;
	}

	public int maxValue(int n, int index, int maxSum) {
		int left = 0, right = maxSum - n;

		while (left < right) {
			int middle = (left + right + 1) / 2;
			if (isPossible(n, index, maxSum - n, middle))
				left = middle;
			else
				right = middle - 1;
		}
		return left + 1;
	}

}
