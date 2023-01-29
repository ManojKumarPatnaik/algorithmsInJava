package My_Learning.dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FrogJumpLeetcode403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canCross22(int[] a) {

		int n = a.length;

		if (n <= 1)
			return true;

		// linkedlist to store the previous jumps to reach at ith jump
		LinkedList<Integer>[] al = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			al[i] = new LinkedList<Integer>();
		}

		// 0 jump before first stone
		al[0].add(0);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				LinkedList<Integer> l = al[j];
				// number of jumps required to reach ith stone from jth stone
				int jump = a[i] - a[j];
				// we can reach at ith stone if jth stone contains jump, jump+1 or jump-1
				if (l.contains(jump) || l.contains(jump + 1) || l.contains(jump - 1))
					al[i].add(jump);
			}
		}

		// return true if we can reach at last stone
		return al[n - 1].size() != 0;
	}

	public boolean canCross(int[] stones) {
		if (stones.length == 0) {
			return true;
		}

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
		map.put(0, new HashSet<Integer>());
		map.get(0).add(1);
		for (int i = 1; i < stones.length; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}

		for (int i = 0; i < stones.length - 1; i++) {
			int stone = stones[i];
			for (int step : map.get(stone)) {
				int reach = step + stone;
				if (reach == stones[stones.length - 1]) {
					return true;
				}
				HashSet<Integer> set = map.get(reach);
				if (set != null) {
					set.add(step);
					if (step - 1 > 0)
						set.add(step - 1);
					set.add(step + 1);
				}
			}
		}

		return false;
	}

}
