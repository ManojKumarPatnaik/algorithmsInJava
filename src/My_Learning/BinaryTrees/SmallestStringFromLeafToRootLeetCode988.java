package My_Learning.BinaryTrees;

public class SmallestStringFromLeafToRootLeetCode988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private String ans = "~"; // dummy value '~' > 'z'

	public String smallestFromLeaf(TreeNode root) {
		return dfs(root, "");
	}

	private String dfs(TreeNode n, String str) {
		if (n == null) {
			return str;
		} // base case, and in case root is null.
		
		str = (char) (n.val + 'a') + str; // prepend current char to the path string from root.
		
		if (n.left == null && n.right == null && ans.compareTo(str) > 0) {
			ans = str;
		} // update ans if n is a leaf.
		
		
		dfs(n.left, str); // recursion to the left branch.
		dfs(n.right, str); // recursion to the right branch.
		
		return ans;
	}
}
