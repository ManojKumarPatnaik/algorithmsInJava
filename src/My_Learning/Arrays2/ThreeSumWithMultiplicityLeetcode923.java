package My_Learning.Arrays2;

import java.util.Arrays;

public final class ThreeSumWithMultiplicityLeetcode923 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int threeSumMulti(int[] arr, int target) {
		Arrays.sort(arr);
		long result = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int required = target - arr[i];
			int j = i + 1;
			int k = arr.length - 1;
			while (j < k) {
				if (arr[j] + arr[k] == required) {
					int count1 = 1, count2 = 1;
					if (arr[j] == arr[k]) {
						long n = (k - j + 1);
						result += (n * (n - 1)) / 2;
						break;
					}

					while (j + 1 < k && arr[j] == arr[j + 1]) {
						count1++;
						j++;
					}
					while (k - 1 > j && arr[k] == arr[k - 1]) {
						count2++;
						k--;
					}
					j++;
					k--;
					result += (count1 * count2);
				} else if (arr[j] + arr[k] > required)
					k--;
				else
					j++;

			}

		}
		return (int) (result % 1_00_00_00_00_7);

	}

}
