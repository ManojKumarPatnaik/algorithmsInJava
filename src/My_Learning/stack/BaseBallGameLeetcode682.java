package My_Learning.stack;

import java.util.Stack;

public class BaseBallGameLeetcode682 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calPoints(String[] ops) {

		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < ops.length; i++) {
			// ATQ--> "C" is encountered simple pop the element.
			if (ops[i].equals("C")) {
				s.pop();
			}
			// ATQ-->"D" is encountered while traversing the string we push into stack
			// 2*s.peek() element .
			else if (ops[i].equals("D")) {
				s.push(2 * s.peek());
			}
			// ATQ--> "+" is encountered in the ops array we pop two element then add their
			// sum and again push the popped items with their sum.
			else if (ops[i].equals("+")) {
				int sum = 0;
				int s1 = s.pop();
				int s2 = s.pop();
				sum = s1 + s2;
				s.push(s2);
				s.push(s1);
				s.push(sum);
			}
			// ATQ--> if the element is digit simply push the element in stack
			else {
				s.push(Integer.parseInt(ops[i]));
			}
		}

		// finally pop all the element from stack & return their sum
		int sumofStack = 0;
		while (!s.isEmpty()) {
			sumofStack = sumofStack + s.pop();
		}

		// return their sum
		return sumofStack;

	}

}
