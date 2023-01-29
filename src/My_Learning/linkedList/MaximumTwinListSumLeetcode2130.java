package My_Learning.linkedList;

public class MaximumTwinListSumLeetcode2130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursion + Two Pointer
	// max to keep the track of max sum value
	private int max;

	// this pointer moves from left to right
	private ListNode head;

	public int pairSumR(ListNode node) {
		// initialising global values
		max = Integer.MIN_VALUE;
		head = node;

		// this pointer *node* will traverse in reversed direction
		// using findMax(), which a recursive function
		findMax(node);

		// finally we return the max value
		return max;
	}

	private void findMax(ListNode node) {
		// base case
		if (node == null)
			return;

		// here we have called findMax() for the next node
		// since we want to go to the last node first
		// then we wish to start calculating the max
		findMax(node.next);

		// we will reach here first only when the last node is
		// reached, then we calculate the max value
		max = Math.max(max, head.val + node.val);

		// once we are done with the calculation,
		// we shift the next left-to-right pointer to the right
		// for the next iteration
		head = head.next;
	}

	// Two Pointer appraoch
	public int pairSum(ListNode head) {
		// initialising two pointers
		ListNode slow = head;
		ListNode fast = head;

		// fast pointer moves two nodes at a time
		// slow pointer moves one node at a time
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse the second half of the list
		slow = reverse(slow);

		int max = Integer.MIN_VALUE;

		// iterating through the two pointers from left-to-right
		// finding the max value of sum pairs
		while (slow != null) {
			max = Math.max(max, head.val + slow.val);
			slow = slow.next;
			head = head.next;
		}

		// return the max value obtained
		return max;
	}

	// simple iterative Reverse Linked List approach
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

}
