package My_Learning.LeetCodeQuestions;

import java.util.Stack;

public class IsValidParanthesisLeetCode20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s = "{{}[][[[]]]}";
		String s = "]";
		boolean ans = isValid(s);
		System.out.println(ans);
	}
	/*
	 *  The basic idea is to push the right parentheses ')', ']', or '}'
	 * into the stack each time when we encounter left ones. And if a right bracket
	 * appears in the string, we need check if the stack is empty and also whether
	 * the top element is the same with that right bracket. If not, the string is
	 * not a valid one. At last, we also need check if the stack is empty.
	 */
	//method-1
    public boolean isValid1(String s){
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

	//method-2
	private static boolean isValid(String s) {
		
		char[] sc = s.toCharArray();
		int n = sc.length;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < n ; i++) {
			char it = sc[i];
			
			if(isOpenBracket(it)) {
				stack.push(it);
			} else if (isClosedBracket(it)) {
				
				if(it == ')' && !stack.isEmpty() && stack.peek() == '(' ) {
					stack.pop();
				}
				
				if(it == '}' && !stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}
				
				if(it == ']' && !stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}
				
			} else {
				return false;
			}
		}
		System.out.println(stack.toString());
		return stack.isEmpty();
	}

	private static boolean isClosedBracket(char it) {
		
		return it == ')' || it == '}' || it == ']' ;
	}

	private static boolean isOpenBracket(char it) {
		
		return it == '(' || it == '{' || it == '[' ;
	}

}
