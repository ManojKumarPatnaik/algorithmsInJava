package My_Learning.LeetCodeQuestions;

public class ReverseLinkedListLeetCode206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}
	
	public ListNode reverseList2(ListNode head) {

        if(head==null) return null;

        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;
        
         while(current!=null){
             current.next = previous;
            
             previous = current;
             current = next;
             
             if(next.next != null) next = next.next;
         }
        
        return previous;
    }

}
