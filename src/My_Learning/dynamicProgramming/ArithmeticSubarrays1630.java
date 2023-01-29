package My_Learning.dynamicProgramming;

import java.util.*;

public class ArithmeticSubarrays1630 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> res = new ArrayList<Boolean>();
		for (int i = 0; i < l.length; i++) {
			res.add(isArithmeticSeq(nums, l[i], r[i]));
		}

		return res;
	}

	private boolean isArithmeticSeq(int[] nums, int start, int end) {
		if (end - start < 2)
			return true;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = start; i <= end; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
			set.add(nums[i]);
		}

		if ((max - min) % (end - start) != 0)
			return false;
		int interval = (max - min) / (end - start);

		for (int i = 1; i <= end - start; i++) {
			if (!set.contains(min + i * interval))
				return false;
		}

		return true;
	}

	public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] l, int[] r) {
		List<Boolean> res = new ArrayList<>();
		for (int i = 0; i < l.length; i++) {
			int start = l[i];
			int end = r[i];
			List<Integer> temp = new ArrayList<>();
			for (int j = start; j < end + 1; j++) {
				temp.add(nums[j]);
			}
			res.add(checkIsArithmeticSubarrays(temp));
		}
		return res;
	}

	public boolean checkIsArithmeticSubarrays(List<Integer> nums) {
		if (nums.size() < 2)
			return false;
		Collections.sort(nums);
		int delta = nums.get(1) - nums.get(0);
		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i + 1) - nums.get(i) != delta)
				return false;
		}
		return true;
	}

}
