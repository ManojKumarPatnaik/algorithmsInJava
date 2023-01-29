package My_Learning.Arrays2;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualKLeetcode560 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

}
