package My_Learning.strings;

public class ExcelSheetColumnTitleLeetcode168 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convertToTitle(int columnNumber) {
		int n = columnNumber;

		StringBuilder result = new StringBuilder();

		while (n > 0) {
			n--;
			result.insert(0, (char) ('A' + n % 26));
			n /= 26;
		}

		return result.toString();
	}

}
