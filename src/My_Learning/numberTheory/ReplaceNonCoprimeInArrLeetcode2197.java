package My_Learning.numberTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReplaceNonCoprimeInArrLeetcode2197 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> replaceNonCoprimes(int[] nums) {
		Stack<Integer> st = new Stack<>();
		st.push(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			while (!st.isEmpty() && GCD(st.peek(), num) != 1) {
				int cur = st.pop();
				int lcm = LCM(num, cur);
				num = lcm;
			}
			st.push(num);
		}
		List<Integer> ans = new ArrayList<>(st);
		return ans;
	}

	private int GCD(int a, int b) {
		return a % b == 0 ? b : GCD(b, a % b);
	}

	private int LCM(int a, int b) {
		int gcd = GCD(a, b);
		int lcm = a / gcd * b;
		return lcm;
	}

}
