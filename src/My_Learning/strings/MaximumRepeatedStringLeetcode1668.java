package My_Learning.strings;

public class MaximumRepeatedStringLeetcode1668 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxRepeating(String sequence, String word) {
		String find = "";
		while (sequence.contains(find))
			find += word;
		return (find.length() - word.length()) / word.length();
	}

}
