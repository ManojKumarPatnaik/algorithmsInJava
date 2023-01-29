package My_Learning.Arrays;

import java.util.Arrays;

public class Leetcodeehrgh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canBeEqual(int[] target, int[] arr) {
		Arrays.sort(target);
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != target[i]) {
				return false;
			}
		}
		return true;
	}

}
