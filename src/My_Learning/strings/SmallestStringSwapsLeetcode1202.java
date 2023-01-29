package My_Learning.strings;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestStringSwapsLeetcode1202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] parent;
	int[] level;

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		char[] cs = s.toCharArray();
		parent = new int[cs.length];
		level = new int[cs.length];
		HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;
		for (List<Integer> pair : pairs)
			union(pair.get(0), pair.get(1));
		for (int i = 0; i < cs.length; i++) {
			int p = find(i);
			PriorityQueue<Character> pq = map.getOrDefault(p, new PriorityQueue<Character>());
			pq.offer(cs[i]);
			map.putIfAbsent(p, pq);
		}
		for (int i = 0; i < cs.length; i++)
			cs[i] = map.get(find(i)).poll();
		return new String(cs);
	}

	private void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb) {
			if (level[pa] > level[pb])
				parent[pb] = pa;
			else if (level[pb] > level[pa])
				parent[pa] = pb;
			else {
				parent[pb] = pa;
				level[pa]++;
			}
		}
	}

	private int find(int a) {
		if (parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

}
