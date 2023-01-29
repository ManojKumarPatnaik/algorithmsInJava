package My_Learning.numberTheory;

import java.util.Arrays;

public class CheckNIfDoubleExistsLeetcode1346 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkIfExist(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int low = 0;
			int high = arr.length - 1;

			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (arr[mid] * 2 == arr[i] && i != mid) {
					return true;
				} else if (arr[mid] * 2 > arr[i]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return false;
	}

}
