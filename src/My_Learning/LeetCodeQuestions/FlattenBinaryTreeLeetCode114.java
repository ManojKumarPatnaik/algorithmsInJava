package My_Learning.LeetCodeQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBinaryTreeLeetCode114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// method -1
	TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}

	// method - 2
	public void flatten2(TreeNode root) {
		if (root == null)
			return;

		Deque<TreeNode> st = new ArrayDeque<>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode cur = st.peek();
			st.pop();

			if (cur.right != null) {
				st.push(cur.right);
			}
			if (cur.left != null) {
				st.push(cur.left);
			}
			if (!st.isEmpty()) {
				cur.right = st.peek();
			}
			cur.left = null;
		}

	}

	// Leetcode daily question
	public void flatten3(TreeNode root) { // O(n) +<
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode pre = cur.left;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}
}
