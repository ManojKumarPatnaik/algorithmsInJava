package My_Learning.linkedList;

public class ReverseNodeInPairsLeetCode24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// iterative approach.
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode beforeStart = dummy, end = head;
		int i = 0;
		int k = 2; // swapping in pairs

		while (end != null) {
			i++;

			if (i % k == 0) {
				// going for reversal
				ListNode start = beforeStart.next;
				ListNode afterEnd = end.next;

				reverseLink(start, end);

				// linking the new list
				beforeStart.next = end;
				start.next = afterEnd;

				beforeStart = start;
				end = afterEnd;
			} else {
				end = end.next;
			}
		}

		return dummy.next;
	}

	public void reverseLink(ListNode start, ListNode end) {
		ListNode p = null, c = start, n = c.next;

		while (p != end) {
			c.next = p;

			p = c;
			c = n;
			if (n != null)
				n = n.next;
		}

		return;
	}

}
