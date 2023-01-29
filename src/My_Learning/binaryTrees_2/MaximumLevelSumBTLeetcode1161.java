package My_Learning.binaryTrees_2;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumBTLeetcode1161 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxLevelSum(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int level = 0;
		int minLevel = 0, maxSum = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			int levelSum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelSum += node.val;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			if (levelSum > maxSum) {
				maxSum = levelSum;
				minLevel = level;
			}
		}
		return minLevel;
	}

}
