package My_Learning.maths;

import java.util.HashSet;
import java.util.Set;

public class Find3DigitEvenNumberLeetcode2094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findEvenNumbers(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				continue;
			for (int j = 0; j < a.length; j++) {
				if (j == i)
					continue;
				for (int k = 0; k < a.length; k++) {
					if (k == i || k == j)
						continue;
					if (a[k] % 2 == 0)
						set.add(a[i] * 100 + a[j] * 10 + a[k]);
				}
			}
		}
		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
	}
}
