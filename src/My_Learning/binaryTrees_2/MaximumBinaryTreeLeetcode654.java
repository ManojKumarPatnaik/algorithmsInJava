package My_Learning.binaryTrees_2;

public class MaximumBinaryTreeLeetcode654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return solution(nums, 0, nums.length - 1);
	}

	TreeNode solution(int[] nums, int lo, int hi) {
		if (lo > hi)
			return null;
		int largest = findLargest(nums, lo, hi);
		TreeNode node = new TreeNode(nums[largest]);
		node.left = solution(nums, lo, largest - 1);
		node.right = solution(nums, largest + 1, hi);

		return node;
	}

	int findLargest(int nums[], int lo, int hi) {
		int largest = Integer.MIN_VALUE;
		int ans = -1;
		for (int i = lo; i <= hi; i++) {
			if (nums[i] > largest) {
				largest = nums[i];
				ans = i;
			}
		}
		return ans;
	}

}
