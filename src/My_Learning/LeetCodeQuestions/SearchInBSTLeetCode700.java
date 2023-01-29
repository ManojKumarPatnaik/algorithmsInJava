package My_Learning.LeetCodeQuestions;

public class SearchInBSTLeetCode700 {
	/*
	 * You are given the root of a binary search tree (BST) and an integer val.
	 * 
	 * Find the node in the BST that the node's value equals val and return the
	 * subtree rooted with that node. If such a node does not exist, return null.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}
		return root;
	}
}
