package My_Learning.binaryTrees_2;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LongestPathWithDiffCharacterLeetcode2246 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;

	// added method to get longest path 
	public int longestPath(int[] parent, String s) {
		int n = parent.length;
		List<Integer>[] graph = new LinkedList[n];

		for (int i = 0; i < n; i++)
			graph[i] = new LinkedList<>();

		for (int i = 1; i < n; i++)
			graph[parent[i]].add(i);

		dfs(graph, s, 0);

		return result;
	}

	private int dfs(List<Integer>[] graph, String s, int current) {
		List<Integer> children = graph[current];
		int sum = 0, maxChild = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // we would use a Priority Queue to keep only top 2
																	// Elements as these Top 2 can be a Candidate for
																	// Longest Running path for any Node
		for (int child : children) {
			if (s.charAt(child) != s.charAt(current)) {
				pq.offer(dfs(graph, s, child));
				if (pq.size() > 2) // keep only Max 2 Elements in our PQ
					pq.poll();
			} else
				dfs(graph, s, child);
		}

		for (int i = 0; !pq.isEmpty() && i < 2; i++) {
			maxChild = pq.peek(); // We would return the Longest path from our Child that return max non Adjacent
									// path
			sum += pq.poll();
		}

		result = Math.max(result, sum + 1);
		return maxChild + 1;
	}

}
