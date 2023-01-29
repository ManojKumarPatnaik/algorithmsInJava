package My_Learning.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfWaysToReachDestinationLeetcode1976 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countPaths(int n, int[][] roads) {
		final int mod = 1000000007;
		int[][] adj = new int[n][n];
		for (int[] road : roads) {
			adj[road[0]][road[1]] = road[2];
			adj[road[1]][road[0]] = road[2];
		}

		int[] time = new int[n], ways = new int[n];
		Arrays.fill(time, 1, n, Integer.MAX_VALUE);
		ways[0] = 1;

		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] e = q.poll();
			int v = e[0], t = e[1];
			if (t <= time[v]) {
				for (int i = 0; i < n; i++) {
					if (adj[v][i] != 0) {
						if (time[v] + adj[v][i] < time[i]) {
							time[i] = time[v] + adj[v][i];

							q.offer(new int[] { i, time[i] });
							ways[i] = ways[v];
						} else if (time[v] + adj[v][i] == time[i]) {
							ways[i] = (ways[i] + ways[v]) % mod;
						}
					}
				}
			}
		}
		return ways[n - 1];
	}
}
