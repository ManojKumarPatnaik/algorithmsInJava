package My_Learning.binarySearch;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateTwoLeetcode219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcde daily solution
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!set.add(nums[i]))
				return true;
			if (set.size() > k)
				set.remove(nums[i - k]);
		}
		return false;
	}

}
