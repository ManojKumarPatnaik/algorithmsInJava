package My_Learning.graph;

import java.util.HashMap;
import java.util.Map;

public class LongestConsequtiveSequenceLeetcode128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// revist daily leetcode question
	public int longestConsecutive(int[] nums) {
		UF uf = new UF(nums.length);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // <value,index>
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				continue;
			}
			map.put(nums[i], i);
			if (map.containsKey(nums[i] + 1)) {
				uf.union(i, map.get(nums[i] + 1));
			}
			if (map.containsKey(nums[i] - 1)) {
				uf.union(i, map.get(nums[i] - 1));
			}
		}
		return uf.maxUnion();
	}
}

class UF {
	private int[] list;

	public UF(int n) {
		list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = i;
		}
	}

	private int root(int i) {
		while (i != list[i]) {
			list[i] = list[list[i]];
			i = list[i];
		}
		return i;
	}

	public boolean connected(int i, int j) {
		return root(i) == root(j);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		list[i] = j;
	}

	// returns the maxium size of union
	public int maxUnion() { // O(n)
		int[] count = new int[list.length];
		int max = 0;
		for (int i = 0; i < list.length; i++) {
			count[root(i)]++;
			max = Math.max(max, count[root(i)]);
		}
		return max;
	}

}
