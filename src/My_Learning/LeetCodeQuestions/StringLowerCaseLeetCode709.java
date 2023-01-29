package My_Learning.LeetCodeQuestions;

import java.util.stream.IntStream;

public class StringLowerCaseLeetCode709 {
	public static void main(String[] args) {

		String s = "This is me Ujjwal!!";

		String lowerCaseString = toLowerCaseString(s);

		System.out.println(lowerCaseString);
	}

	private static String toLowerCaseString(String s) {

		return s.toLowerCase();
	}

	public String toLowerCase1(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++)
			if ('A' <= a[i] && a[i] <= 'Z')
				a[i] = (char) (a[i] - 'A' + 'a');
		return new String(a);
	}

	public String toLowerCase2(String s) {
		char[] a = s.toCharArray();
		IntStream.range(0, a.length).filter(i -> 'A' <= a[i] && a[i] <= 'Z')
				.forEach(i -> a[i] = (char) (a[i] - 'A' + 'a'));
		return new String(a);
	}
}
