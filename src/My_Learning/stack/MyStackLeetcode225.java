package My_Learning.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStackLeetcode225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Queue<Integer> mainQ;
	Queue<Integer> helperQ;

	/** Initialize your data structure here. */
    public MyStackLeetcode225() {
        
        mainQ=new ArrayDeque<>();
        helperQ=new ArrayDeque<>();
        
    }

	/** Push element x onto stack. */
	public void push(int x) {

		mainQ.add(x);

	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {

		if (mainQ.size() == 0) {
			return -1;
		}

		while (mainQ.size() != 1) {
			helperQ.add(mainQ.remove());
		}

		int val = mainQ.remove();

		mainQ = helperQ;
		helperQ = new ArrayDeque<>();

		return val;

	}

	/** Get the top element. */
	public int top() {

		if (mainQ.size() == 0) {
			return -1;
		}

		while (mainQ.size() != 1) {
			helperQ.add(mainQ.remove());
		}

		int val = mainQ.remove();
		helperQ.add(val); // this is the only difference between top and pop.

		mainQ = helperQ;
		helperQ = new ArrayDeque<>();

		return val;

	}

	/** Returns whether the stack is empty. */
	public boolean empty() {

		return mainQ.isEmpty();
	}

}
