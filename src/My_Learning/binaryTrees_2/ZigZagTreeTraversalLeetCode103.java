package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTreeTraversalLeetCode103 {
	/*
	 * Example 1:
	 * 
	 * 
	 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]] Example 2:
	 * 
	 * Input: root = [1] Output: [[1]] Example 3:
	 * 
	 * Input: root = [] Output: []
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        boolean flag = true; 
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>(levelNum);
            for(int i=0; i<levelNum; i++) {
                //int index = i;
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(flag == true) subList.add(queue.poll().val);
                else subList.add(0, queue.poll().val);
            }
            flag = !flag; 
            wrapList.add(subList);
        }
        return wrapList;
    }

}
