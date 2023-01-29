package My_Learning.linkedList;

class Node {
	int data;
	Node next;

	Node(int x) {
		data = x;
		next = null;
	}
}

/*
 * Write a function to delete a node in a singly-linked list. You will not be
 * given access to the head of the list, instead you will be given access to the
 * node to be deleted directly.
 * 
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class DeleteLinkedListNodeLeetcode237 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(4);
		head.next = new Node(5);
		head.next.next = new Node(6);
		head.next.next.next = new Node(7);
		System.out.println("Linked List before deletion :: ");
		printList(head);

		// delete node 6
		Node temp = head;
		int key = 6;
		Node keyReference = null;
		while (temp != null) {
			if (temp.data == key) {
				keyReference = temp;
				break;
			}

			temp = temp.next;
		}

		// calling delete function
		deleteNode2(keyReference);
		System.out.println("Linked List after deletion :: ");
		printList(head);

	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("NULL\n");
	}
	// direct the reference of pointer given which we need to delete
	// no head pointer is given

	// idea is to start traversing the node and take out the next value and replace
	// the
	// current data and last make the tail as null and return

	// Added leetcode daily solution
	public static void deleteNode(Node node) {

		if (node != null && node.next != null) {
			Node temp = node;
			Node prevNode = null;
			Node nextNode = null;
			while (temp.next != null) {
				prevNode = temp;
				nextNode = temp.next;

				int nextData = nextNode.data;

				temp.data = nextData;
				temp = temp.next;
			}

			// removing the last key value from list
			prevNode.next = null;
		}

		return;
	}

	// method - 2
	public static void deleteNode2(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	//  method-2 implementation
	public static void deleteNode(ListNode node) {

		if (node == null)
			return;

		node.val = node.next.val;
		node.next = node.next.next;

		return;
	}

}
