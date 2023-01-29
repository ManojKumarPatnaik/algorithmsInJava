package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumFourLeetCode377 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		int target = 4;

		CombinationSumFourLeetCode377 obj = new CombinationSumFourLeetCode377();

		System.out.println(obj.combinationSum4(nums, target));
	}

//	Input: nums = [1,2,3], target = 4
//			Output: 7
//			Explanation:
//			The possible combination ways are:
//			(1, 1, 1, 1)
//			(1, 1, 2)
//			(1, 2, 1)
//			(1, 3)
//			(2, 1, 1)
//			(2, 2)
//			(3, 1)
//			Note that different sequences are counted as different combinations.

	// Leetcode daily solution
	public int combinationSum4(int[] nums, int target) {

		int count = findCombinations(0, nums, target, new ArrayList<>());
		return count;
	}

	private int findCombinations(int ind, int[] arr, int target, List<Integer> ds) {

		if (target < 0) {
			return 0;
		}

		if (target == 0) {
			return 1;
		}

		int count = 0;
		for (int i = ind; i < arr.length; i++) {

			ds.add(arr[i]);
			count += findCombinations(ind, arr, (target - arr[i]), ds);
			ds.remove(ds.size() - 1);

		}

		return count;
	}

}
