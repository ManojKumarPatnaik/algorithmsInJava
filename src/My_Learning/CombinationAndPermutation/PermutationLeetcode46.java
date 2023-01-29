package My_Learning.CombinationAndPermutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationLeetcode46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
		if (index == nums.length) {
			// copy the ds to ans
			List<Integer> ds = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				ds.add(nums[i]);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(i, index, nums);
			recurPermute(index + 1, nums, ans);
			swap(i, index, nums);
		}
	}

	private void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		recurPermute(0, nums, ans);
		return ans;
	}

}
