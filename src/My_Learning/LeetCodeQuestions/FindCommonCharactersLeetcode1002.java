package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharactersLeetcode1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Input: words = ["bella","label","roller"] Output: ["e","l","l"]
	 */

	public List<String> commonChars(String[] A) {
		List<String> ans = new ArrayList<>();
		int[] count = new int[26];
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String str : A) {
			int[] cnt = new int[26];
			str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
			for (int i = 0; i < 26; ++i) {
				count[i] = Math.min(cnt[i], count[i]);
			} // update minimum frequency.
		}
		for (char c = 'a'; c <= 'z'; ++c) {
			while (count[c - 'a']-- > 0) {
				ans.add("" + c);
			}
		}
		return ans;
	}

}
