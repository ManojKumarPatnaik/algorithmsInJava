package My_Learning.strings;

public class VowelsForAllSubstringLeetcode2063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long countVowels(String w) {
		long len = w.length();
		long count = 0;
		int i = 0;
		while (i != len) {
			if (w.charAt(i) == 'a' || w.charAt(i) == 'e' || w.charAt(i) == 'i' || w.charAt(i) == 'o'
					|| w.charAt(i) == 'u') {
				count += (i + 1) * (len - i);
			}
			i++;
		}
		return count;
	}
}
