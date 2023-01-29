package My_Learning.BST;

import java.util.ArrayDeque;
import java.util.Queue;

public class TrimBSTLeetcode699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//DFS
	public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
      
        if(root.val>high){
            return trimBST(root.left,low,high);
        }else if(root.val<low){
            return trimBST(root.right,low,high);
        }else{
            TreeNode leftTrimmedSubtree = trimBST(root.left,low,high);
            TreeNode rightTrimmedSubtree = trimBST(root.right,low,high);
            
            root.left = leftTrimmedSubtree;
            root.right = rightTrimmedSubtree;
            return root;
        }
	}
	
	//BFS
	 public TreeNode trimBSTBFS(TreeNode root, int low, int high) {
         if(root==null) return null;
         while(root!=null){
            if(root.val>high) root = root.left;
            else if(root.val<low) root = root.right;
            else break;
         }
         if(root==null) return null;
        
         Queue<TreeNode[]> queue = new ArrayDeque();
         queue.add(new TreeNode[]{root,null}); 
        
         while(queue.size()>0){
             TreeNode arr[] = queue.remove();
             TreeNode node = arr[0];
             TreeNode par = arr[1];
             
             if(node.val<low){
                if(par.left==node){
                    par.left = node.right;
                }else{
                    par.right = node.right;
                }
                
                if(node.right!=null){
                    queue.add(new TreeNode[]{node.right,par});
                }
             }else if(node.val>high){
                if(par.left==node){
                    par.left = node.left;
                }else{
                    par.right = node.left;
                }
                
                if(node.left!=null){
                    queue.add(new TreeNode[]{node.left,par});
                }
             }else{
                if(node.left!=null){
                    queue.add(new TreeNode[]{node.left,node});
                }
                 
                if(node.right!=null){
                    queue.add(new TreeNode[]{node.right,node});
                } 
             }
         }
        
         return root;
    }
	 
	 //Constant Space
	 public TreeNode trimBSTConstantSpace(TreeNode root, int low, int high) {
         if(root==null) return null; // base check
         
         // find valid root
         while(root!=null){
            if(root.val>high) root = root.left;
            else if(root.val<low) root = root.right;
            else break;
         }
         if(root==null) return null;
         
         // remove invalid nodes from left subtree
         TreeNode dummy = root;
         
         while(dummy!=null){
             while(dummy.left!=null&&dummy.left.val<low){
                 dummy.left = dummy.left.right;
             }
             
             dummy = dummy.left;
         }
        
         // remove invalid nodes from right subtree
         dummy = root;
         
         while(dummy!=null){
             while(dummy.right!=null&&dummy.right.val>high){
                 dummy.right = dummy.right.left;
             }
             
             dummy = dummy.right;
         }
        
         return root;
    } 

}
