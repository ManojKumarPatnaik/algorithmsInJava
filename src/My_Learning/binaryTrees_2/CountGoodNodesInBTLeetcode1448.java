package My_Learning.binaryTrees_2;

public class CountGoodNodesInBTLeetcode1448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int good;

	public int goodNodes(TreeNode root) {
		good = 0;
		cal(root, Integer.MIN_VALUE);
		return good;
	}

	void cal(TreeNode root, int max) {
		if (root == null)
			return;
		if (root.val >= max)
			good++;
		max = Math.max(max, root.val);
		cal(root.left, max);
		cal(root.right, max);
	}

}
