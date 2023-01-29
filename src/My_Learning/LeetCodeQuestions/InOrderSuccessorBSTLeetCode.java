package My_Learning.LeetCodeQuestions;

public class InOrderSuccessorBSTLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Definition-1 In Binary Tree, Inorder successor of a node is the next node in
	 * Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last
	 * node in Inorder traversal.
	 */

	/*
	 * Definition-2 In Binary Search Tree, Inorder Successor of an input node can
	 * also be defined as the node with the smallest key greater than the key of the
	 * input node. So, it is sometimes important to find next node in sorted order.
	 * 
	 * Simple way m bolu to In BST it is the next greater element after the given
	 * node
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		TreeNode successor = null;

		while (root != null) {

			if (p.val >= root.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}

		return successor;
	}

}
