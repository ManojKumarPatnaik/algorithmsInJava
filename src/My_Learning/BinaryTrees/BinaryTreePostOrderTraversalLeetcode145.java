package My_Learning.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversalLeetcode145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// added method to fetch PostOrder Traversal Left Right Root
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
