package My_Learning.binaryTrees_2;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodeWithEvenValuedgrandParentleetcode1315 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumEvenGrandparent(TreeNode root) {
		int sum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		// LevelOrderTraversal
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null) {
				q.add(node.left);
				if (node.val % 2 == 0) {
					if (node.left.left != null) {
						sum += node.left.left.val;
					}
					if (node.left.right != null) {
						sum += node.left.right.val;
					}
				}
			}

			if (node.right != null) {
				q.add(node.right);
				if (node.val % 2 == 0) {
					if (node.right.left != null) {
						sum += node.right.left.val;
					}
					if (node.right.right != null) {
						sum += node.right.right.val;
					}
				}
			}
		}

		return sum;
	}

}
