package My_Learning.linkedList;

public class RemoveDuplicatesFromSortedListLeetCode82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prevNode = dummy;
		ListNode currNode = head;

		while (currNode != null) {

			while (currNode.next != null && currNode.val == currNode.next.val) {
				currNode = currNode.next;
			}

			if (prevNode.next == currNode) {
				prevNode = prevNode.next;
			} else {
				prevNode.next = currNode.next;
			}
			currNode = currNode.next;
		}
		return dummy.next;
	}

	public ListNode deleteDuplicates2(ListNode head) {
        if( head == null || head.next == null)
            return head;

        if(head.next.val != head.val) {
                head.next = deleteDuplicates(head.next);
        } else {
            while(head.next != null && head.val == head.next.val)
                head = head.next;
            return deleteDuplicates(head.next);
        }
        return head;
    }

}
