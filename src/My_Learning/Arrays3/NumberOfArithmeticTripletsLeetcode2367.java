package My_Learning.Arrays3;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTripletsLeetcode2367 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arithmeticTriplets(int[] nums, int diff) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int ans = 0;
		for (int num : nums) {
			if ((set.contains(num + diff) && set.contains(num + 2 * diff))) {
				ans++;

			}
		}
		return ans;

	}

}
