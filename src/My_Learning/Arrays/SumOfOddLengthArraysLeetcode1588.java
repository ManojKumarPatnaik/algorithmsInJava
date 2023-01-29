package My_Learning.Arrays;

public class SumOfOddLengthArraysLeetcode1588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumOddLengthSubarrays(int[] arr) {
		// if arr.length is 5, then the answer to this problem is:
		// arr[0] * 3 + arr[1] * 4 + arr[2] * 5 + arr[3] * 4 + arr[4] * 3
		// multiplier value is the occurance of arr[i] in all odd length subarray

		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += (arr[i] * ((((i + 1) * (arr.length - i)) + 1) / 2));
		return sum;

	}

}
