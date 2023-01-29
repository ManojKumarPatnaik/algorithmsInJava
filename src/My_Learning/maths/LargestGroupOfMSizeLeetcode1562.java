package My_Learning.maths;

import java.util.HashMap;

public class LargestGroupOfMSizeLeetcode1562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLatestStep(int[] arr, int m) {
		// Find till what number of steps there is group of m size

		UnionFind uf = new UnionFind(arr.length);

		int n = arr.length + 1;
		int[] temp = new int[arr.length + 1];

		int step = 0;
		int ans = -1;
		for (int i : arr) {
			temp[i] = 1;
			uf.putInMap(i);

			if (i + 1 <= arr.length && temp[i + 1] == 1) {
				uf.union(i, i + 1);
			}

			if (i - 1 >= 1 && temp[i - 1] == 1) {
				uf.union(i, i - 1);
			}

			step++;
			if (uf.groupOfMSizeExists(m)) {
				ans = step;
			}
		}

		return ans;
	}

	private class UnionFind {
		public int[] size;
		public int[] parent;
		private HashMap<Integer, Integer> countMap; // Stores the number of groups of particular size

		public UnionFind(int size) {
			this.size = new int[size + 1];
			this.parent = new int[size + 1];
			this.countMap = new HashMap<>();

			for (int i = 1; i <= size; i++) {
				this.size[i] = 1;
				this.parent[i] = i;
			}
		}

		public int findParent(int i) {
			while (i != parent[i]) {
				parent[i] = parent[parent[i]];
				i = parent[i];
			}

			return i;
		}

		public void union(int x, int y) {
			int p1 = findParent(x);
			int p2 = findParent(y);

			if (p1 != p2) {
				parent[p2] = p1;

				countMap.put(size[p2], countMap.get(size[p2]) - 1); // One group of particlar size removed
				countMap.put(size[p1], countMap.get(size[p1]) - 1);

				if (countMap.get(size[p2]) == 0)
					countMap.remove(size[p2]);
				if (countMap.containsKey(size[p1]) && countMap.get(size[p1]) == 0)
					countMap.remove(size[p1]);

				size[p1] += size[p2];
				countMap.put(size[p1], countMap.getOrDefault(size[p1], 0) + 1); // New group size formed
			}

			return;
		}

		public boolean groupOfMSizeExists(int reqSize) {
			return countMap.containsKey(reqSize);
		}

		public void putInMap(int i) {
			countMap.put(1, countMap.getOrDefault(1, 0) + 1);
			return;
		}
	}

}
