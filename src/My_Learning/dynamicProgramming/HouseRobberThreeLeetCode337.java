package My_Learning.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberThreeLeetCode337 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob1(TreeNode root) {
		if (root == null)
			return 0;

		int ans = 0;

		// max value from left grandchildren
		if (root.left != null) {
			ans += rob(root.left.left) + rob(root.left.right);
		}

		// max value from right grandchildren
		if (root.right != null) {
			ans += rob(root.right.left) + rob(root.right.right);
		}

		return Math.max(ans + root.val, rob(root.left) + rob(root.right)); // (Case1,Case2)
	}

	public int rob2(TreeNode root) {
		return rob(root, new HashMap<>());
	}

	public int rob(TreeNode root, Map<TreeNode, Integer> map) {

		if (root == null)
			return 0;

		if (map.containsKey(root))
			return map.get(root);

		int ans = 0;

		if (root.left != null) {
			ans += rob(root.left.left, map) + rob(root.left.right, map);
		}

		if (root.right != null) {
			ans += rob(root.right.left, map) + rob(root.right.right, map);
		}

		ans = Math.max(ans + root.val, rob(root.left, map) + rob(root.right, map));
		map.put(root, ans);

		return ans;
	}

	public int rob(TreeNode root) {
		int ans[] = robHouse(root);
		return Math.max(ans[0], ans[1]);
	}

	public int[] robHouse(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int left[] = robHouse(root.left);
		int right[] = robHouse(root.right);

		int ans[] = new int[2];

		ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		ans[1] = root.val + left[0] + right[0];

		return ans;
	}
}
