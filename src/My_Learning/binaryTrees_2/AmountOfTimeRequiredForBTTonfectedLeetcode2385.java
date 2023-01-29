package My_Learning.binaryTrees_2;

import java.util.ArrayList;

public class AmountOfTimeRequiredForBTTonfectedLeetcode2385 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<ArrayList<Integer>> ans;

	public void burn(TreeNode root, int time, TreeNode exc) {

		if (root == null || root == exc)
			return;
		if (ans.size() == time)
			ans.add(new ArrayList<>());
		ans.get(time).add(root.val);
		burn(root.left, time + 1, exc);
		burn(root.right, time + 1, exc);
	}

	public int helper(TreeNode root, int tar) {

		if (root == null)
			return -1;
		if (root.val == tar) {
			burn(root, 0, null);
			return 1;
		}
		int lf = helper(root.left, tar);
		if (lf != -1) {
			burn(root, lf, root.left);
			return lf + 1;
		}
		int rh = helper(root.right, tar);
		if (rh != -1) {
			burn(root, rh, root.right);
			return rh + 1;
		}
		return -1;
	}

	public int amountOfTime(TreeNode root, int start) {
		ans = new ArrayList<>();
		helper(root, start);
		return ans.size() - 1;
	}

}
