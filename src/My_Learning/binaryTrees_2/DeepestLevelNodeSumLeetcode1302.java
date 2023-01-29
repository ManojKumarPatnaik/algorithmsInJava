package My_Learning.binaryTrees_2;

public class DeepestLevelNodeSumLeetcode1302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class LevelAndSum {
		int level;
		int sum;

		public LevelAndSum(int level, int sum) {
			this.level = level;
			this.sum = sum;
		}
	}

	public int deepestLeavesSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		return recursion(root).sum;
	}

	private LevelAndSum recursion(TreeNode root) {
		if (root == null) {
			return new LevelAndSum(0, 0);
		}
		if (root.left == null && root.right == null) {
			return new LevelAndSum(1, root.val);
		}
		LevelAndSum left = recursion(root.left);
		LevelAndSum right = recursion(root.right);
		if (left.level == right.level) {
			return new LevelAndSum(left.level + 1, left.sum + right.sum);
		} else if (left.level > right.level) {
			return new LevelAndSum(left.level + 1, left.sum);
		} else {
			return new LevelAndSum(right.level + 1, right.sum);
		}
	}

}
