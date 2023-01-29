package My_Learning.Arrays2;

public class CoupleHoldingHandsLeetcode765 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] par;

	public int findPar(int u) {
		return par[u] == u ? u : (par[u] = findPar(par[u]));
	}

	public int minSwapsCouples(int[] row) {
		int n = row.length;
		par = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
		}

		for (int i = 0; i < n; i += 2) {
			par[row[i]] = row[i];
			par[row[i + 1]] = row[i];
		}
		int count = 0;
		for (int i = 0; i < n; i += 2) {
			int p1 = findPar(i);
			int p2 = findPar(i + 1);
			if (p1 != p2) {
				par[p2] = p1;
				count++;
			}
		}
		return count;
	}

}
