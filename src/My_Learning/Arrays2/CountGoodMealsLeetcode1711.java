package My_Learning.Arrays2;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMealsLeetcode1711 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countPairs(int[] deliciousness) {
		int m1 = 1000000007;
		int n = deliciousness.length;
		Map<Integer, Integer> m = new HashMap<>();
		int c = 0;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j <= 21; j++) {

				int k = (int) Math.pow(2, j) % m1;

				int x1 = k - deliciousness[i] % m1;
				if (m.containsKey(x1)) {
					c = (c % m1 + m.get(x1) % m1) % m1;
				}
			}

			if (m.containsKey(deliciousness[i])) {
				int x = m.get(deliciousness[i]);
				m.put(deliciousness[i], x + 1);
			} else
				m.put(deliciousness[i], 1);
		}

		return c;
	}

}
