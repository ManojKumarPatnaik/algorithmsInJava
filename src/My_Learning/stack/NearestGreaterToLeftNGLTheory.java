package My_Learning.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeftNGLTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 3, 2, 0, 0, 1, 5, 4 };
		int[] arr = {1,3,2,4};

		int[] nglArray = getNGL(arr);
		System.out.println(Arrays.toString(nglArray));

	}

	private static int[] getNGL(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();

		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {

			if (stack.isEmpty()) {
				ans[i] = -1;
			} else if (!stack.isEmpty() && stack.peek() > arr[i]) {
				ans[i] = stack.peek();
			} else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
				while (!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}

				if (stack.isEmpty())
					ans[i] = -1;
				else
					ans[i] = stack.peek();
			}

			stack.push(arr[i]);

		}

		return ans;
	}

}
