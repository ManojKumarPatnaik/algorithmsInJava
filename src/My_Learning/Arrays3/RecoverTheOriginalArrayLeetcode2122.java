package My_Learning.Arrays3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecoverTheOriginalArrayLeetcode2122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] recoverArray(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		// the first index element, must be one of the lower elements,so we just need to
		// calculate all the difference between the first element with other
		for (int i = 1; i < n; i++) {
			// If the seond element is the same as the previous, don't check it
			if (i > 1 && nums[i] == nums[i - 1])
				continue;

			int diff = nums[i] - nums[0];
			// If the difference between two elements is odd, it means we cannot find the
			// answer here
			// k cannot be zero
			if (diff % 2 != 0 || diff == 0)
				continue;
			int[] tmp = findOriginalArray(nums, diff / 2);
			if (tmp.length > 0)
				return tmp;
		}
		return nums;
	}

	public int[] findOriginalArray(int[] changed, int t) {
		int n = changed.length;
		if (n % 2 != 0)
			return new int[0];

		int[] ans = new int[n / 2];
		int i = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : changed) {
			// if we find the smaller elements saved ever before,delete it
			// otherwise, save it in the hash map
			if (!map.containsKey(item - 2 * t)) {
				map.putIfAbsent(item, 0);
				map.put(item, map.get(item) + 1);
			} else if (map.get(item - 2 * t) == 1) {
				map.remove(item - 2 * t);
				ans[i++] = item - t;
			} else {
				map.put(item - 2 * t, map.get(item - 2 * t) - 1);
				ans[i++] = item - t;
			}
		}

		return i == n / 2 && map.isEmpty() ? ans : new int[0];
	}

}
