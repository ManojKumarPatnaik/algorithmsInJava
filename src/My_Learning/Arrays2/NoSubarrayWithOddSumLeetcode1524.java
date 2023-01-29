package My_Learning.Arrays2;

public class NoSubarrayWithOddSumLeetcode1524 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numOfSubarrays(int[] arr) {
		int odd = 0, even = 0, result = 0;

		// Base case - if the input array size is 1
		if (arr[0] % 2 == 1) {
			odd = 1;
			result = 1;
		}

		if (odd == 0)
			even = 1;

		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];

		for (int i = 1; i < arr.length; i++) { // Compute the prefixSum for the rest of the array
			prefixSum[i] = prefixSum[i - 1] + arr[i];

			if (prefixSum[i] % 2 == 0) {
				even++;
				result = (result + odd) % 1000000007; // Since the count may be too big for int & return type is also
														// int
			} else {
				odd++;
				result = (result + even + 1) % 1000000007;
			}
		}
		return result;
	}

}
