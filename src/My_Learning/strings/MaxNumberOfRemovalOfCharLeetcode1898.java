package My_Learning.strings;

import java.util.HashSet;

public class MaxNumberOfRemovalOfCharLeetcode1898 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumRemovals(String s, String p, int[] removable) {
		int lo = 0;
		int hi = removable.length;
		int idx = -1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (isSubsequence(s, p, removable, mid)) {
				idx = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return idx;
	}

	private boolean isSubsequence(String s1, String s2, int[] removable, int mid) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < mid; i++) {
			set.add(removable[i]);
		}

		int j = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (!set.contains(i)) {
				if (s1.charAt(i) == s2.charAt(j))
					j++;
				if (j == s2.length())
					return true;
			}
		}

		return j == s2.length();
	}

}
