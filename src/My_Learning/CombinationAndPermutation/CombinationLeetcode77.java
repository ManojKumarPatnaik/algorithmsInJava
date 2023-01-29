package My_Learning.CombinationAndPermutation;

import java.util.ArrayList;
import java.util.List;

public class CombinationLeetcode77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> ans = new ArrayList<>();

		findCombinations(1, n, k, ans, new ArrayList<>());

		return ans;

	}

	public void findCombinations(int index, int n, int k, List<List<Integer>> ans, List<Integer> ds) {

		if (k == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = index; i <= n; i++) {
			ds.add(i);
			findCombinations(i + 1, n, k - 1, ans, ds);
			ds.remove(ds.size() - 1);
		}

		return;
	}

}
