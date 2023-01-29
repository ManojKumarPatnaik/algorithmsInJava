package My_Learning.strings;

import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLeeterUpLoLeetcode2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String greatestLetter(String s) {
		char uc = 'Z';
		char lc = 'z';
		for (int i = 0; i < 26; i++) {
			if (s.contains(Character.toString(uc)) && s.contains(Character.toString(lc))) {
				return Character.toString(uc);
			}
			uc--;
			lc--;
		}
		return "";
	}

	// method 2
	public String greatestLetter2(String s) {
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray())
			set.add(ch);

		for (char ch = 'Z'; ch >= 'A'; ch--)
			if (set.contains(ch) && set.contains((char) ('a' + (ch - 'A'))))
				return "" + ch;
		return "";
	}

}
