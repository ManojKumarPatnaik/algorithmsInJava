package My_Learning.stack;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAllAdjDuplicateStringLeetcode1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().a == c && stack.peek().c < k) {
				int n = stack.peek().c;
				stack.peek().c = n + 1;
				if (stack.peek().c == k) {
					stack.pop();
				}
			} else {
				stack.push(new Pair(c, 1));
			}
		}
		StringBuilder sb = new StringBuilder("");
		while (!stack.isEmpty()) {
			char ar[] = new char[stack.peek().c];
			Arrays.fill(ar, stack.peek().a);
			sb.append(String.valueOf(ar));
			stack.pop();
		}
		return sb.reverse().toString();
	}

	class Pair {
		char a;
		int c;

		Pair(char a, int c) {
			this.a = a;
			this.c = c;
		}
	}

}
