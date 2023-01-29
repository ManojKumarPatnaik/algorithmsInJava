package My_Learning.linkedList;

public class CycleInLinkedListLeetCode141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// using the slow and fast pointer concept
	public boolean hasCycle(ListNode head) {
	        
	        if(head==null) return false;
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast!=null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	            
	            if(fast==slow) return true;
	        }
	        
	        return false;
	}
}

