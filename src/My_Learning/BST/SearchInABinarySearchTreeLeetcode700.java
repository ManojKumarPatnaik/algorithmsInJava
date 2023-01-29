package My_Learning.BST;

public class SearchInABinarySearchTreeLeetcode700 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}
		return root;
	}

}
