package My_Learning.linkedList;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedListLeetCode23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode h1 = new ListNode(2);
		h1.next = new ListNode(5);
		h1.next.next = new ListNode(9);

		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(3);
		h2.next.next = new ListNode(7);

		ListNode h3 = new ListNode(6);
		h3.next = new ListNode(8);
		h3.next.next = new ListNode(10);

		ListNode[] lists = new ListNode[3];
		lists[0] = h1;
		lists[1] = h2;
		lists[2] = h3;

		System.out.println("List 1 :: ");
		ListNode.printList(h1);

		System.out.println("List 2 :: ");
		ListNode.printList(h2);

		System.out.println("List 3 :: ");
		ListNode.printList(h3);

		System.out.println("Final List after merge :: ");
		ListNode finalH = mergeKSortedList(lists);
		ListNode.printList(finalH);
	}

	private static ListNode mergeKSortedList(ListNode[] lists) {
		int k = lists.length;

		if (k == 0)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<>(k, new ListNode());

		// adding the initial nodes to pq
		for (int i = 0; i < k; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}

		// for handling the answer
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;

		while (!pq.isEmpty()) {

			ListNode minNode = pq.poll();
			// System.out.println("Min Node value "+minNode.val);
			// adding the min_node to my answer list
			// making head
			if (dummy.next == null)
				dummy.next = minNode;
			tail.next = minNode;
			tail = minNode;
			if (minNode.next != null)
				pq.add(minNode.next);

		}

		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0)
			return null;

		Queue<ListNode> minHeap = new PriorityQueue<>((head1, head2) -> head1.val - head2.val);
		
		for (ListNode listNode : lists) {
			if (listNode != null)
				minHeap.offer(listNode);
		}
		
		ListNode head = null, cur = null;
		
		while (!minHeap.isEmpty()) {
			
			ListNode curNode = minHeap.poll();
			if (curNode.next != null)
				minHeap.offer(curNode.next);
			
			if (head == null) { // First node of answer list
				head = new ListNode(curNode.val);
				cur = head;
			} else {
				cur.next = new ListNode(curNode.val);
				cur = cur.next;
			}
		}
		return head;
	}

}
