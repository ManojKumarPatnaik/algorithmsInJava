package My_Learning.graph;

import java.util.*;

public class FindCriticalPseudoEdgeInMSTLeetcode1489 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class UnionFind {
		final int[] parents;
		int count;

		public UnionFind(int n) {
			this.parents = new int[n];
			reset();
		}

		public void reset() {
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			count = parents.length;
		}

		public int find(int i) {
			int parent = parents[i];
			if (parent == i) {
				return i;
			} else {
				int root = find(parent);
				parents[i] = root;
				return root;
			}
		}

		public boolean union(int i, int j) {
			int r1 = find(i);
			int r2 = find(j);
			if (r1 != r2) {
				count--;
				parents[r1] = r2;
				return true;
			} else {
				return false;
			}
		}

	}

	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

		List<Integer> criticals = new ArrayList<>();
		List<Integer> pseduos = new ArrayList<>();

		Map<int[], Integer> map = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			map.put(edges[i], i);
		}

		Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));
		int minCost = buildMST(n, edges, null, null);

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int index = map.get(edge);
			int costWithout = buildMST(n, edges, null, edge);
			if (costWithout > minCost) {
				criticals.add(index);
			} else {
				int costWith = buildMST(n, edges, edge, null);
				if (costWith == minCost) {
					pseduos.add(index);
				}
			}

		}

		return Arrays.asList(criticals, pseduos);
	}

	private int buildMST(int n, int[][] edges, int[] pick, int[] skip) {
		UnionFind uf = new UnionFind(n);
		int cost = 0;
		if (pick != null) {
			uf.union(pick[0], pick[1]);
			cost += pick[2];
		}

		for (int[] edge : edges) {
			if (edge != skip && uf.union(edge[0], edge[1])) {
				cost += edge[2];
			}
		}
		return uf.count == 1 ? cost : Integer.MAX_VALUE;
	}

}
