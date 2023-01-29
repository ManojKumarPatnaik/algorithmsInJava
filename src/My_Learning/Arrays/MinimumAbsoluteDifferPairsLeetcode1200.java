package My_Learning.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifferPairsLeetcode1200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>();
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			diff = Math.min(diff, arr[i + 1] - arr[i]);
		}

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == diff) {
				ans.add(Arrays.asList(arr[i], arr[i + 1]));
			}
		}
		return ans;
	}

}
