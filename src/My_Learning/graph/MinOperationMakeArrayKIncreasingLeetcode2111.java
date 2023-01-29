package My_Learning.graph;

import java.util.ArrayList;
import java.util.List;

public class MinOperationMakeArrayKIncreasingLeetcode2111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kIncreasing(int[] arr, int k) {

		int ans = 0;
		for (int i = 0; i < k; i++) {
			List<Integer> li = new ArrayList<>();

			for (int j = i; j < arr.length; j += k) {
				li.add(arr[j]);
			}

			ans += li.size() - findLengthOfLIS(li); // Total list size minus the length of longest increasing
													// subsequence
		}

		return ans;
	}

	private int findLengthOfLIS(List<Integer> li) {

		// Find the length of the longest increasing subsequence
		List<Integer> lis = new ArrayList<>(); // The longest increasing subsequence
		lis.add(li.get(0));
		for (int i = 1; i < li.size(); i++) {
			if (lis.get(lis.size() - 1) <= li.get(i)) {
				lis.add(li.get(i));
			} else {
				int index = findNextGreaterIndex(lis, li.get(i));
				lis.set(index, li.get(i));
			}
		}

		return lis.size();
	}

	private int findNextGreaterIndex(List<Integer> lis, int key) {
		int l = 0;
		int h = lis.size() - 1;

		while (l < h) {
			int m = l + (h - l) / 2;
			if (lis.get(m) <= key) {
				l = m + 1;
			} else
				h = m;
		}

		return l;
	}

}
