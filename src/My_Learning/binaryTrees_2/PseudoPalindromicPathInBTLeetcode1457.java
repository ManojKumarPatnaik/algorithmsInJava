package My_Learning.binaryTrees_2;

public class PseudoPalindromicPathInBTLeetcode1457 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;

	public int pseudoPalindromicPaths(TreeNode root) {
		int[] map = new int[10];
		findPesudoPalindromUtil(root, map);
		return result;
	}

	void findPesudoPalindromUtil(TreeNode root, int[] map) {

		if (root == null) {
			return;
		}
		map[root.val] = map[root.val] + 1;
		if (root.left == null && root.right == null) {
			if (isPalindrome(map))
				result++;
		}

		findPesudoPalindromUtil(root.left, map);
		findPesudoPalindromUtil(root.right, map);
		// backtrack
		map[root.val] = map[root.val] - 1;

	}

	boolean isPalindrome(int[] map) {
		int miss = 0;
		for (int i = 0; i <= 9; i++) {
			if (map[i] % 2 != 0)
				miss++;
			if (miss > 1)
				return false;
		}
		return true;
	}

}
