package My_Learning.strings;

public class CheckValidInsertionLeetCode1003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String S) {
		String abc = "abc";

		while (S.contains(abc)) {
			S = S.replace(abc, "");
		}

		return S.isEmpty();
	}

// Keep a stack, whenever meet 'c',
// pop a and b at the end of stack.
// Otherwise return false.

	// public boolean isValid(String s) {
	// Stack<Character> stack = new Stack<>();
	// for (char c: s.toCharArray()) {
	// if (c == 'c') {
	// if (stack.isEmpty() || stack.pop() != 'b') return false;
	// if (stack.isEmpty() || stack.pop() != 'a') return false;
	// } else {
	// stack.push(c);
	// }
	// }
	// return stack.isEmpty();
	// }

}
