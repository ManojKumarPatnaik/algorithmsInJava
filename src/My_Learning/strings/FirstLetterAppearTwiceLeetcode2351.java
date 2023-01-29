package My_Learning.strings;

public class FirstLetterAppearTwiceLeetcode2351 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char repeatedCharacter(String s) {
		int cnt[] = new int[26];
		for (char ch : s.toCharArray())
			if (++cnt[ch - 'a'] == 2)
				return ch;
		return 'a';
	}

}
