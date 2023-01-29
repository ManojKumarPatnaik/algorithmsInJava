package My_Learning.strings;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOf2PalindromeSubsequeceLeetcode2002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProduct(String s) {
		/*
		 * All possible subsequences are 1 -> 2^11 sub1 & sub2 == 0, that means disjoint
		 */
		int n = s.length();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i < (1 << n); i++) {

			// now that we a bitmask for a subsequence
			// convert it to string

			String subseq = "";

			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0)
					subseq += s.charAt(j);
			}

			if (isPalindrome(subseq))
				map.put(i, subseq.length());
		}

		System.out.println(map);

		int max = Integer.MIN_VALUE;
		for (int i : map.keySet()) {
			for (int j : map.keySet()) {
				/*
				 * If both the subsequences are not same and they are disjoint then we got two
				 * disjoint substrings now we just need to find product of their length
				 */
				if (i != j && ((i & j) == 0)) {
					max = Math.max(max, map.get(i) * map.get(j));
				}
			}
		}

		return max;
	}

	public boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString().equals(str);
	}
}
