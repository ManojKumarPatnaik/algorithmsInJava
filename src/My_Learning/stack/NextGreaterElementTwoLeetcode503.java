package My_Learning.stack;

import java.util.ArrayDeque;

public class NextGreaterElementTwoLeetcode503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to get next grater element  
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		ArrayDeque<Integer> st = new ArrayDeque<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && nums[i] >= st.peek())
				st.pop();

			st.push(nums[i]);
		}

		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && nums[i] >= st.peek())
				st.pop();

			res[i] = st.isEmpty() ? -1 : st.peek();
			st.push(nums[i]);
		}
		return res;
	}

}
