package My_Learning.linkedList;

public class ReverseLinkedList2Leetcode92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy, cur = head;

		int k = 1;
		while (cur.next != null && k != m) {
			cur = cur.next;
			pre = pre.next;
			k++;
		}

		while (cur.next != null && k != n) {
			ListNode preNext = pre.next;
			pre.next = cur.next;
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = preNext;
			k++;
		}

		return dummy.next;
	}

}
