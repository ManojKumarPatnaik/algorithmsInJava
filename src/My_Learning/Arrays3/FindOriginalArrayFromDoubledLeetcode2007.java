package My_Learning.Arrays3;

import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledLeetcode2007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findOriginalArray(int[] A) {
		int n = A.length, i = 0;
		if (n % 2 == 1)
			return new int[0];
		int[] res = new int[n / 2];
		Map<Integer, Integer> count = new TreeMap<>();
		for (int a : A)
			count.put(a, count.getOrDefault(a, 0) + 1);
		for (int x : count.keySet()) {
			if (count.get(x) > count.getOrDefault(x + x, 0))
				return new int[0];
			for (int j = 0; j < count.get(x); ++j) {
				res[i++] = x;
				count.put(x + x, count.get(x + x) - 1);
			}
		}
		return res;
	}

}
