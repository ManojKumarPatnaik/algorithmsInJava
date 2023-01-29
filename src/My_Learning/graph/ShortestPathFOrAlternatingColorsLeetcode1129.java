package My_Learning.graph;

import java.util.*;

public class ShortestPathFOrAlternatingColorsLeetcode1129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		Map<Integer, List<Integer>> redGraph = new HashMap<>();
		Map<Integer, List<Integer>> blueGraph = new HashMap<>();

		int[] answer = new int[n];
		Set<Integer> blueRed = new HashSet<>();
		Set<Integer> redBlue = new HashSet<>();
		Queue<int[]> queue = new LinkedList<>();

		for (int[] edge : redEdges) {
			redGraph.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
		}

		for (int[] edge : blueEdges) {
			blueGraph.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
		}

		Arrays.fill(answer, Integer.MAX_VALUE);
		queue.offer(new int[] { 0, 0, 0 }); // Add src nodes
		queue.offer(new int[] { 0, 0, 1 });
		redBlue.add(0);
		blueRed.add(0);
		while (!queue.isEmpty()) {
			int[] nodeInfo = queue.poll();
			int node = nodeInfo[0];
			int dis = nodeInfo[1];
			int color = nodeInfo[2];

			if (answer[node] > dis) {
				answer[node] = dis;
			}

			int nextColor = 1 - color; // Complement or swap color
			if (nextColor == 1) {
				// we need to paint red
				if (redGraph.containsKey(node)) {
					for (int nextNode : redGraph.get(node)) {
						if (!redBlue.contains(nextNode)) {
							redBlue.add(nextNode);
							queue.offer(new int[] { nextNode, dis + 1, nextColor });
						}
					}
				}
			} else {
				// we need to paint blue
				if (blueGraph.containsKey(node)) {
					for (int nextNode : blueGraph.get(node)) {
						if (!blueRed.contains(nextNode)) {
							blueRed.add(nextNode);
							queue.offer(new int[] { nextNode, dis + 1, nextColor });
						}
					}
				}
			}
		}

		// Nodes which are not reachable or cannot form paths with alternate colors
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == Integer.MAX_VALUE) {
				answer[i] = -1;
			}
		}

		return answer;
	}

}
