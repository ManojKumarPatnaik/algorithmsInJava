package My_Learning.linkedList;

public class ReverseLinkedListLeftRightLeetCode92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = null;

		System.out.println("Given Linked List :: ");
		ListNode.printList(head);

		int left = 2;
		int right = 4;
		
		ListNode newHead = reverseBetween(head, left, right);
		System.out.println("Given Linked List after reversal between :: "+left+" to "+right);
		ListNode.printList(newHead);

	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		
		if (head==null) return null;
		
		//assuming the left and right are valid and lie with in the length
		//picking up the node previous to left and next to right
		ListNode current = head;
		ListNode prevLeft = null;
		ListNode nextRight = null;
		int count = 1;
		while(current != null) {
			count++;
			
			if(count==left) prevLeft = current;
			else if(count == right) nextRight = current.next;
			else
				continue;
			prevLeft = current;
			current = current.next;
		}
		
		System.out.println("Node data previous to left :: "+prevLeft.getVal());
		System.out.println("Node data next to right :: "+nextRight.getVal());
		
		
		return null;
	}
	
	public ListNode reverseBetween1(ListNode head, int m, int n) {
	    if(head == null) return null;
	    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) pre = pre.next;
	    
	    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    ListNode then = start.next; // a pointer to a node that will be reversed
	    
	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
	    
	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }
	    
	    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
	    
	    return dummy.next;
	    
	}
	
	public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        int k = 1;
        while(cur.next != null && k != m){
            cur = cur.next;
            pre = pre.next;
            k++;
        }

        while(cur.next != null && k != n){
            ListNode preNext = pre.next;
            pre.next = cur.next;
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preNext;
            k++;
        }

        return dummy.next;
    }

}
