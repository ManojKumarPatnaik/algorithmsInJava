package My_Learning.strings;

public class NumberOfValidWordsLeetcode2047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	using regex to check if string matches the required condition.
//	"^([a-z]+(-?[a-z]+)?)?(!|\.|,)?$" -> this is the primary regex and was constructed as required for the question. Below you can find what the symbols signify:
//
//	^ -> starts with
//	[a-z] -> includes occurence of lowercase letters
//	+ -> one or more
//	? -> zero or one
//	( ) -> used for grouping
//	| -> or
//	$ -> ends with
//	so, parts of the above regex:
//
//	[a-z]+ -> one or more lower case english letters
//	-? -> zero or one hyphen
//	(!|\.|,)? -> zero or one of '!', '.' (need to use \. for period) and ','. Could have also used [!\.,]?
//	"[^0-9]+" -> this regex indicates that the string cannot have digits. Used this with the above as I found that the primary regex (above) did not weed out digits for some reason. If anyone knows or figures out why, please comment.
//
//	"\s+" -> using this regex to split -> covers one or more spaces as the criteria

	public int countValidWords(String sentence) {
		String regex = "^([a-z]+(-?[a-z]+)?)?(!|\\.|,)?$";
		String r2 = "[^0-9]+";
		String[] arr = sentence.split("\\s+");
		int ans = 0;
		for (String s : arr) {
			if (s.matches(regex) && s.matches(r2)) {
				ans++;
				// System.out.println(s);
			}
		}
		return ans;
	}

}
