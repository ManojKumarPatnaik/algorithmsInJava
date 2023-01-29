package My_Learning.binaryTrees_2;

public class PopulatingTreeNextRightPointerTwoLeetcode117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		Node dummyHead = new Node(0); // this head will always point to the first element in the current layer we are
										// searching
		Node pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer
		Node real_root = root; // just for return statement

		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) { // reach the end of current layer
				pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in
									// next layer
				root = dummyHead.next;
				;// root comes down one level below to the first available non null node
				dummyHead.next = null;// reset dummyhead back to default null
			}
		}
		return real_root;
	}

}
