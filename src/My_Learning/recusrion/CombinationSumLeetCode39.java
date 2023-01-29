package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetCode39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CombinationSumLeetCode39 obj = new CombinationSumLeetCode39();
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> ans = obj.combinationSum(candidates, target);
		System.out.println("Subsequence with given target :: ");
		for (List<Integer> it : ans) {
			System.out.println(it.toString());
		}
	}

	// one element can be used multiple times + order of combination doesn't matter
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
		if (ind == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds)); // here ds is passed by reference and changes
				// will affect the original one hence make new one and add to ans
				// ans.add(ds); not this.
			}
			return;
		}

		if (arr[ind] <= target) {
			ds.add(arr[ind]);
			findCombinations(ind, arr, target - arr[ind], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(ind + 1, arr, target, ans, ds);
	}

}
