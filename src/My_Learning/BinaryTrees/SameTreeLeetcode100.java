package My_Learning.BinaryTrees;

public class SameTreeLeetcode100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return (p == q);
		}
		return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
