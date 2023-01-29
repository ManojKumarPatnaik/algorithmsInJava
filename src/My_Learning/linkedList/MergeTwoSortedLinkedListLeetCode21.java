package My_Learning.linkedList;

public class MergeTwoSortedLinkedListLeetCode21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(4);
		h1.next.next = new ListNode(8);
		
		ListNode h2 = new ListNode(2);
		h2.next = new ListNode(3);
		h2.next.next = new ListNode(5);
		
		ListNode newH = getMergedList(h1, h2);
		System.out.println("New Merged List :: ");
		ListNode.printList(newH);
	}
	
	// approach -1
	// added method to merge 2 sorted list
	public static ListNode getMergedList(ListNode h1, ListNode h2) {
		
		if(h1==null) return h2;
		if(h2==null) return h1;
				
		ListNode l1 = h1, l2 = h2;
		ListNode ans = null;
		ListNode tail = null;
		
		if(l1.val < l2.val) {
			ans = l1;
			tail = l1;
			l1 = l1.next;
		} else {
			ans = l2;
			tail = l2;
			l2 = l2.next;			
		}
		
		while(l1!=null && l2!=null) {
			if(l1.val < l2.val) {
				tail.next = l1;
				tail = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				tail = l2;
				l2 = l2.next;
			}
		}
		
		if(l1!=null) {
			tail.next = l1;
		}
		
		if(l2!=null) {
			tail.next = l2;
		}
		
		
		return ans;
		
	}

}
