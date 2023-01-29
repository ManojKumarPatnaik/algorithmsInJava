package My_Learning.BinaryTrees;

public class SmallestSubtreeWithAllDeepestNodeLeetCode865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) {
			return null;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if (leftDepth == rightDepth) {
			return root;
		} else {
			if (leftDepth > rightDepth) {
				return subtreeWithAllDeepest(root.left);
			} else {
				return subtreeWithAllDeepest(root.right);
			}
		}
	}

	public int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getDepth(node.left), getDepth(node.right));
	}

}
