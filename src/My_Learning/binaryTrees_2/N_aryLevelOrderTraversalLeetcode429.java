package My_Learning.binaryTrees_2;

import com.ujjwal_Learning.binaryTrees_2.MaximumHeightNaryTreeLeetCode559.Node;

import java.util.*;

public class N_aryLevelOrderTraversalLeetcode429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return Collections.emptyList();
		}
		Queue<Node> nodes = new LinkedList<>();
		List<List<Integer>> values = new ArrayList<>();
		nodes.offer(root);
		while (!nodes.isEmpty()) {
			int levelSize = nodes.size();
			List<Integer> value = new ArrayList<>(levelSize);
			for (int i = 0; i < levelSize; i++) {
				Node current = nodes.poll();
				for (Node n : current.children) {
					nodes.offer(n);
				}
				value.add(current.val);
			}
			values.add(value);
		}
		return values;
	}

}
