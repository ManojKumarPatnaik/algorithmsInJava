package My_Learning.linkedList;

public class PartitionListLeetcode86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Daily Leetcode solution
	public ListNode partition(ListNode head, int x) {
		ListNode headCopy = head;
		ListNode h = null;
		ListNode t = null;
		while (headCopy != null) {
			ListNode l = new ListNode(headCopy.val);
			if (l.val < x) {
				l.next = h;
				h = l;
			} else {
				l.next = t;
				t = l;
			}
			headCopy = headCopy.next;
		}
		head = null;
		while (t != null) {
			ListNode l = new ListNode(t.val);
			l.next = head;
			head = l;
			t = t.next;
		}
		while (h != null) {
			ListNode l = new ListNode(h.val);
			l.next = head;
			head = l;
			h = h.next;
		}
		return head;
	}

}
