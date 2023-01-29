package My_Learning.BinaryTrees;

import java.util.*;

public class TopViewTraversalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Imported TreeNode, Pair class userdefined not default

	// Function to return a list of TreeNodes visible from the top view
	// from left to right in Binary Tree.
	static ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<Pair>();

		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair it = q.remove();
			int hd = it.vertical;
			TreeNode temp = it.node;
			if (map.get(hd) == null)
				map.put(hd, temp.val);
			if (temp.left != null) {

				q.add(new Pair(temp.left, hd - 1));
			}
			if (temp.right != null) {

				q.add(new Pair(temp.right, hd + 1));
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;

	}
}
