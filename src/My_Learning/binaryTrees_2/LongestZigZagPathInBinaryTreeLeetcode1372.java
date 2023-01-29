package My_Learning.binaryTrees_2;

public class LongestZigZagPathInBinaryTreeLeetcode1372 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxStep = 0;

	public int longestZigZag(TreeNode root) {
		dfs(root, true, 0);
		dfs(root, false, 0);
		return maxStep;
	}

	private void dfs(TreeNode root, boolean isLeft, int step) {
		if (root == null)
			return;
		maxStep = Math.max(maxStep, step); // update max step sofar
		if (isLeft) {
			dfs(root.left, false, step + 1); // keep going from root to left
			dfs(root.right, true, 1); // restart going from root to right
		} else {
			dfs(root.right, true, step + 1); // keep going from root to right
			dfs(root.left, false, 1); // restart going from root to left
		}
	}

}
