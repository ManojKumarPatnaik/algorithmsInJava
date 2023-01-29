package My_Learning.linkedList;

public class MiddleOfLinkedListLeetCode876 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(8);

		System.out.println("Linked List before deletion :: ");
		ListNode.printList(head);
		ListNode ans = middleNode(head);
		System.out.println("Middle node :: "+ans);
	}

	// method-1 count length and traverse half and return ans 
	public static ListNode middleNode(ListNode head) {
		if(head==null) return head;
		
		int length = 0;
		ListNode temp = head;
		while(temp!=null) {
			length++;
			temp = temp.next;
		}
		
		int half = length / 2;
		temp = head;
		while(half >0) {
			temp = temp.next;
			half--;
		}
		
		return temp;
	}
	
	// another method for finding the middle 
	// using the fast and slow pointer fast -> speed 2x slow - > speed x
	public static ListNode middleNode2(ListNode head) {
		if(head==null) return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}

}
