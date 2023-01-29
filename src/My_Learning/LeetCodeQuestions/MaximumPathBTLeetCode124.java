package My_Learning.LeetCodeQuestions;

public class MaximumPathBTLeetCode124 {
	
	/*
	 * A path in a binary tree is a sequence of nodes where each pair of adjacent
	 * nodes in the sequence has an edge connecting them. A node can only appear in
	 * the sequence at most once. Note that the path does not need to pass through
	 * the root.
	 * 
	 * The path sum of a path is the sum of the node's values in the path.
	 * 
	 * Given the root of a binary tree, return the maximum path sum of any non-empty
	 * path.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Example 1:
	 * 
	 * 
	 * Input: root = [1,2,3] Output: 6 Explanation: The optimal path is 2 -> 1 -> 3
	 * with a path sum of 2 + 1 + 3 = 6. Example 2:
	 * 
	 * 
	 * Input: root = [-10,9,20,null,null,15,7] Output: 42 Explanation: The optimal
	 * path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
	 * 
	 * 
	 * Constraints:
	 * 
	 * The number of nodes in the tree is in the range [1, 3 * 104].
	 */
	public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1]; 
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    
    private int maxPathDown(TreeNode node, int maxValue[]) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
