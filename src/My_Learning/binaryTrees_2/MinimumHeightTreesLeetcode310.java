package My_Learning.binaryTrees_2;

import java.util.*;

public class MinimumHeightTreesLeetcode310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer>[] edgeList = new List[n];
		for (int i = 0; i < n; i++) {
			edgeList[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			edgeList[edge[0]].add(edge[1]);
			edgeList[edge[1]].add(edge[0]);
		}

		int[] prev = new int[n];
		Arrays.fill(prev, -1);
		int p0 = bfs(edgeList, 0, prev);

		prev = new int[n];
		Arrays.fill(prev, -1);
		int p1 = bfs(edgeList, p0, prev);

		List<Integer> path = new ArrayList<>();
		int i = p1;
		while (i != p0) {
			path.add(i);
			i = prev[i];
		}
		path.add(p0);

		List<Integer> res = new ArrayList<>();
		res.add(path.get(path.size() / 2));
		if (path.size() % 2 == 0)
			res.add(path.get(path.size() / 2 - 1));
		return res;
	}

	private int bfs(List<Integer>[] edgeList, int start, int[] prev) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		prev[start] = start;
		int ret = start;
		while (!q.isEmpty()) {
			ret = q.poll();
			for (int i : edgeList[ret]) {
				if (prev[i] == -1) {
					q.add(i);
					prev[i] = ret;
				}
			}
		}
		return ret;
	}

}
