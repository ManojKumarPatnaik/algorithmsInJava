package My_Learning.linkedList;

public class SplitLinkedListInPartsLeetCode725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Given the head of a singly linked list and an integer k, split the linked
	 * list into k consecutive linked list parts.
	 * 
	 * The length of each part should be as equal as possible: no two parts should
	 * have a size differing by more than one. This may lead to some parts being
	 * null.
	 * 
	 * The parts should be in the order of occurrence in the input list, and parts
	 * occurring earlier should always have a size greater than or equal to parts
	 * occurring later.
	 * 
	 * Return an array of the k parts.
	 */
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] parts = new ListNode[k];
		int len = 0;
		for (ListNode node = root; node != null; node = node.next)
			len++;
		int n = len / k, r = len % k; // n : minimum guaranteed part size; r : extra nodes spread to the first r
										// parts;
		ListNode node = root, prev = null;
		for (int i = 0; node != null && i < k; i++, r--) {
			parts[i] = node;
			for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
				prev = node;
				node = node.next;
			}
			prev.next = null;
		}
		return parts;
	}

}
