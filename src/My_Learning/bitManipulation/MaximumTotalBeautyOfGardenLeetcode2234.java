package My_Learning.bitManipulation;

import java.util.Arrays;

public class MaximumTotalBeautyOfGardenLeetcode2234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private long getMax(int index, long rem, long target, long prefix_sum[], long arr[]) {
		int left = 0, right = index, in = -1;
		while (right >= left) {
			int mid = left + (right - left) / 2;

			// For calculating the value which we will add
			long val = (arr[mid] * (mid + 1) - prefix_sum[mid]);
			if (rem >= val) {

				// getting the index
				in = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// edge case-1 in==-1 return 0;
		// edge case-2 in!=-1 return Math.min((rem+prefix_sum[in])/(in+1),target-1);
		// because we ultimately want a number which is less than target
		return in == -1 ? 0 : (Math.min((rem + prefix_sum[in]) / (in + 1), target - 1));
	}

	public long maximumBeauty(int[] fl, long t, long target, long full, long partial) {

		// Edge case for fl having length 1
		if (fl.length == 1) {
			if (fl[0] >= target)
				return full;
			long result = Math.min(target - 1, fl[0] + t) * partial;
			if (fl[0] + t >= target)
				result = Math.max(result, full);
			return result;
		}

		// converting the array to long array
		long arr[] = new long[fl.length];
		for (int i = 0; i < fl.length; i++)
			arr[i] = (long) fl[i];

		// Sort the array for applying BST
		Arrays.sort(arr);

		// for removing the greatest or equal to elements than target
		int i = arr.length - 1;
		while (i > -1 && arr[i] >= target)
			i--;
		long mid_val = (arr.length - i - 1) * full;
		if (i == -1)
			return mid_val;

		// for prefix sum
		long prefix_sum[] = new long[arr.length];
		prefix_sum[0] = arr[0];
		for (int j = 1; j < arr.length; j++)
			prefix_sum[j] = prefix_sum[j - 1] + arr[j];

		// The present length after the reduction of the greatest or equal elements
		// target
		int len = i + 1;

		// Edge case 1
		long result = getMax(len - 1, t, target, prefix_sum, arr) * partial;

		// Edge case 2
		if (t - target * (len) + prefix_sum[len - 1] >= 0)
			result = Math.max(result, len * full);

		// initialize sum=0 for calculating the sum in whie loop
		long sum = 0;

		while (i > 0) {
			sum += arr[i];
			long v = t - target * (len - i) + sum;
			if (v < 0)
				break;
			result = Math.max(result, getMax(i - 1, v, target, prefix_sum, arr) * partial + full * (len - i));
			i--;
		}

		// Return the result as mid_val+result
		return result + mid_val;
	}

}
