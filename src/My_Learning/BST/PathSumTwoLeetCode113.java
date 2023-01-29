package My_Learning.BST;

import java.util.ArrayList;
import java.util.List;

public class PathSumTwoLeetCode113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		if (root == null)
			return ans;

		solve(root, targetSum, ans, new ArrayList<>());
		return ans;
	}

	private void solve(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> ds) {

		ds.add(root.val);
		if (root.left == null && root.right == null)
			if (targetSum == root.val)
				ans.add(new ArrayList<Integer>(ds));
		if (root.left != null)
			solve(root.left, targetSum - root.val, ans, ds);
		if (root.right != null)
			solve(root.right, targetSum - root.val, ans, ds);
		ds.remove(ds.size() - 1);
	}

}
