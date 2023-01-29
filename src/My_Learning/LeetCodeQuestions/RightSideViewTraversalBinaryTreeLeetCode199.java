package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewTraversalBinaryTreeLeetCode199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

}
