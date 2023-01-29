package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeanOfArrayAfterRemovalSomeElementLeetcode1619 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int lenMin;
	int lenMax;
	List<Integer> min = new ArrayList<>();
	List<Integer> max = new ArrayList<>();

	public double trimMean(int[] arr) {
		int removeitem = arr.length / 20;
		Arrays.sort(arr);
		int sum = 0;
		for (int i = removeitem; i < arr.length - removeitem; i++) {
			sum = sum + arr[i];
		}

		return (double) sum / (arr.length - (2 * removeitem));

	}
}
