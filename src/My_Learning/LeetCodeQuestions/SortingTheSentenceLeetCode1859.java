package My_Learning.LeetCodeQuestions;

public class SortingTheSentenceLeetCode1859 {

	/*
	 * Input: s = "is2 sentence4 This1 a3" Output: "This is a sentence" Explanation:
	 * Sort the words in s to their original positions "This1 is2 a3 sentence4",
	 * then remove the numbers.
	 */

	public static void main(String[] args) {

		// not taking input from user just hard coding the input
		String s = "is2 sentence4 This1 a3";

		String ans = sortSentence(s);

		System.out.println(ans);

	}

	private static String sortSentence(String s) {
		String[] givenWords = s.split(" ");

		int length = givenWords.length;

		String[] sortedWords = new String[length];

		for (int i = 0; i < length; i++) {
			String word = givenWords[i];

			char lastChar = word.charAt(word.length() - 1);
			int index = Character.getNumericValue(lastChar);

			sortedWords[index - 1] = word.substring(0, word.length() - 1);

		}

		String finalAns = String.join(" ", sortedWords);

		return finalAns;
	}

}
