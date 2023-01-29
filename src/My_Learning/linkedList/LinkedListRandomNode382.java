package My_Learning.linkedList;

import java.util.Random;

public class LinkedListRandomNode382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ListNode head;
	Random random;

	public LinkedListRandomNode382(ListNode h) {
		head = h;
		random = new Random();
	}

	public int getRandom() {

		ListNode c = head;
		int r = c.val;
		for (int i = 1; c.next != null; i++) {

			c = c.next;
			if (random.nextInt(i + 1) == i)
				r = c.val;
		}

		return r;
	}

}
