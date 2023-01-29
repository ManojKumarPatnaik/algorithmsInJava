package My_Learning.linkedList;

public class SwapNodesLinkListLeetCode1721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Algorithm :-
	 * Let's use two more pointers first and second, denoting the nodes
	 * for swapping
	 * 
	 * Put slow at head, and put fast k-1 nodes after slow. first = fast. If fast
	 * isn't already at the last node, move slow and fast one node further until
	 * fast.next == null second = slow Swap the values of first and second
	 */
	
	/*
	 * Example Let's take this example:
	 * 
	 * [1, 2, 3, 4, 5], k = 2 It's easy to see that we have to swap 2 and 4. Let's
	 * implement that.
	 * 
	 * We traverse this list with fast and slow.
	 * 
	 * It is convenient to choose the initial position for slow to be at head, e.g.
	 * 1. If we choose fast to be k nodes after slow - at 3 - we miss the node 2.
	 * Therefore, we put fast k-1 nodes after slow. This means that the first node
	 * for swapping is at the initial position of fast.
	 * 
	 * When fast is at 5, slow is at 4, which is the second node whose value will be
	 * swapped. In other words, we save the second node for swapping when fast
	 * reaches the last node (fast.next is null). For that, the distance between
	 * slow and fast must be constant; this is achieved by moving them both one node
	 * at a time until fast reaches the end.
	 */

	public ListNode swapNodes(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode first = head, second = head;

		// Put fast (k-1) nodes after slow
		for (int i = 0; i < k - 1; ++i)
			fast = fast.next;

		// Save the node for swapping
		first = fast;

		// Move until the end of the list
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		// Save the second node for swapping
		// Note that the pointer second isn't necessary: we could use slow for swapping
		// as well
		// However, having second improves readability
		second = slow;

		// Swap values
		int temp = first.val;
		first.val = second.val;
		second.val = temp;

		return head;
	}
	
	
}
