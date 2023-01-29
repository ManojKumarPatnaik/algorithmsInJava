package My_Learning.Arrays3;

import java.util.HashMap;

public class MakeArrayZeroEqualAmtSubLeetcode2357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumOperations(int[] nums) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		for (int it : nums) {
			if (it != 0) {
				mp.put(it, 0);
			}
		}
		return mp.size();
	}

}
