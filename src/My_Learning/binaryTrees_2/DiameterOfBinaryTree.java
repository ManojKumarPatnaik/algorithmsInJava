package My_Learning.binaryTrees_2;

public class DiameterOfBinaryTree {
	
	/*
	 * Example 1:
	 * 
	 * 
	 * Input: root = [1,2,3,4,5] Output: 3 Explanation: 3 is the length of the path
	 * [4,2,1,3] or [5,2,1,3]. Example 2:
	 * 
	 * Input: root = [1,2] Output: 1
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

}
