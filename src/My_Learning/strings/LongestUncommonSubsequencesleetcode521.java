package My_Learning.strings;

import java.util.HashMap;

public class LongestUncommonSubsequencesleetcode521 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aba";
		String b = "cdc";

		String a1 = "aefawfawfawfaw";
		String b1 = "aefawfeawfwafwaef";

		System.out.println(findLUSlength(a1, b1));

	}

	public static int findLUSlength(String a, String b) {
		for (Character ch : b.toCharArray()) {
			a = a.replace(String.valueOf(ch), "");
		}
		return a.length() != 0 ? a.length() : -1;
	}

	// brute force but it will give TLE
	public int findLUSlengthBF(String a, String b) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String s : new String[] { a, b }) {
			for (int i = 0; i < (1 << s.length()); i++) {
				String t = "";
				for (int j = 0; j < s.length(); j++) {
					if (((i >> j) & 1) != 0)
						t += s.charAt(j);
				}
				if (map.containsKey(t))
					map.put(t, map.get(t) + 1);
				else
					map.put(t, 1);
			}
		}
		int res = -1;
		for (String s : map.keySet()) {
			if (map.get(s) == 1)
				res = Math.max(res, s.length());
		}
		return res;
	}

//  using a bit logic
//	Simple analysis of this problem can lead to an easy solution.
//
//	These three cases are possible with string aaa and bbb:-
//
//	a=b. If both the strings are identical, it is obvious that no subsequence will be uncommon. 
//  Hence, return -1.
//
//	length(a)=length(b) and a≠b 
//	Example: abcabcabc and abdabdabd.
//	In this case we can consider any string i.e. abcabcabc or abdabdabd as a required subsequence,
//	as out of these two strings one string will never be a subsequence of other string. 
//	Hence, return length(a) or length(b).
//
//	length(a)≠length(b) Example abcdabcdabcd and abcabcabc. 
//	In this case we can consider bigger string as a required subsequence
//	because bigger string can't be a subsequence of smaller string. 
//	Hence, return max(length(a),length(b)).
			
	public int findLUSlengthOS(String a, String b) {
		if (a.equals(b))
			return -1;
		return Math.max(a.length(), b.length());
	}

}
