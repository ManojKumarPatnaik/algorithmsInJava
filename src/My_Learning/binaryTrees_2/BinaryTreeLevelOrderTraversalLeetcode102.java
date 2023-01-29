package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalLeetcode102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to retrive level order 
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				List<Integer> innerList = new ArrayList<>();
				int count = q.size();
				for (int i = 0; i < count; i++) {
					TreeNode temp = q.poll();
					innerList.add(temp.val);
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				}
				l.add(innerList);
			}
		}
		return l;
	}

}
