package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairAbsDifferenceLeetcode2006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countKDifference(int[] nums, int k) {

		Map<Integer, Integer> hm = new HashMap<>();

		for (int i : nums) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		int res = 0;
		for (int key : hm.keySet()) {
			int target1 = key - k;
			int target2 = key + k;

			if (hm.containsKey(target1))
				res += hm.get(target1) * hm.get(key);
			if (hm.containsKey(target2))
				res += hm.get(target2) * hm.get(key);
		}

		// the number of pairs was double counted in the for loop.
		return res / 2;

	}

}
