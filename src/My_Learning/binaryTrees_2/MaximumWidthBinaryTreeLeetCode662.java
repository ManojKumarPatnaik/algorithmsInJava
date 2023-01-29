package My_Learning.binaryTrees_2;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBinaryTreeLeetCode662 {

	/*
	 * public class Pair {
	 * 
	 * TreeNode node; int num;
	 * 
	 * public Pair(TreeNode node, int num) { this.node = node; this.num = vertical;
	 * 		}
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int ans = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			
			int size = q.size();
			int mmin = q.peek().vertical; // vertical = number to pic //to make the id starting from zero
			int first = 0, last = 0;
			
			for (int i = 0; i < size; i++) {
				int cur_id = q.peek().vertical - mmin;
				TreeNode node = q.peek().node;
				q.poll();
				if (i == 0)
					first = cur_id;
				if (i == size - 1)
					last = cur_id;
				if (node.left != null)
					q.offer(new Pair(node.left, cur_id * 2 + 1));
				if (node.right != null)
					q.offer(new Pair(node.right, cur_id * 2 + 2));
			}
			ans = Math.max(ans, last - first + 1);
		}
		return ans;
	}

}
