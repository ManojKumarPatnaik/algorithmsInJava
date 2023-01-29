package My_Learning.binaryTrees_2;

public class BinaryTreePurningLeetcode814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null && root.val == 0)
			return null;
		return root;
	}

}
