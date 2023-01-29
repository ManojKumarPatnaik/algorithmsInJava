package My_Learning.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class SubtreeOfAnotherTreeLeetCode572 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		Queue<TreeNode> nodes = new ArrayDeque<>();
		nodes.offer(s);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			if (isSameTree(node, t)) {
				return true;
			}
			if (node.left != null) {
				nodes.offer(node.left);
			}
			if (node.right != null) {
				nodes.offer(node.right);
			}
		}
		return false;
	}

	public boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val != t.val) {
			return false;
		} else {
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		}
	}

/*	For each node during pre-order traversal
	of s, use a recursive
	function isSame to validate if sub-tree started with this
	node is the same with t.*/

	public boolean isSubtreeR(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		if (isSame(s, t))
			return true;
		return isSubtreeR(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;

		if (s.val != t.val)
			return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
}

