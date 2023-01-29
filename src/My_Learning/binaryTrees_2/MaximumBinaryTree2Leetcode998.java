package My_Learning.binaryTrees_2;

public class MaximumBinaryTree2Leetcode998 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to get max binary tree
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root == null)
			return null;

		if (root.val < val) {
			TreeNode node = new TreeNode(val);
			node.left = root;
			return node;
		} else {
			if (root.right != null) {
				root.right = insertIntoMaxTree(root.right, val);
			} else {
				root.right = new TreeNode(val);
			}
		}
		return root;
	}

}
