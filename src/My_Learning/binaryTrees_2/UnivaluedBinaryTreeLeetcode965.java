package My_Learning.binaryTrees_2;

public class UnivaluedBinaryTreeLeetcode965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int val = -1;

	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;
		if (val < 0)
			val = root.val;
		return root.val == val && isUnivalTree(root.left) && isUnivalTree(root.right);
	}

}
