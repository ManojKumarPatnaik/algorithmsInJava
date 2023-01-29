package My_Learning.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StockSpanProblemTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here In this problem we need to find at given particular ith day 
		// number of consecutive stocks lesser and equal to current
		// Hint : Find the Nearest greater to left and store it's index and then do i - index to get actual count
		
		// IP - arr : {100, 80, 60, 70, 60, 75, 85}
		// OP - opp : {1, 1, 1, 2, 1, 4, 6}
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		
		int[] nglIndexArray = getNGLIndices(arr);
		for(int i = 0; i < nglIndexArray.length ; i++) {
			{
				int index;
				if(nglIndexArray[i] == -1) {
					index = -1;
				} else {
					index = map.get(nglIndexArray[i]);
				}
				nglIndexArray[i] = Math.abs(index - i);
			}
		}
		System.out.println("NGL Index Array"+Arrays.toString(nglIndexArray));
		

	}
	
	private static int[] getNGLIndices(int[] arr) {
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
