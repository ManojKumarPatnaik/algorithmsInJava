package My_Learning.maths;

import java.util.Arrays;

public class MagneticForceBetweenBallsLeetcode1552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDistance(int[] arr, int m) {
		Arrays.sort(arr);

		int low = 1;
		int high = arr[arr.length - 1] - arr[0];

		while (low <= high) {
			int mid = (low + high) >> 1;
			if (canPlace(arr, m, mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high;
	}

	boolean canPlace(int[] arr, int m, int tar) {
		int curr_cord = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - curr_cord >= tar) {
				count++;
				curr_cord = arr[i];
			}
			if (count == m)
				return true;
		}
		return false;
	}

}
