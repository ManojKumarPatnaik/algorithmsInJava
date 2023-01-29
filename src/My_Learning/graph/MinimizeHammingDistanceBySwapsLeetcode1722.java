package My_Learning.graph;

import java.util.HashMap;

public class MinimizeHammingDistanceBySwapsLeetcode1722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] par;

	public int findPar(int u) {
		return par[u] = (par[u] == u) ? u : findPar(par[u]);
	}

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		int count = 0;
		par = new int[source.length];
		for (int i = 0; i < par.length; i++)
			par[i] = i;
		for (int[] ele : allowedSwaps) {
			int u = ele[0];
			int v = ele[1];
			int parU = findPar(u);
			int parV = findPar(v);
			if (parU != parV)
				par[parU] = parV;
		}

		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

		for (int i = 0; i < source.length; i++) {
			int par = findPar(i);
			if (!map.containsKey(par))
				map.put(par, new HashMap<>());
			HashMap<Integer, Integer> set = map.get(par);
			set.put(source[i], set.getOrDefault(source[i], 0) + 1);
		}

		for (int i = 0; i < target.length; i++) {
			int par = findPar(i);
			HashMap<Integer, Integer> unset = map.get(par);
			if (!unset.containsKey(target[i])) {
				count++;
				continue;
			}
			unset.put(target[i], unset.get(target[i]) - 1);
			if (unset.get(target[i]) == 0)
				unset.remove(target[i]);
		}

		return count;
	}

}
