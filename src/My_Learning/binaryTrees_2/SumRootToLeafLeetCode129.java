package My_Learning.binaryTrees_2;

public class SumRootToLeafLeetCode129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: root = [1,2,3]
//			Output: 25
//			Explanation:
//			The root-to-leaf path 1->2 represents the number 12.
//			The root-to-leaf path 1->3 represents the number 13.
//			Therefore, sum = 12 + 13 = 25.

	int total;

	public int sumNumbers(TreeNode root) {
		total = 0;
		helper(root, 0);
		return total;
	}

	void helper(TreeNode root, int sum) {
		if (root == null)
			return;

		sum = sum * 10 + root.val;

		if (root.left == null && root.right == null) {
			total += sum;
			return;
		}

		helper(root.left, sum);
		helper(root.right, sum);
	}

}
