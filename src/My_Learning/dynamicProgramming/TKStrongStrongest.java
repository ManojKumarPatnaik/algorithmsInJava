package My_Learning.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class TKStrongStrongest {
	public int[] getStrongest1(int[] arr, int k) {
		Arrays.sort(arr);
		int[] result = new int[k];
		int n = arr.length, l = 0, r = n - 1, m = (n - 1) / 2, writer = 0;
		while (l <= r) {
			if (Math.abs(arr[l] - arr[m]) > Math.abs(arr[r] - arr[m])) {
				result[writer++] = arr[l++];
			} else {
				result[writer++] = arr[r--];
			}
			k--;
			if (k == 0)
				break;
		}
		return result;
	}

	public static int[] getStrongest2(int[] arr, int k) {
		Arrays.sort(arr);

		int med = arr[((arr.length - 1) / 2)];

		int[] kStrongest = new int[k];

		// ArrayList<Integer> ns = Arrays.asList(arr);
		ArrayList<Integer> ns = new ArrayList<>();
		for (int f : arr)
			ns.add(f);

		ns.sort((i1, i2) -> {
			int diff = Math.abs(i2 - med) - Math.abs(i1 - med);
			if (diff == 0) {
				return i2 - i1;
			}
			return diff;
		});
		for (int i = 0; i < k; i++) {
			kStrongest[i] = ns.get(i);
		}
		return kStrongest;
	}
}
