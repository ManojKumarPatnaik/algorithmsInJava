package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceLeetCode60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	Example 1:
//
//		Input: n = 3, k = 3
//		Output: "213"
	public String getPermutation(int n, int k) {
		int fact = 1;
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			fact = fact * i;
			numbers.add(i);
		}
		numbers.add(n);
		String ans = "";
		k = k - 1;
		while (true) {
			ans = ans + numbers.get(k / fact);
			numbers.remove(k / fact);
			if (numbers.size() == 0) {
				break;
			}

			k = k % fact;
			fact = fact / numbers.size();
		}
		return ans;
	}
}
