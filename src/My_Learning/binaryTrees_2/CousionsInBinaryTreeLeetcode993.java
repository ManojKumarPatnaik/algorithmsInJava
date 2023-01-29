package My_Learning.binaryTrees_2;

public class CousionsInBinaryTreeLeetcode993 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// - x & y cannot have the same parent, and must have equal depth from root
	public boolean isCousins(TreeNode root, int x, int y) {
		// should we get depth first? if depths don't match, return false
		if (getDepth(root, x, 0) != getDepth(root, y, 0)) {
			return false;
		}
		// if depth for x & y match, then we can get their parents and compare
		TreeNode xParent = getParent(root, x);
		TreeNode yParent = getParent(root, y);

		return xParent.val != yParent.val;
	}

	private TreeNode getParent(TreeNode root, int val) {
		if (root == null)
			return null;

		if ((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val)) {
			return root;
		}

		TreeNode leftParent = getParent(root.left, val);
		if (leftParent == null) {
			return getParent(root.right, val);
		}
		return leftParent;
	}

	private int getDepth(TreeNode root, int val, int currDepth) {
		if (root == null)
			return -1;

		if (root.val == val)
			return currDepth;

		currDepth++;
		int leftDepth = getDepth(root.left, val, currDepth);
		if (leftDepth > -1) {
			return leftDepth;
		} else {
			return getDepth(root.right, val, currDepth);
		}
	}

}
