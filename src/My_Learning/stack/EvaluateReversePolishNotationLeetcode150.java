package My_Learning.stack;

import java.util.Stack;

public class EvaluateReversePolishNotationLeetcode150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// evaluate reverse polish notation
	public int evalRPN(String[] tokens) {
		if (tokens.length == 0) {
			throw new Error("Invalid input 'tokens'; length must be at least 1");
		}

		Stack<String> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int secondOperand = Integer.parseInt(stack.pop());
				int firstOperand = Integer.parseInt(stack.pop());
				int result = 0;
				if (token.equals("+")) {
					result = secondOperand + firstOperand;
				} else if (token.equals("-")) {
					result = firstOperand - secondOperand;
				} else if (token.equals("*")) {
					result = firstOperand * secondOperand;
				} else {
					result = firstOperand / secondOperand;
				}

				stack.push(Integer.toString(result));
			} else {
				stack.add(token);
			}
		}
		return Integer.parseInt(stack.pop());
	}

}
