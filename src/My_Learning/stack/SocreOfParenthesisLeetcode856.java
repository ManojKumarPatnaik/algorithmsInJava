package My_Learning.stack;

import java.util.Stack;

public class SocreOfParenthesisLeetcode856 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int scoreOfParentheses2(String s) {
		Stack<Integer> stack = new Stack<>();
		int cur = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(cur);
				cur = 0;
			} else {
				cur = stack.pop() + Math.max(cur * 2, 1);
			}
		}
		return cur;
	}

	public int scoreOfParentheses(String s) {
		int score = 0;
		int depth = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				depth++;
			} else {
				depth--;
			}

			if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
				// Whenever you meet a () pair, you multiply 1 by all the 2 outside of it
				// and accumulate the result
				score += Math.pow(2, depth);
			}
		}

		return score;
	}

}
