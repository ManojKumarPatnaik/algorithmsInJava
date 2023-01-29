package My_Learning.graph;

import java.util.ArrayList;

public class MaximalNetworkRankLeetcode1615 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public int maximalNetworkRank(int n, int[][] roads) {
		int[] deg = new int[n];
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
		for (int[] i : roads) {
			int u = i[0];
			int v = i[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
			deg[u]++;
			deg[v]++;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = deg[i] + deg[j];
				if (adj.get(i).contains(j))
					temp--;
				ans = Math.max(ans, temp);
			}
		}
		return ans;
	}

}
