package My_Learning.binaryTrees_2;

public class AdoneRowToTreeLeetcode623 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void dfs(TreeNode root, int depth, int v, int d) {
		if (root == null)
			return;
		if (depth < d - 1) {
			dfs(root.left, depth + 1, v, d);
			dfs(root.right, depth + 1, v, d);
		} else {
			TreeNode tmp = root.left;
			root.left = new TreeNode(v);
			root.left.left = tmp;
			tmp = root.right;
			root.right = new TreeNode(v);
			root.right.right = tmp;
		}
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode newroot = new TreeNode(v);
			newroot.left = root;
			return newroot;
		}
		dfs(root, 1, v, d);
		return root;
	}

}
