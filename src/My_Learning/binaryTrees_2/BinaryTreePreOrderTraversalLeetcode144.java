package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversalLeetcode144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode solution 
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder = new ArrayList<>();
		getPreOrder(root, preorder);
		return preorder;
	}

	public void getPreOrder(TreeNode root, List<Integer> preorder) {
		if (root == null)
			return;

		preorder.add(root.val);
		getPreOrder(root.left, preorder);
		getPreOrder(root.right, preorder);
		return;
	}
}
