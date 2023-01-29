package My_Learning.BST;

public class RangeSumBSTLeetcode938 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// added method to fetch inclusive range sum [L,R]
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;
		if (root.val > R)
			return rangeSumBST(root.left, L, R);
		if (root.val < L)
			return rangeSumBST(root.right, L, R);
		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}

}
