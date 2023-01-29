package My_Learning.linkedList;

import java.util.HashMap;

public class IntersectionOfTwoLinkedListLeetCode160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode headA = new ListNode(4);
		ListNode headB = new ListNode(5);

		headA.next = new ListNode(1);

		headB.next = new ListNode(6);
		headB.next.next = new ListNode(1);

		headA.next.next = new ListNode(8);
		headB.next.next.next = headA.next.next; // making intersection point

		headA.next.next.next = new ListNode(4);
		headB.next.next.next.next = headA.next.next.next;

		headA.next.next.next.next = new ListNode(5);
		headB.next.next.next.next.next = headA.next.next.next.next;

		System.out.println("Linked List A");
		ListNode.printList(headA);

		System.out.println("Linked List B");
		ListNode.printList(headB);

		ListNode intersectionNode = getIntersectionNodeBetter(headA, headB);
		System.out.println("Intersection node obtained for List A and B :: " + intersectionNode.getVal());

	}

	// Brute force
	public static ListNode getIntersectionListNodeBruteForce(ListNode headA, ListNode headB) {

		while (headA != null) {
			ListNode temp = headB;
			while (temp != null) {
				if (headA == temp)
					return headA;
				temp = temp.next;
			}

			headA = headA.next;
		}

		return null;
	}

	// Better than brute force
	public static ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {

		HashMap<ListNode, Integer> map = new HashMap<>();

		while (headB != null) {
			if (map.containsKey(headB)) {
				map.put(headB, (map.get(headB) + 1));
			} else {
				map.put(headB, 1);
			}

			headB = headB.next;
		}

		while (headA != null) {
			if (map.containsKey(headA)) {
				return headA;
			}

			headA = headA.next;
		}

		return null;
	}

	// Optimal -1 method
	public static ListNode getIntersectionNodeOptimal1(ListNode headA, ListNode headB) {

		ListNode d1 = headA, d2 = headB;
		ListNode t1 = headA, t2 = headB;
		int l1 = 0, l2 = 0;

		while (t1 != null || t2 != null) {
			if (t1 != null) {
				l1++;
				t1 = t1.next;
			}

			if (t2 != null) {
				l2++;
				t2 = t2.next;
			}
		}

		System.out.println("Length l1 :: " + l1);
		System.out.println("Length l2 :: " + l2);

		boolean moveD1;

		moveD1 = l1 > l2 ? true : false;

		int gap = Math.max(l1, l2) - Math.min(l1, l2);

		while (gap > 0) {
			if (moveD1) {
				if (d1 != null)
					d1 = d1.next;
			} else {
				if (d2 != null)
					d2 = d2.next;
			}
			gap--;
		}

		// now d1 and d2 are at same position
		while (d1 != d2) {

			if (d1 != null)
				d1 = d1.next;
			if (d2 != null)
				d2 = d2.next;
		}

		return d1;
	}

	// Optimal -2 method
	// added optimal-2 method to identify intersection bw two LL
	public static ListNode getIntersectionNodeOptimal2(ListNode headA, ListNode headB) {

		ListNode d1 = headA, d2 = headB;

		// now d1 or d2 are at null position then again start the pointer at null
		// position to the head of that list whose pointer is not null in order to
		// reduce the gap between them and when they are equal it will be at
		// intersection point or at null

		while (d1 != d2) {

			d1 = d1 == null ? headB : d1.next;
			d2 = d2 == null ? headA : d2.next;
		}

		return d1;
	}

}
