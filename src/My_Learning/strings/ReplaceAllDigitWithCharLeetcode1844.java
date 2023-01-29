package My_Learning.strings;

public class ReplaceAllDigitWithCharLeetcode1844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String replaceDigits(String s) {
		char[] charArr = s.toCharArray();
		for (int i = 1; i < charArr.length; i += 2) {
			charArr[i] = (char) (charArr[i - 1] + charArr[i] - '0');
		}
		return String.valueOf(charArr);
	}

}
