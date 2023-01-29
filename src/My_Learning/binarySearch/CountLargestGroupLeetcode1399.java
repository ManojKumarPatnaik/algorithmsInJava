package My_Learning.binarySearch;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroupLeetcode1399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countLargestGroup(int n) {
		int maxFreq = 0, dp[] = new int[n + 1], res = 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			dp[i] = i % 10 + dp[i / 10];
			map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
		}
		for (int key : map.keySet()) {
			if (map.get(key) > maxFreq) {
				maxFreq = map.get(key);
				res = 1;
			} else if (map.get(key) == maxFreq)
				res++;
		}
		return res;
	}

}
