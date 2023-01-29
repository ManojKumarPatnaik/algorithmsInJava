package My_Learning.binaryTrees_2;

public class SumOfRootToLeafsLeetcode1022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumRootToLeaf(TreeNode root) {
		dfs(root, 0);
		return ans;
	}

	int ans = 0;

	void dfs(TreeNode root, int val) {
		if (root == null)
			return;
		val = val << 1 | root.val;
		if (root.left == null && root.right == null)
			ans += val;
		dfs(root.left, val);
		dfs(root.right, val);
	}

}
