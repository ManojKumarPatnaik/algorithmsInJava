package My_Learning.stack;

import java.util.Stack;

public class MinimumSwapStringBalancedLeetCode1963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSwaps(String s) {
		Stack<Character> stack = new Stack<>();
		int mismatch = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '[')
				stack.push(ch);
			else {
				if (!stack.isEmpty())
					stack.pop();
				else
					mismatch++;
			}
		}
		return (mismatch + 1) / 2;
	}

}
