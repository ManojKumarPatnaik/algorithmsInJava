package My_Learning.graph;

import java.util.*;

public class ReOrderRoutesToMakeAllPathToZeroLeetcode1466 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minReorder(int n, int[][] connections) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		Map<Integer, List<Integer>> revGraph = new HashMap<>();

		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
			revGraph.put(i, new ArrayList<>());
		}

		for (int[] edge : connections) {
			graph.get(edge[1]).add(edge[0]);

			revGraph.get(edge[0]).add(edge[1]);
		}

		Queue<Integer> queue = new ArrayDeque<>();
		Set<Integer> seen = new HashSet<>();
		queue.add(0);
		seen.add(0);
		int count = 0;
		while (!queue.isEmpty()) {
			Integer node = queue.poll();

			for (int nei : graph.get(node)) {
				if (seen.contains(nei))
					continue;
				queue.add(nei);
				seen.add(nei);
			}

			for (int nei : revGraph.get(node)) {
				if (seen.contains(nei))
					continue;
				queue.add(nei);
				seen.add(nei);
				count++;
			}
		}

		return count;

	}

}
