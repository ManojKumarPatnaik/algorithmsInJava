package My_Learning.stack;

import java.util.Stack;

public class LongestValidParaenthesisLeetcode32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
				stack.pop();
				result = Math.max(result, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
		return result;
	}

}
