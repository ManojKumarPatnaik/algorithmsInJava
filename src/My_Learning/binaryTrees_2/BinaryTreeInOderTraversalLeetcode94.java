package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOderTraversalLeetcode94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();

		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				inorder.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur) {
					prev = prev.right;
				}

				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					prev.right = null;
					inorder.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return inorder;
	}

	// recursively
	public List<Integer> inorderTraversal1(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    dfs(root, ret);
	    return ret;
	}

	private void dfs(TreeNode node, List<Integer> ret) {
	    if (node != null) {
	        dfs(node.left, ret);
	        ret.add(node.val);
	        dfs(node.right, ret);
	    }
	}
	
	// iteratively
	public List<Integer> inorderTraversalItr(TreeNode root) {
	   Stack<TreeNode> stack = new Stack<>();
	   List<Integer> ret = new ArrayList<>();
	   while (true) {
	       while (root != null) {
	           stack.push(root);
	           root = root.left;
	       }
	       if (stack.isEmpty()) {
	           break;  // no node left
	       }
	       TreeNode node = stack.pop();
	       ret.add(node.val);
	       root = node.right;
	   }
	   return ret;
	}

}
