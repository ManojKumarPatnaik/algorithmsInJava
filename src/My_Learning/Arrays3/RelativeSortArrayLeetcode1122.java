package My_Learning.Arrays3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RelativeSortArrayLeetcode1122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] order = new int[1001];

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Arrays.fill(order, -1);
		for (int i = 0; i < arr2.length; i++) {
			order[arr2[i]] = i;
		}
		List<Integer> numList = Arrays.stream(arr1).boxed().collect(Collectors.toList());

		Collections.sort(numList, (n1, n2) -> {
			if (order[n1] < 0 && order[n2] >= 0 || order[n1] >= 0 && order[n2] < 0) {
				return 1;
			}
			return order[n1] < 0 && order[n2] < 0 ? n1 - n2 : order[n1] - order[n2];
		});

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = numList.get(i);
		}
		return arr1;
	}

}
