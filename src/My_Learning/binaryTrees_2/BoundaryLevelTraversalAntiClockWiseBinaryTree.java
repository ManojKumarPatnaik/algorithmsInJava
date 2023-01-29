package My_Learning.binaryTrees_2;

import java.util.ArrayList;

public class BoundaryLevelTraversalAntiClockWiseBinaryTree {
	
	/*
	 * int val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) {
	 * this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val
	 * = val; this.left = left; this.right = right; }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 Boolean isLeaf(TreeNode root) {
	        return (root.left == null) && (root.right == null);
	    }
	    
	    void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
	        TreeNode cur = root.left;
	        while (cur != null) {
	            if (isLeaf(cur) == false) res.add(cur.val);
	            if (cur.left != null) cur = cur.left;
	            else cur = cur.right;
	        }
	    }
	    void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
	        TreeNode cur = root.right;
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        while (cur != null) {
	            if (isLeaf(cur) == false) tmp.add(cur.val);
	            if (cur.right != null) cur = cur.right;
	            else cur = cur.left;
	        }
	        int i;
	        for (i = tmp.size()-1; i >= 0; --i) {
	            res.add(tmp.get(i));
	        }
	    }
	    
	    void addLeaves(TreeNode root, ArrayList<Integer> res) {
	        if (isLeaf(root)) {
	            res.add(root.val);
	            return;
	        }
	        if (root.left != null) addLeaves(root.left, res);
	        if (root.right != null) addLeaves(root.right, res);
	    }
		ArrayList <Integer> printBoundary(TreeNode TreeNode)
		{
		    ArrayList<Integer> ans = new ArrayList<Integer>(); 
		    if(isLeaf(TreeNode) == false) ans.add(TreeNode.val); 
		    addLeftBoundary(TreeNode, ans); 
		    addLeaves(TreeNode, ans); 
		    addRightBoundary(TreeNode, ans); 
		    return ans;
		}

}
