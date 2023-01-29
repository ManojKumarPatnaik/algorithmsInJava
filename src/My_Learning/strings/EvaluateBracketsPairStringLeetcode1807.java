package My_Learning.strings;

import java.util.HashMap;
import java.util.List;

public class EvaluateBracketsPairStringLeetcode1807 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String evaluate(String s, List<List<String>> knowledge) {
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<>();

		for (List<String> str : knowledge) {
			map.put(str.get(0), str.get(1));
		}

		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch == '(') {
				i++; // we are at '(' to move to next character
				StringBuilder key = new StringBuilder();
				// (abcd) -> will cover abcd through this while loop
				while (i < s.length() && s.charAt(i) != ')') {
					key.append(s.charAt(i));
					i++;
				}
				sb.append(map.containsKey(key.toString()) ? map.get(key.toString()) : "?");
				i++; // we are at ')' to move to next character
				continue;
			}
			sb.append(ch);
			i++;

		}
		return sb.toString();
	}

}
