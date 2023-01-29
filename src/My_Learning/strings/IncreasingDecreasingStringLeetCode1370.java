package My_Learning.strings;

public class IncreasingDecreasingStringLeetCode1370 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String sortString(String s) {
		StringBuilder ans = new StringBuilder();
		int[] count = new int[26];
		for (char c : s.toCharArray())
			++count[c - 'a'];
		while (ans.length() < s.length()) {
			add(count, ans, true);
			add(count, ans, false);
		}
		return ans.toString();
	}

	public void add(int[] cnt, StringBuilder ans, boolean asc) {
		for (int i = 0; i < 26; ++i) {
			int j = asc ? i : 25 - i;
			if (cnt[j]-- > 0)
				ans.append((char) (j + 'a'));
		}
	}

}
