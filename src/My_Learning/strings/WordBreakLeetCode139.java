package My_Learning.strings;

import java.util.List;

public class WordBreakLeetCode139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	Example 1:
//
//		Input: s = "leetcode", wordDict = ["leet","code"]
//		Output: true
//		Explanation: Return true because "leetcode" can be segmented as "leet code".
	
//	Example 2:
//
//		Input: s = "applepenapple", wordDict = ["apple","pen"]
//		Output: true
//		Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//		Note that you are allowed to reuse a dictionary word.
	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		/*
		 * First DP for(int i = 1; i <= s.length(); i++){ for(String str: dict){
		 * if(str.length() <= i){ if(f[i - str.length()]){
		 * if(s.substring(i-str.length(), i).equals(str)){ f[i] = true; break; } } } } }
		 */

		// Second DP
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}

}
