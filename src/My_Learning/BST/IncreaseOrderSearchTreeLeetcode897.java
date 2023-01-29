package My_Learning.BST;

public class IncreaseOrderSearchTreeLeetcode897 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode prev = null, head = null;

	public TreeNode increasingBST(TreeNode root) {
		if (root == null)
			return null;
		increasingBST(root.left);
		if (prev != null) {
			root.left = null; // we no longer needs the left side of the node, so set it to null
			prev.right = root;
		}
		if (head == null)
			head = root; // record the most left node as it will be our root
		prev = root; // keep track of the prev node
		increasingBST(root.right);
		return head;
	}

}
