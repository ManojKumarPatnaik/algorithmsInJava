package My_Learning.Arrays3;

import java.util.HashMap;

public class MostFrequentEvenElementLeetode2404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mostFrequentEven(int[] A) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		int val = 1000000, freq = 0;
		for (Integer i : A) {
			// if even element
			if (i % 2 == 0) {
				// increase frequency in map
				int curr = mp.getOrDefault(i, 0) + 1;
				mp.put(i, curr);
				// Update smallest with greatest frequency
				if (curr > freq || curr == freq && i < val) {
					val = i;
					freq = curr;
				}
			}
		}
		return freq == 0 ? -1 : val;
	}

}
