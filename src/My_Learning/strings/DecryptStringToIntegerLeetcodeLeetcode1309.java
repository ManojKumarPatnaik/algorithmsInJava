package My_Learning.strings;

import java.util.HashMap;

public class DecryptStringToIntegerLeetcodeLeetcode1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String freqAlphabets(String s) {
		int n = s.length();
		String ans = "";
		for (int i = 0; i < n;) {
			if (i < n - 2 && s.charAt(i + 2) == '#') {
				int num = Integer.parseInt(s.substring(i, i + 2));
				ans += (char) (num + 96);
				i = i + 3;
				continue;
			}
			ans += (char) (97 + s.charAt(i) - '1');
			i++;
		}
		return ans;
	}

	public String freqAlphabetsMapSolution(String str) {
		HashMap<String, Character> map = new HashMap<>();
		int k = 1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (ch < 'j')
				map.put(String.valueOf(k++), ch);
			else
				map.put(String.valueOf(k++) + "#", ch);
		}

		StringBuilder sb = new StringBuilder();
		int i = str.length() - 1;
		while (i >= 0) {
			if (str.charAt(i) == '#') {
				sb.append(map.get(str.substring(i - 2, i + 1)));
				i -= 3;
			} else {
				sb.append(map.get(str.substring(i, i + 1)));
				i--;
			}
		}

		return sb.reverse().toString();
	}

}
