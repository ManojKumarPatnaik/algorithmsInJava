package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DivideArrayIntoKSetsLeetcode1296 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPossibleDivide(int[] nums, int k) {
		int len = nums.length;
		if (len % k != 0)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);
		for (int n : map.keySet())
			pq.add(n);
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			if (map.get(cur) == 0)
				continue;
			int times = map.get(cur);
			for (int i = 0; i < k; i++) {
				if (!map.containsKey(cur + i) || map.get(cur + i) < times)
					return false;
				map.put(cur + i, map.get(cur + i) - times);
			}
			len -= k * times;
		}
		return len == 0;
	}

}
