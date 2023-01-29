package My_Learning.queues;

import java.util.ArrayList;
import java.util.List;

class MyQueue {
	// store elements
	private List<Integer> data;
	// a pointer to indicate the start position
	private int head;

	public MyQueue() {
		data = new ArrayList<Integer>();
		head = 0;
	}

	/**
	 * Insert an element into the queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int x) {
		data.add(x);
		return true;
	};

	/**
	 * Delete an element from the queue. Return true if the operation is successful.
	 */
	public boolean deQueue() {
		if (isEmpty() == true) {
			return false;
		}
		head++;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		return data.get(head);
	}

	/** Checks whether the queue is empty or not. */
	public boolean isEmpty() {
		return head >= data.size();
	}
}

public class MyImplementationForQUEUE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// To implement a queue, we may use a dynamic array and an index pointing to the
		// head of the queue.
		// But it is not efficient as we insert or delete some space are left but we
		// can't fill until modifying the array
		MyQueue q = new MyQueue();
		q.enQueue(5);
		q.enQueue(3);
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
	}

}
