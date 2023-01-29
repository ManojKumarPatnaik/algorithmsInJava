package My_Learning.strings;

import java.util.HashSet;

public class UniqueMorseCodeLeetcode804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniqueMorseRepresentations(String[] words) {
		String[] d = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		HashSet<String> s = new HashSet<>();
		for (String w : words) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < w.length(); ++i)
				sb.append(d[w.charAt(i) - 'a']);
			s.add(sb.toString());
		}
		return s.size();
	}

}
