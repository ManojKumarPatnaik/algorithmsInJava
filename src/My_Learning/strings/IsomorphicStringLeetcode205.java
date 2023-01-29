package My_Learning.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStringLeetcode205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "paper";
		String t = "title";

		String s1 = "badc";
		String t1 = "baba";

		System.out.println(isIsomorphic(s1, t1));
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.isEmpty() || t.isEmpty() || s.length() != t.length())
			return false;
		Map<Character, Character> mapChar = new LinkedHashMap<>();

		for (int i = 0; i < t.length(); i++) {

			char target = t.charAt(i);
			char old = s.charAt(i);

			if (mapChar.containsKey(old)) {
				if (mapChar.get(old).equals(target)) {
					continue;
				} else {
					return false;
				}
			} else {
				if (!mapChar.containsKey(target)) {
					mapChar.put(old, target);
				} else {
					return false;
				}

			}

		}

		return true;
	}

	public boolean isIsomorphic2(String s, String t) {
		if (s == null || s.length() <= 1)
			return true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if (map.get(a).equals(b))
					continue;
				else
					return false;
			} else {
				if (!map.containsValue(b))
					map.put(a, b);
				else
					return false;

			}
		}
		return true;

	}

}
