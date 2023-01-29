package My_Learning.BST;

public class ConverteBSTtoGreaterTreeLeetcode538 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int ans = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		convertBST(root.right);
		ans += root.val;
		root.val = ans;
		convertBST(root.left);
		return root;
	}
}
