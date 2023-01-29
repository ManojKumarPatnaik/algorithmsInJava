package My_Learning.LeetCodeQuestions;

public class BST2SumLeetCode653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		BSTIterator l = new BSTIterator(root, false);
		BSTIterator r = new BSTIterator(root, true);

		int i = l.next();
		int j = r.next();
		while (i < j) {
			if (i + j == k)
				return true;
			else if (i + j < k)
				i = l.next();
			else
				j = r.next();
		}
		return false;
	}
}
