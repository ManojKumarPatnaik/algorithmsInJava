package My_Learning.queues;

import java.util.Stack;

public class ImplementQueueFromStackLeetcode232 {
	Stack<Integer> input;
	Stack<Integer> output;

	// Implement queue using stack
	// Added method to make queue using stack
	public ImplementQueueFromStackLeetcode232() {
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
