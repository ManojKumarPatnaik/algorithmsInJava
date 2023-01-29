package My_Learning.BinaryTrees;

public class MaximumDifferenceBetweennodeAncestorLeetcode1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//root = [8,3,10,1,6,null,14,null,null,4,7,13]
		TreeNode root = new TreeNode(8);
		// LeftSubTree
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		
		// Right subtree
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		System.out.println(" Max Difference :: "+String.valueOf(maxAncestorDiff(root)));

	}

	// We pass the minimum and maximum values to the children,
	// At the leaf node, we return max - min through the path from the root to the
	// leaf.
	public static int maxAncestorDiff(TreeNode root) {
		return dfs(root, root.val, root.val);
	}

	public static int dfs(TreeNode root, int mn, int mx) {
		if (root == null)
			return mx - mn;
		mx = Math.max(mx, root.val);
		mn = Math.min(mn, root.val);
		return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
	}

}
