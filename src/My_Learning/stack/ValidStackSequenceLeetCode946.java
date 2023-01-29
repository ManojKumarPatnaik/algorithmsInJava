package My_Learning.stack;

import java.util.Stack;

public class ValidStackSequenceLeetCode946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		for (int x : pushed) {
			stack.push(x);
			while (!stack.empty() && stack.peek() == popped[i]) {
				stack.pop();
				i++;
			}
		}
		return stack.empty();
	}

}
