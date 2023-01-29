package My_Learning.binaryTrees_2;

public class DistributeCoinsBinaryTreeLeetcode979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int moves = 0;

	public int distributeCoins(TreeNode root) {
		getNumAndCoins(root);
		return moves;
	}

	/*
	 * return [number_of_nodes_in_subtree, number_of_total_coins_in_subtree]
	 */
	private int[] getNumAndCoins(TreeNode node) {
		if (node == null)
			return new int[] { 0, 0 };
		int[] left = getNumAndCoins(node.left);
		int[] right = getNumAndCoins(node.right);
		moves += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);
		return new int[] { left[0] + right[0] + 1, left[1] + right[1] + node.val };
	}

}
