package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArrangementLeetcode526 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countArrangement(int n) {
		Map<String, Integer> cache = new HashMap<>();
		return helper(n, 1, 0, cache);
	}

	private int helper(int n, int i, int visited, Map<String, Integer> cache) {
		if (i > n)
			return 1;

		if (cache.containsKey(i + "," + visited))
			return cache.get(i + "," + visited);

		int cnt = 0;
		for (int j = 1; j <= n; j++) {
			if (i >= j && i % j != 0)
				continue;
			if (j > i && j % i != 0)
				continue;
			if (isVisited(visited, j))
				continue;
			visited = setVisited(visited, j);
			cnt += helper(n, i + 1, visited, cache);
			visited = unsetVisited(visited, j);
		}

		cache.put(i + "," + visited, cnt);

		return cnt;
	}

	private boolean isVisited(int visited, int j) {
		return ((visited >> j) & 1) > 0;
	}

	private int setVisited(int visited, int j) {
		return visited = visited | (1 << j);
	}

	private int unsetVisited(int visited, int j) {
		return visited = visited & (~(1 << j));
	}

}
