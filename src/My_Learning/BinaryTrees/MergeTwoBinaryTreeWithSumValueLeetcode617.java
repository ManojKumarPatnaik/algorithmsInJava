package My_Learning.BinaryTrees;

public class MergeTwoBinaryTreeWithSumValueLeetcode617 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		// root
		if (root1 == null)
			return root2;

		if (root2 == null)
			return root1;

		// ROOT
		TreeNode node = new TreeNode(root1.val + root2.val);

		// LEFT
		node.left = mergeTrees(root1.left, root2.left);
		// RIGHT
		node.right = mergeTrees(root1.right, root2.right);

		return node;
	}

}
