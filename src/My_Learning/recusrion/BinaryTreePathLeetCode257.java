package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathLeetCode257 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Input: root = [1,2,3,null,5]
//				Output: ["1->2->5","1->3"]
	}

	public List<String> binaryTreePaths(TreeNode root) {

		List<String> ans = new ArrayList<String>();

		if (root == null)
			return ans;

		getPath(root, ans, new String());

		return ans;
	}

	private void getPath(TreeNode root, List<String> ans, String ds) {
		if (root.left == null && root.right == null) {
			ans.add(new String(ds + root.val));

		}

		// Integer val = root.val;
		// String valS = val.toString();
		// ds += valS + "->";
		if (root.left != null)
			getPath(root.left, ans, ds + root.val + "->");
		if (root.right != null)
			getPath(root.right, ans, ds + root.val + "->");

	}

}
