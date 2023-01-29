package My_Learning.maths;

import java.util.Collections;
import java.util.HashMap;

public class DestroySequentialTargetsLeetcode2453 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int destroyTargets(int[] A, int space) {
		int res = (int) 1e9;
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int a : A)
			count.put(a % space, count.getOrDefault(a % space, 0) + 1);
		int maxc = Collections.max(count.values());
		for (int a : A)
			if (count.get(a % space) == maxc)
				res = Math.min(res, a);
		return res;
	}

}
