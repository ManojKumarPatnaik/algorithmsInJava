package My_Learning.BinaryTrees;

public class BinaryTreeCloneAtNodeLeetcode1379 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode ans = null;
	boolean flg = false;

	public void recursion(TreeNode original, TreeNode cloned, TreeNode target) {
		if (flg == true)
			return;
		if (original != null) {
			recursion(original.left, cloned.left, target);
			if (original == target) {
				// if we found node that is target
				// then we required the node in cloned thats it
				ans = cloned;
				flg = true;
				return;
			}
			recursion(original.right, cloned.right, target);
		}
	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		recursion(original, cloned, target);
		return ans;
	}
}
