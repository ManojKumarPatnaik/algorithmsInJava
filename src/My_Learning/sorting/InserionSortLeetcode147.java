package My_Learning.sorting;

import com.ujjwal_Learning.linkedList.ListNode;

public class InserionSortLeetcode147 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode insertionSortList(ListNode head) {
		ListNode curr = head, next = null;
		// l is a fake head
		ListNode l = new ListNode(0);

		while (curr != null) {
			next = curr.next;

			ListNode p = l;
			while (p.next != null && p.next.val < curr.val)
				p = p.next;

			// insert curr between p and p.next
			curr.next = p.next;
			p.next = curr;
			curr = next;
		}

		return l.next;
	}

}
