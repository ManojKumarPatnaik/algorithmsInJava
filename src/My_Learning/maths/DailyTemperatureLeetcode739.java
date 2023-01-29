package My_Learning.maths;

import java.util.Stack;

public class DailyTemperatureLeetcode739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to get daily temp
	public int[] dailyTemperatures(int[] temperatures) {
		final int m = temperatures.length;
		final int[] ans = new int[m];
		final Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < m; i++) {
			while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
				ans[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}
		return ans;
	}

}
