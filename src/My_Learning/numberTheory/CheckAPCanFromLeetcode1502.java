package My_Learning.numberTheory;

import java.util.HashSet;
import java.util.Set;

public class CheckAPCanFromLeetcode1502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canMakeArithmeticProgression(int[] arr) {
		Set<Integer> seen = new HashSet<>();
		int mi = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, n = arr.length;
		for (int a : arr) {
			mi = Math.min(mi, a);
			mx = Math.max(mx, a);
			seen.add(a);
		}
		int diff = mx - mi;
		if (diff % (n - 1) != 0) {
			return false;
		}
		diff /= n - 1;
		while (--n > 0) {
			if (!seen.contains(mi)) {
				return false;
			}
			mi += diff;
		}
		return true;
	}

}
