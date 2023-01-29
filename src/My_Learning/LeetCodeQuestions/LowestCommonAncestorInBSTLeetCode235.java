package My_Learning.LeetCodeQuestions;

public class LowestCommonAncestorInBSTLeetCode235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// implement using loop to reduce space complexity

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		int curr = root.val;
		if (curr < p.val && curr < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if (curr > p.val && curr > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		return root;
	}

}
