package My_Learning.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementLeetcode496 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[nums1.length];

		for (int num : nums2) {
			while (!stack.empty() && num > stack.peek())
				map.put(stack.pop(), num);
			stack.push(num);
		}

		int i = 0;
		for (int num : nums1) {
			ans[i++] = map.getOrDefault(num, -1);
		}
		return ans;
	}

}
