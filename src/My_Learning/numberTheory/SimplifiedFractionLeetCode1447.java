package My_Learning.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractionLeetCode1447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Input: n = 2 Output: ["1/2"] Explanation: "1/2" is the only unique fraction
	 * with a denominator less-than-or-equal-to 2.
	 */
	
	/*
	 * Input: n = 4 Output: ["1/2","1/3","1/4","2/3","3/4"] Explanation: "2/4" is
	 * not a simplified fraction because it can be simplified to "1/2".
	 */
	public List<String> simplifiedFractions(int n) {
		List<String> ans = new ArrayList<>();
		for (int denominator = 2; denominator <= n; ++denominator) {
			for (int numerator = 1; numerator < denominator; ++numerator) {
				if (gcd(numerator, denominator) == 1) {
					ans.add(numerator + "/" + denominator);
				}
			}
		}
		return ans;
	}

	private int gcd(int x, int y) {
		return x == 0 ? y : gcd(y % x, x);
	}

}
