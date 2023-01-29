package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalPreOrderInOrderLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) {
                inorder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left; 
                }
                else {
                    prev.right = null; 
                    inorder.add(cur.val); // after coming back print root
                    cur = cur.right; 
                }
            }
        }
        return inorder; 
    }
	
	public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) {
            	preOrder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur;
                    preOrder.add(cur.val); // while making thread i am at root and in PREORDER (Root left right)
                    cur = cur.left; 
                }
                else {
                    prev.right = null; 
                    
                    cur = cur.right; 
                }
            }
        }
        return preOrder; 
    }

}
