package My_Learning.binaryTrees_2;

import com.ujjwal_Learning.linkedList.ListNode;

public class ConvertSortedListToBinarySearchTreeLeetcode109 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		ListNode temp = null;

		// find the mid node
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			temp = slow;
			slow = slow.next;
		}

		if (temp != null)
			temp.next = null; // break the link
		else
			head = null;

		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
}
