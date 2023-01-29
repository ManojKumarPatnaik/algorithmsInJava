package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNodeWithHighestScoreLeetcode2049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		int val;
		Node left;
		Node right;

		Node(int v) {
			val = v;
			left = right = null;
		}
	}

	int N;
	Map<Long, Long> map = new HashMap<>();
	long max = 0;

	public long dfs(Node node) {
		if (node == null)
			return 0;
		long count = 1;
		long left = dfs(node.left);
		long right = dfs(node.right);

		long prod = (long) (Math.max(1, left) * Math.max(1, right) * Math.max(1, (N - (left + right + 1))));
		map.put(prod, map.getOrDefault(prod, 0L) + 1L);
		max = Math.max(max, prod);
		// return number of nodes in current node's subtree
		return count + left + right;
	}

	public int countHighestScoreNodes(int[] parents) {
		int n = parents.length;
		N = n;
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nodes.add(new Node(i));
		}
		// create your binary tree
		for (int i = 1; i < n; i++) {

			Node p = nodes.get(parents[i]);
			if (p.left == null) {
				p.left = nodes.get(i);
			} else {
				p.right = nodes.get(i);
			}
		}
		// perform post-order traversal
		dfs(nodes.get(0));

		long x = map.get(max);
		return (int) x;

	}

}
