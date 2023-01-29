package My_Learning.LeetCodeQuestions;

public class InOrderPredessorBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Inorder predecessor is the node which traversed before given node in inorder
	 * traversal of binary tree. In binary search tree, it�s the previous big value
	 * before a node.
	 */

	public TreeNode inorderPredessor(TreeNode root, TreeNode p) {

		TreeNode inorderPredessorVal = null;

		while (root != null) {

			if (root.val >= p.val) {
				root = root.left;
			} else {
				inorderPredessorVal = root;
				root = root.right;
			}
		}

		return inorderPredessorVal;
	}
}
