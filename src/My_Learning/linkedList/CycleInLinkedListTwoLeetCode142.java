package My_Learning.linkedList;

public class CycleInLinkedListTwoLeetCode142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		return head;
	}

	// better approach
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode();
		start.next = head;
		ListNode fast = start;
		ListNode slow = start;

		for (int i = 1; i <= n; ++i)
			fast = fast.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return start.next;
	}
}
