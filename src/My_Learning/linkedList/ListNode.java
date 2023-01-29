package My_Learning.linkedList;

import java.util.Comparator;

public class ListNode implements Comparator<ListNode>{
	public int val;
	public ListNode next;

	ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print("NULL\n");
	}
	
	public int getVal() {
		return this.val;
	}

	@Override
	public int compare(ListNode n1, ListNode n2) {
		if(n1.val > n2.val) return 1; // for making min heap
		else if(n1.val < n2.val) return -1;
		
		return 0;
	}
}
