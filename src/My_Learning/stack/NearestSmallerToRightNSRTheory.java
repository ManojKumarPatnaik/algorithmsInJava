package My_Learning.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRightNSRTheory {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 0, 0, 1, 5, 4 };

		int[] nsrArray = getNSR(arr);
		System.out.println(Arrays.toString(nsrArray));

	}

	private static int[] getNSR(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		
		
		for(int i = n-1; i  >= 0; i--) {
			if(stack.isEmpty()) {
				ans[i] = -1;
			}
			else if (!stack.isEmpty() && stack.peek() < arr[i]) {
				ans[i] = stack.peek();
			} else if(!stack.isEmpty() && stack.peek() >= arr[i]) {
				while(!stack.isEmpty() && stack.peek() >= arr[i]) {
					stack.pop();
				}
				
				if(stack.isEmpty()) ans[i] = -1;
				else ans[i] = stack.peek();
			}
			
			stack.push(arr[i]);
		}
		
		return ans;
	
	}
}
