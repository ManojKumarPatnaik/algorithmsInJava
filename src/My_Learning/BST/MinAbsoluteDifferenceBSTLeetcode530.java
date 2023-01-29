package My_Learning.BST;

public class MinAbsoluteDifferenceBSTLeetcode530 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int min_abs = Integer.MAX_VALUE;
	private TreeNode prev = null;

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null) {
			int diff = Math.abs(root.val - prev.val);
			min_abs = Math.min(min_abs, diff);
		}
		prev = root;
		inorder(root.right);
	}

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return min_abs;
	}

}
