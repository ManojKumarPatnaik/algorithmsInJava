package My_Learning.recusrion;

public class PathSumLeetCode112 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Added Leetcode daily solution
	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
                
        return isPathExists(root, targetSum);
    }
    
    public boolean isPathExists(TreeNode root, int sum){
        
        if(root==null) return false;
        
        if(root.left==null && root.right==null && sum-root.val==0) return true;
        
       return isPathExists(root.left, sum - root.val) || isPathExists(root.right, sum - root.val);
    
        
    }

}
