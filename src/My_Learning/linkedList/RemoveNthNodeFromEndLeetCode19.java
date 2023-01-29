package My_Learning.linkedList;

public class RemoveNthNodeFromEndLeetCode19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// added method to delete nth node from end using fast slow pointer concept
	// maintain front and back with a gap of n
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode front = head, back = head;
		while (n-- > 0)
			front = front.next;
		if (front == null)
			return head.next;
		while (front.next != null) {
			front = front.next;
			back = back.next;
		}
		back.next = back.next.next;
		return head;
	}

}
