package My_Learning.stack;

import java.util.Stack;

public class MyQueueLeetcode232 {

	Stack<Integer> input;
	Stack<Integer> output;

	public MyQueueLeetcode232() {
		input = new Stack<>();
		output = new Stack<>();
	}

	public void push(int x) {
		// only push the new item when the order is maintained as precondition to push
		while (!output.isEmpty()) {
			input.push(output.pop());
		}
		input.push(x);
	}

	public int pop() {
		// all contents of input -> output as a precondition to pop
		while (!input.isEmpty()) {
			output.push(input.pop());
		}

		return output.pop();
	}

	public int peek() {
		// all contents of input -> output as a precondition to pop
		while (!input.isEmpty()) {
			output.push(input.pop());
		}

		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}

}
