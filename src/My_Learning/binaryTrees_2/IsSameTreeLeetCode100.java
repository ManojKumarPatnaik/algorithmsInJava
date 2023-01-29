package My_Learning.binaryTrees_2;

public class IsSameTreeLeetCode100 {
	/*
	 * Example 1:
	 * 
	 * 
	 * Input: p = [1,2,3], q = [1,2,3] Output: true Example 2:
	 * 
	 * 
	 * Input: p = [1,2], q = [1,null,2] Output: false Example 3:
	 * 
	 * 
	 * Input: p = [1,2,1], q = [1,1,2] Output: false
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q == null) {
            return (p==q); 
        } 
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
	
	public boolean isSameTree2(TreeNode p, TreeNode q) {
	    if(p == null && q == null) return true;
	    if(p == null || q == null) return false;
	    if(p.val == q.val)
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    return false;
	}
	
	public boolean isSameTree3(TreeNode p, TreeNode q) {
	    
	    // Equal nullity denotes that this branch is the same (local equality)
	    // This is a base case, but also handles being given two empty trees
	    if (p == null && q == null) return true;
	    
	    // Unequal nullity denotes that the trees aren't the same
	    // Note that we've already ruled out equal nullity above
	    else if (p == null || q == null) return false;
	        
	    // Both nodes have values; descend iff those values are equal
	    // "&&" here allows for any difference to overrule a local equality
	    if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    
	    // If we're here, both nodes have values, and they're unequal, so the trees aren't the same
	    return false;
	}
}
