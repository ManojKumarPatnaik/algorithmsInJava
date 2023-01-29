package My_Learning.strings;

public class DeleteCapitalLeetcode520 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean detectCapitalUse(String word) {

		// Count the number of capital letter and check if

		// all letters are uppercase / or lowercase -> count equals word-length or count
		// == 0
		// only first letter is uppercase -> count is 1 and 0th character uppercase

		int capitals = 0;
		for (char ch : word.toCharArray()) {
			if (Character.isUpperCase(ch))
				capitals++;
		}
		// case 1 and case 2
		if (capitals == word.length() || capitals == 0)
			return true;
		return capitals == 1 && Character.isUpperCase(word.charAt(0)); // case 3
	}

}
