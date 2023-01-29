package My_Learning.BinaryTrees;

public class ConstructStringFromBTLeetcode606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	String str = "";

	public String tree2str(TreeNode root) {
		madeString(root);
		return str;

	}

	public void madeString(TreeNode root) {
		if (root == null)
			return;
		str += root.val + "";

		if (root.left != null) {
			str += "(";
			madeString(root.left);
			str += ")";
		} else if (root.left == null && root.right != null) {
			str += "()";
		}

		if (root.right != null) {
			str += "(";
			madeString(root.right);
			str += ")";
		}

	}
}
