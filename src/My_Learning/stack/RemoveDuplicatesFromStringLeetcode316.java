package My_Learning.stack;

import java.util.Stack;

public class RemoveDuplicatesFromStringLeetcode316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeDuplicateLetters(String s) {

		Stack<Character> stack = new Stack<Character>();

		// appearance count
		int[] count = new int[26];
		// used or not;
		boolean[] added = new boolean[26];

		// count appearances
		for (char ch : s.toCharArray())
			count[ch - 'a']++;

		// go through each char
		for (char ch : s.toCharArray()) {

			count[ch - 'a']--;

			if (added[ch - 'a'])
				continue;

			// poping out the char which is bigger and still has some left in behind
			while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0)
				added[stack.pop() - 'a'] = false;

			// add current one
			stack.push(ch);
			added[ch - 'a'] = true;
		}

		// move from stack to string
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();

	}

}
