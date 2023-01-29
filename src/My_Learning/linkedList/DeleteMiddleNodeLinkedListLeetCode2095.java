package My_Learning.linkedList;

public class DeleteMiddleNodeLinkedListLeetCode2095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// delete middle node 
	public ListNode deleteMiddle(ListNode head) {
		if (head == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;
		ListNode prevMid = null; // carrying the previous to middle node

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prevMid = slow;
			slow = slow.next;
		}

		if (prevMid == null)
			return null;

		prevMid.next = slow.next;

		return head;

	}

}
