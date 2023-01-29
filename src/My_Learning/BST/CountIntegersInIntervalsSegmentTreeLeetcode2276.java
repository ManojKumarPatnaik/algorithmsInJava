package My_Learning.BST;

class Node {
	int lower, upper, val;
	Node left, right;

	public Node(int lower, int upper, int val) {
		this.lower = lower;
		this.upper = upper;
		this.val = val;
	}
}

public class CountIntegersInIntervalsSegmentTreeLeetcode2276 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node root;

	public CountIntegersInIntervalsSegmentTreeLeetcode2276() {
        root = new Node(0, 1000000000, 0);
    }

	private void setRange(Node node, int left, int right) {
		if (left <= node.lower && node.upper <= right) {
			node.val = node.upper - node.lower + 1;
			node.left = null;
			node.right = null;
			return;
		}
		int mid = (node.upper + node.lower) / 2;
		if (node.left == null && node.right == null) {
			node.left = new Node(node.lower, mid, node.val > 0 ? mid - node.lower + 1 : 0);
			node.right = new Node(mid + 1, node.upper, node.val > 0 ? node.upper - (mid + 1) + 1 : 0);
		}
		if (left <= mid)
			setRange(node.left, left, right);
		if (right > mid)
			setRange(node.right, left, right);
		node.val = node.left.val + node.right.val;
	}

	public void add(int left, int right) {
		setRange(root, left, right);
	}

	public int count() {
		return root.val;
	}

}
