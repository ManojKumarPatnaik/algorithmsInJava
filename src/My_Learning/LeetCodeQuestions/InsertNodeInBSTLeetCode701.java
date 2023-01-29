package My_Learning.LeetCodeQuestions;

public class InsertNodeInBSTLeetCode701 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetode daily solution
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode cur = root;
		while (true) {
			if (cur.val <= val) {
				if (cur.right != null)
					cur = cur.right;
				else {
					cur.right = new TreeNode(val);
					break;
				}
			} else {
				if (cur.left != null)
					cur = cur.left;
				else {
					cur.left = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}

}
