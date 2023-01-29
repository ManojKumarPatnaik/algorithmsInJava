package My_Learning.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetcode1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Hash Map
	public int[] twoSumHashMap(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}

	// Two Pointer Approach
	public int[] twoSum(int[] nums, int target) {
		// num -> index
		final HashMap<Integer, Integer> numIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			// Check if number is already in hashmap
			if (numIndex.containsKey(nums[i])) {
				return new int[] { numIndex.get(nums[i]), i };
			}
			// Otherwise, add the diff to hashmap
			numIndex.put(target - nums[i], i);
		}

		return new int[] {};
	}

}
