package My_Learning.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidSLeetCode1249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minRemoveToMakeValid1(String s) {
		int len = s.length();
		boolean[] b = new boolean[s.length()];
		StringBuilder res = new StringBuilder("");
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < len; ++i) {
			if (s.charAt(i) == '(')
				st.push(i);
			else if (s.charAt(i) == ')') {
				if (!st.isEmpty()) {
					// match these pairs, all unmatched are false anyway
					b[i] = true;
					b[(int) st.pop()] = true;
				}
			} else {
				b[i] = true; // any character other than ( and ) are true anyway
			}
		}

		for (int i = 0; i < len; ++i) {
			if (b[i])
				res.append(s.charAt(i));
		}

		return res.toString();
	}

	public String minRemoveToMakeValid(String s) {
		int openCloseCount = 0;
		int close = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == ')')
				close++;

		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				if (openCloseCount == close)
					continue;
				openCloseCount++;
			} else if (c == ')') {
				close--;
				if (openCloseCount == 0)
					continue;
				openCloseCount--;
			}

			sb.append(c);
		}
		return sb.toString();
	}

}
