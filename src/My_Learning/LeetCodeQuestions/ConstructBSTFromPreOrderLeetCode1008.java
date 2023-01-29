package My_Learning.LeetCodeQuestions;

public class ConstructBSTFromPreOrderLeetCode1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added method to generate BST from Pre-order
	public TreeNode bstFromPreorder(int[] A) {
		return bstFromPreorder(A, Integer.MAX_VALUE, new int[] { 0 });
	}

	public TreeNode bstFromPreorder(int[] A, int bound, int[] i) {
		if (i[0] == A.length || A[i[0]] > bound)
			return null;
		TreeNode root = new TreeNode(A[i[0]++]);
		root.left = bstFromPreorder(A, root.val, i);
		root.right = bstFromPreorder(A, bound, i);
		return root;
	}

	/*
	 * method - 2 so we follow steps: 1>we create the node 2>we traverse the array
	 * for values which are less than the current node!-- these values will become
	 * our left subtree.we stop whenever we get a value larger than the current root
	 * of the subtree! 3>we take the rest of the array(values whuch are greater than
	 * the value of the current root)-these are the values which will make out right
	 * subtree!
	 * 
	 * so we make a root! make the left subtree(recursively) then make right
	 * subtree(recursively)
	 */

	public TreeNode bstFromPreorder2(int[] preorder) {
		return helper(preorder, 0, preorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int start, int end) {
		if (start > end)
			return null;

		TreeNode node = new TreeNode(preorder[start]);
		int i;
		for (i = start; i <= end; i++) {
			if (preorder[i] > node.val)
				break;
		}

		node.left = helper(preorder, start + 1, i - 1);
		node.right = helper(preorder, i, end);
		return node;

	}

	/*
	 * APPROACH 1-O(N) JAVA-LOWER AND UPPER BOUND RECURSIVE
	 */
	int nodeIndex;

	public TreeNode bstFromPreorder3(int[] preorder) {
		if (preorder == null) {
			return null;
		}
		nodeIndex = 0;
		return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode bstHelper(int[] preorder, int start, int end) {
		if (nodeIndex == preorder.length || preorder[nodeIndex] < start || preorder[nodeIndex] > end) {
			return null;
		}
		int val = preorder[nodeIndex++];
		TreeNode node = new TreeNode(val);
		node.left = bstHelper(preorder, start, val);
		node.right = bstHelper(preorder, val, end);
		return node;
	}

	/*
	 * APPROACH 2- O(N)! JAVA ONLY UPPER BOUND- RECURSIVE EXPLANATION- Every node
	 * has an upper bound.
	 * 
	 * Left node is bounded by the parent node's value. Right node is bounded by the
	 * ancestor's bound. Using the example in the question: The nodes [5, 1, 7] are
	 * all bounded by 8. The node 1 is bounded by 5. 8 is the root node, but if you
	 * think deeper about it, it is bounded by Integer.MAX_VALUE. i.e. imagine there
	 * is a root parent node Integer.MAX_VALUE with left node being 8. This also
	 * means that both 10 and 12 nodes, which are also right nodes, are also bounded
	 * by Integer.MAX_VALUE. We use a recursive function together with an outer
	 * index variable i to traverse and construct the tree. When we create a tree
	 * node, we increment i to process the next element in the preorder array.
	 * 
	 * We don't need to care about lower bound. When we construct the tree, we try
	 * to create left node first. If the condition fails (i.e. current number is
	 * greater than the parent node value), then we try to create the right node
	 * which automatically satisfies the condition, hence no lower bound is needed
	 */
	int i = 0;

	public TreeNode bstFromPreorder4(int[] arr) {
		return helper(arr, Integer.MAX_VALUE);
	}

	public TreeNode helper(int[] arr, int bound) {
		if (i == arr.length || arr[i] > bound)
			return null;
		TreeNode root = new TreeNode(arr[i++]);
		root.left = helper(arr, root.val);
		root.right = helper(arr, bound);
		return root;
	}
	/*
	 * EXPLANATON-
	 * "explanation- It is  possible to do this because when we construct the " left
	 * child " the upper bound will be the node value itself and no lower bound will
	 * be needed! -no lower bound is required for "right child" because we have
	 * arrived at this point of creating the right child only because these elements
	 * failed to satisfy the left subtree conditions!"
	 */

	/*
	 * method - 4 APPROACH 4-IF YOU ARE NOT COMFORTABLE WITH RECURSION! JAVA
	 * ITERATIVE APPROACH
	 */

	public TreeNode bstFromPreorder5(int[] preorder) {

		if (preorder == null) {
			return null;
		}
		int size = preorder.length;
		if (size == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);

		for (int i = 1; i < size; i++) {
			generateBST(preorder[i], root);
		}
		return root;
	}

	public void generateBST(int target, TreeNode tree) {
		TreeNode root = tree;
		TreeNode node = new TreeNode(target);
		while (root != null) {
			if (target < root.val) {
				if (root.left == null) {
					root.left = node;
					break;
				} else {
					root = root.left;
				}
			} else {
				if (root.right == null) {
					root.right = node;
					break;
				} else {
					root = root.right;
				}
			}
		}
	}

}
