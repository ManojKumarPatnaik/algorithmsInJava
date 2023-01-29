package My_Learning.BST;

public class ConvertSortedArrToBSTLeetcode108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return findans(nums, 0, nums.length - 1);
	}

	private TreeNode findans(int[] nums, int left, int right) {
		if (right < left)
			return null; // base case

		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]); // make a node and call recursion

		TreeNode leftSubtree = findans(nums, left, mid - 1);

		TreeNode rightSubtree = findans(nums, mid + 1, right);
		// after recursion we expect that we have left and right subtree so now join
		// them
		root.left = leftSubtree;
		root.right = rightSubtree;
		return root;
	}

}
