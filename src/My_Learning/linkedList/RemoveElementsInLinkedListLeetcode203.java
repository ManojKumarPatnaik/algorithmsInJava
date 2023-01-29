package My_Learning.linkedList;

public class RemoveElementsInLinkedListLeetcode203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(7);

		System.out.println("Linked List before deletion :: ");
		printList(head);

	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print("NULL\n");
	}

	// for multiple times node deletion

	public ListNode removeElements1(ListNode head, int val) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode curr = head, prev = fakeHead;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		return fakeHead.next;
	}

	// for single time key deletion
	public static ListNode removeElements(ListNode head, int val) {

		ListNode temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.val == val) {
			head = temp.next; // Changed head
			return head;
		}

		while (temp != null && temp.val != val) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return head;

		// Unlink the node from linked list
		prev.next = temp.next;
		return head;
	}

	void deleteNode(ListNode head, int key) {
		// Store head node
		ListNode temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.val == key) {
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of
		// the previous node as we need to change temp.next
		while (temp != null && temp.val != key) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

}
