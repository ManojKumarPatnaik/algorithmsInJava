package My_Learning.strings;

public class RemoveAllDuplicateAdjStringLeetcode1047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeDuplicates(String s) {
		char[] chars = s.toCharArray();
		int[] p = new int[] { -1, 0 }; // [write pointer, read pointer]
		rec(p, chars);
		return String.valueOf(chars, 0, p[0] + 1);
	}

	public void rec(int[] p, char[] chars) {
		int n = chars.length;
		if (p[1] == n) {
			return;
		}
		if (p[0] >= 0 && chars[p[0]] == chars[p[1]]) {
			p[0] -= 1;
		} else {
			chars[++p[0]] = chars[p[1]];
		}
		p[1]++;
		rec(p, chars);
	}

}
