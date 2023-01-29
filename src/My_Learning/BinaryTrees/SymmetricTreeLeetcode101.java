package My_Learning.BinaryTrees;

public class SymmetricTreeLeetcode101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to check symmetricity
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

}
