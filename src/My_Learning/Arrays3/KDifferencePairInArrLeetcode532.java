package My_Learning.Arrays3;

import java.util.HashMap;

public class KDifferencePairInArrLeetcode532 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPairs(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int ans = 0;

		for (int i : nums) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		for (int i : hm.keySet()) {
			int n = k + i;
			if (k == 0) {
				if (hm.get(n) > 1) {
					ans += 1;
				}
			} else {
				if (hm.containsKey(n)) {
					ans += 1;
				}
			}
		}
		return ans;
	}

}
