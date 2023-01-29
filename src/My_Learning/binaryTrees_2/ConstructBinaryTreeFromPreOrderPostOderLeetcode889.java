package My_Learning.binaryTrees_2;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderPostOderLeetcode889 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> postMap = new HashMap<>();

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		int length = pre.length;
		for (int i = 0; i < post.length; i++) {
			postMap.put(post[i], i);
		}

		return build(0, length - 1, 0, length - 1, pre, post);
	}

	private TreeNode build(int preLeft, int preRight, int postLeft, int postRight, int[] pre, int[] post) {
		if (preLeft > preRight || postLeft > postRight) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preLeft]);

		if (preLeft + 1 <= preRight) {
			int index = postMap.get(pre[preLeft + 1]);
			int sum = index - postLeft;
			root.left = build(preLeft + 1, preLeft + sum + 1, postLeft, postLeft + sum, pre, post);
			root.right = build(preLeft + sum + 2, preRight, postLeft + sum + 1, postRight - 1, pre, post);
		}

		return root;
	}

}
