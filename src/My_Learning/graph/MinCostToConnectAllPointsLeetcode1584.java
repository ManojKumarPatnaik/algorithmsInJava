package My_Learning.graph;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostToConnectAllPointsLeetcode1584 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcode daily problem
	// Prims Algorithm 
	public int minCostConnectPointsPrims(int[][] points) {
		int n = points.length, ans = 0;
		HashSet<Integer> mst = new HashSet<>();
		mst.add(0);

		int[] dist = new int[n];

		for (int i = 1; i < n; i++)
			dist[i] = findDistPrims(points, 0, i);

		while (mst.size() != n) {

			// Find the node that has shortest distance
			int next = -1;
			for (int i = 0; i < n; i++) {
				if (mst.contains(i))
					continue;
				if (next == -1 || dist[next] > dist[i])
					next = i;
			}

			// Put the node into the Minning Spanning Tree
			mst.add(next);
			ans += dist[next];

			// Update distance array
			for (int i = 0; i < n; i++) {
				if (!mst.contains(i)) {
					dist[i] = Math.min(dist[i], findDistPrims(points, i, next));
				}
			}
		}
		return ans;
	}

	private int findDistPrims(int[][] points, int a, int b) {
		return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
	}

	// Kruskal Algorithm using Union Find

	public int minCostConnectPoints(int[][] points) {
		int n = points.length, ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pq.add(new int[] { findDist(points, i, j), i, j });
			}
		}
		int count = 0;
		UnionFind uf = new UnionFind(n);
		while (count < n - 1) {
			int[] edge = pq.poll();
			if (uf.find(edge[1]) != uf.find(edge[2])) {
				ans += edge[0];
				count++;
				uf.union(edge[1], edge[2]);
			}
		}
		return ans;
	}

	private int findDist(int[][] points, int a, int b) {
		return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
	}

	class UnionFind {
		int[] parent;

		UnionFind(int n) {
			this.parent = new int[n];
			for (int i = 0; i < n; i++)
				parent[i] = i;
		}

		public void union(int a, int b) {
			parent[find(a)] = parent[find(b)];
		}

		public int find(int x) {
			if (parent[x] != x)
				parent[x] = find(parent[x]);
			return parent[x];
		}
	}

}
