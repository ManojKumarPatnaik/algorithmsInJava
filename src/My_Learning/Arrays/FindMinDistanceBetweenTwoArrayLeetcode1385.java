package My_Learning.Arrays;

import java.util.Set;
import java.util.TreeSet;

public class FindMinDistanceBetweenTwoArrayLeetcode1385 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		TreeSet<Integer> tree = new TreeSet<>();
		for (int number : arr2) {
			tree.add(number);
		}
		for (int i = 0; i < arr1.length; i++) {
			int leftValue = arr1[i] - d;
			int rightValue = arr1[i] + d;
			Set<Integer> set = tree.subSet(leftValue, rightValue + 1);
			if (set.isEmpty())
				count += 1;
		}
		return count;
	}

	// Brutoe force
	public int findTheDistanceValueBrouteForce(int[] arr1, int[] arr2, int d) {
		int count = arr1.length;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (Math.abs(arr1[i] - arr2[j]) <= d) {
					count -= 1;
					break;
				}
			}
		}
		return count;
	}

}
