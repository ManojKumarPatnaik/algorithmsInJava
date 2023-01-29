package My_Learning.binaryTrees_2;

public class MaximumHeightBinayTreeLeetCode104 {
	
	/*
	 * Example 1:
	 * 		   3
	 * 		   /\
	 *        9   20
	 *        /\  / \
	 *        n	n 15 7 
	 * 
	 * 
	 * Input: root = [3,9,20,null,null,15,7] Output: 3 Example 2: 
	 * 
	 * Input: root = [1,null,2] Output: 2
	 */
	
	//====================================================
	// LeetCode Template
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	/*
	 * class Solution { public int maxDepth(TreeNode root) { if(root==null) return
	 * 0;
	 * 
	 * return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
	 * 
	 * } }
	 */
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        
        int lh = maxDepth(root.left); 
        int rh = maxDepth(root.right); 
        
        return 1 + Math.max(lh, rh); 
    }

}
