package My_Learning.Arrays2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElementsLeetcode347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode solution
	public int[] topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

		for (int key : hm.keySet()) {
			int frequency = hm.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		int ans[] = new int[k];
		int count = 0;
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (int j = 0; j < bucket[i].size(); j++)
					ans[count++] = bucket[i].get(j);
			}
			if (count == k)
				break;
		}

		return ans;
	}
}
