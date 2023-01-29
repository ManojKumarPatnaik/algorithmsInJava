package My_Learning.binarySearch;

import com.My_Learning.BST.TreeNode;

import java.util.Stack;

public class BinarySearchIteratorLeetcode173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BinarySearchIteratorLeetcode173(TreeNode root) {
        pushAll(root);
    }

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		for (; node != null; stack.push(node), node = node.left)
			;
	}
}
