package My_Learning.maths;

import java.util.HashMap;

public class MinimumRoundToCompleteAllTaskLeetcode2244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to fetch min rounds 
	public int minimumRounds(int[] A) {
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int a : A)
			count.put(a, count.getOrDefault(a, 0) + 1);
		int res = 0;
		for (int freq : count.values()) {
			if (freq == 1)
				return -1;
			res += (freq + 2) / 3;
		}
		return res;
	}

}
