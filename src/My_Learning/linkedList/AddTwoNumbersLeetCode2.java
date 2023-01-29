package My_Learning.linkedList;

import java.math.BigInteger;

public class AddTwoNumbersLeetCode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bI;
	}

	// Added method to sum two number
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyH = new ListNode(-1);
		ListNode tail = dummyH;

		int carry = 0;
		ListNode a = l1;
		ListNode b = l2;

		// iterate untill we get a==null + b == null + carry==0
		while (carry != 0 || a != null || b != null) {
			int sum = 0;

			if (a != null) {
				sum += a.val;
				a = a.next;
			}

			if (b != null) {
				sum += b.val;
				b = b.next;
			}

			sum += carry;

			int effectiveDigit = sum % 10;
			carry = sum / 10;

			ListNode newNode = new ListNode(effectiveDigit);

			if (dummyH.next != null) {
				tail.next = newNode;
				tail = newNode;
			} else {
				dummyH.next = newNode;
				tail.next = newNode;
				tail = newNode;
			}
		}

		return dummyH.next;
	}
}
