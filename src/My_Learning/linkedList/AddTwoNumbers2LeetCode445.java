package My_Learning.linkedList;

import java.util.Stack;

public class AddTwoNumbers2LeetCode445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added function to get add two number
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int sum = 0;
		ListNode tail = new ListNode(0);
		
		// tail tail(carry)-> tail(sum)
		while (!s1.empty() || !s2.empty()) {
			if (!s1.empty())
				sum += s1.pop();
			if (!s2.empty())
				sum += s2.pop();
			tail.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = tail;
			tail = head;
			sum /= 10;
		}

		return tail.val == 0 ? tail.next : tail;
	}

}
