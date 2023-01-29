package My_Learning.Arrays3;

import java.util.*;

public class NonDecreasingSubsequenceLeetcode491 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 6, 7, 7 };

		System.out.println(findSubsequences(nums).toString());
	}

	public static List<List<Integer>> findSubsequences1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			List<Integer> incSub = getIncSubsequence(i, nums, new ArrayList<>(nums[i]));
			if (!incSub.isEmpty()) {
				ans.add(incSub);
			}
		}

		return ans;
	}

	private static List<Integer> getIncSubsequence(int i, int[] nums, List<Integer> incList) {

		if (i == nums.length - 1) {
			if (incList.get(incList.size() - 1) <= nums[i]) {
				incList.add(nums[i]);
			}

			return incList;
		}

		return null;
	}

	static Set<List<Integer>> lists;

	public static List<List<Integer>> findSubsequences(int[] nums) {
		lists = new HashSet<>();
		recursion(nums, 0, new ArrayList<>());

		return new ArrayList<>(lists);
	}

	static void recursion(int[] nums, int curr, List<Integer> temp) {
		if (temp.size() >= 2)
			lists.add(new ArrayList<>(temp));

		for (int i = curr; i < nums.length; i++) {
			if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
				temp.add(nums[i]);
				recursion(nums, i + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
