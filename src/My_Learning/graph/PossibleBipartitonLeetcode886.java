package My_Learning.graph;

import java.util.*;

public class PossibleBipartitonLeetcode886 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to check bipartite
	public boolean possibleBipartition(int n, int[][] d) {
		List<Integer>[] nm = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			nm[i] = new ArrayList<>();
		}
		for (int k[] : d) {
			nm[k[0]].add(k[1]);
			nm[k[1]].add(k[0]);
		}
		int a[] = new int[n + 1];
		Arrays.fill(a, -1);
		for (int i = 0; i < n; i++) {
			if (a[i] == -1) {
				Queue<Integer> kk = new LinkedList<>();
				kk.offer(i);
				a[i] = 1;
				while (!(kk.isEmpty())) {
					int p = kk.poll();
					for (int f : nm[p]) {
						if (a[f] == -1) {
							a[f] = 1 - a[p];
							kk.offer(f);
						} else if (a[p] == a[f])
							return false;
					}
				}
			}
		}
		return true;
	}
}
