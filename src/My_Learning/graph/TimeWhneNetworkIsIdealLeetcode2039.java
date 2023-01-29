package My_Learning.graph;

import java.util.*;

public class TimeWhneNetworkIsIdealLeetcode2039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int networkBecomesIdle(int[][] edges, int[] patience) {
		// Requests are processed at the same time

		// Create Graph
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int[] e : edges) {
			map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
			map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
		}

		// Find the shortest distance of each node from the master node
		int[] dis = new int[patience.length];
		Arrays.fill(dis, -1);
		dis[0] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);

		while (!queue.isEmpty()) {
			int node = queue.poll();

			if (!map.containsKey(node))
				continue;

			for (int neigh : map.get(node)) {
				if (dis[neigh] == -1) {
					dis[neigh] = dis[node] + 1;
					queue.offer(neigh);
				}
			}
		}

		// Find the the time when the network becomes idle
		int ans = 0;
		for (int i = 1; i < dis.length; i++) {
			int lastRequest = (2 * dis[i] - 1) / patience[i];

			int timeOfLastRequest = patience[i] * lastRequest;
			int timeTakenByLastRequest = 2 * dis[i];

			int totalTime = timeOfLastRequest + timeTakenByLastRequest;
			ans = Math.max(ans, totalTime);
		}

		return ans + 1;
	}

}
