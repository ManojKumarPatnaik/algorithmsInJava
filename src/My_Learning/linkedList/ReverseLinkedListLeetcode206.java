package My_Learning.linkedList;

public class ReverseLinkedListLeetcode206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to reverse the given linked list
	public ListNode reverseListR(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public ListNode reverseList(ListNode head) {

		if (head == null)
			return null;

		ListNode previous = null;
		ListNode current = head;
		ListNode next = current.next;

		while (current != null) {

			current.next = previous;
			previous = current;
			current = next;

			if (next != null)
				next = next.next;
		}

		return previous;
	}

}
