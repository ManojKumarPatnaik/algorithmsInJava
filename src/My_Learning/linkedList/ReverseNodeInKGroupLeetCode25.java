package My_Learning.linkedList;

public class ReverseNodeInKGroupLeetCode25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// recursive method
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;

		ListNode start = head;
		ListNode end = head;
		int i = k - 1;
		while (i > 0) {
			end = end.next;
			if (end == null)
				return head;
			i--;
		}
		
		// calling recursion to solve the after first k nodes
		ListNode newH = reverseKGroup(end.next, k);

		reverseLink(start, end);
		// after reversal the start m=becomes the end of new LL
		// end becomes the new Head
		start.next = newH;

		return end;
	}

	public void reverseLink(ListNode start, ListNode end) {
		ListNode p = null, c = start, n = c.next;

		while (p != end) {
			c.next = p;

			p = c;
			c = n;
			if (n != null)
				n = n.next;
		}

		return;
	}
	
	//method - 2
	public ListNode reverseKGroupIterative(ListNode head, int k) {
        if(head==null || head.next == null || k==1) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode beforeStart = dummy, end = head;
        int i = 0;
        
        while(end!=null){
            i++;
            
            if(i%k==0){
                // going for reversal
                ListNode start = beforeStart.next;
                ListNode afterEnd = end.next;
                
                reverseLink(start,end);
                
                // linking the new list
                beforeStart.next = end;
                start.next = afterEnd;
                
                beforeStart = start;
                end = afterEnd;
            } else{
                end = end.next;
            }
        }
        
        return dummy.next;
        
    }

}
