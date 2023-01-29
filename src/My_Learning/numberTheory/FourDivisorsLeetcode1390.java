package My_Learning.numberTheory;

import java.util.HashSet;
import java.util.Set;

public class FourDivisorsLeetcode1390 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumFourDivisors(int[] nums) {
		int res = 0;

		for (int no : nums) {
			Set<Integer> divisor = new HashSet<Integer>();
			for (int i = 1; i <= Math.sqrt(no); i++) {
				if (no % i == 0) {
					if (no / i == i) {
						divisor.add(i);
					}

					else {
						divisor.add(i);
						divisor.add(no / i);
					}
				}
			}

			if (divisor.size() == 4) {
				int sum = 0;
				for (Integer a : divisor) {
					sum += a;
				}
				res += sum;
			}
		}

		return res;
	}

}
