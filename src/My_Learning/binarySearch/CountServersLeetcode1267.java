package My_Learning.binarySearch;

public class CountServersLeetcode1267 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countServers(int[][] g) {
		int m = g.length, n = g[0].length, rc[] = new int[m], cc[] = new int[n], res = 0; // rc, cc for row count,
																							// column count;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] != 1)
					continue;
				rc[i]++;
				cc[j]++;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] != 1)
					continue;
				if (rc[i] > 1 || cc[j] > 1)
					res++;
			}
		}
		return res;
	}

}
