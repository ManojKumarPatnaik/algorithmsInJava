package My_Learning.strings;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeLeetcode1177 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		int str_len = s.length();
		int j = 0;
		List<Boolean> results = new ArrayList<>();
		int[] masks = new int[str_len + 1];

		int mask = 0;
		for (int i = 0; i < str_len; i++) {
			mask ^= (1 << (s.charAt(i) - 'a'));
			masks[++j] = mask;
		}

		for (int[] query : queries) {
			if (query[2] >= 13) {
				results.add(true);
			} else {
				results.add(Integer.bitCount(masks[query[1] + 1] ^ masks[query[0]]) / 2 <= query[2]);
			}
		}

		return results;

	}

}
