package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversalLeetcode145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode solution
	private void helper(TreeNode root, List<Integer> post) {
		if (root == null)
			return;

		helper(root.left, post);
		helper(root.right, post);

		post.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> post = new ArrayList<>();
		helper(root, post);
		return post;
	}

}
