package My_Learning.strings;

public class StringCompressionLeetcode443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compress(char[] chars) {

		if (chars == null || chars.length == 0)
			return 0;

		int index = 0, n = chars.length, i = 0;
		while (i < n) {
			char ch = chars[i];
			int j = i;
			while (j < n && chars[i] == chars[j]) { // chars[i..j - 1] are ch.
				j++;
			}
			int freq = j - i; // The frequency of ch.
			chars[index++] = ch;
			if (freq == 1) {

			} else if (freq < 10) {
				chars[index++] = (char) (freq + '0');
			} else {
				String strFreq = String.valueOf(freq);
				for (char chFreq : strFreq.toCharArray())
					chars[index++] = chFreq;
			}
			i = j;
		}

		return index;
	}

}
