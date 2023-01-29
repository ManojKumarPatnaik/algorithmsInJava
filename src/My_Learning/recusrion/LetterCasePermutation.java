package My_Learning.recusrion;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// first solve for normal small letter case present in given string
		// print the solution
		String lowerS = "abc";
		String upperS = "ABC";
		String withDigit = "a1B2c3"; // mis capital + small + digit

		permuteStrignWithLowerCase(lowerS, new String(""), 0);
		System.out.println();
		permuteStrignWithUpperCase(upperS, new String(""), 0);
		System.out.println();
		permuteStringWithDigits(withDigit, new String(""), 0);

	}

	private static void permuteStrignWithLowerCase(String lowerS, String ds, int index) {
		// TODO Auto-generated method stub

		if (index == lowerS.length()) {
			System.out.print(new String(ds) + " ");
			return;
		}
		permuteStrignWithLowerCase(lowerS, ds + (char) ((lowerS.charAt(index) - 32)), index + 1); // making Capital and
																									// take
		permuteStrignWithLowerCase(lowerS, ds + (char) (lowerS.charAt(index)), index + 1);

		return;
	}

	private static void permuteStrignWithUpperCase(String upperS, String ds, int index) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		if (index == upperS.length()) {
			System.out.print(new String(ds) + " ");
			return;
		}
		permuteStrignWithUpperCase(upperS, ds + (char) ((upperS.charAt(index) + 32)), index + 1); // making small and
																									// take
		permuteStrignWithUpperCase(upperS, ds + (char) (upperS.charAt(index)), index + 1);

		return;
	}

	private static void permuteStringWithDigits(String withDigit, String ds, int index) {
		
		if (index == withDigit.length()) {
			System.out.print(new String(ds) + " ");
			return;
		}
		Character ch = withDigit.charAt(index);
		if (Character.isLowerCase(ch)) {
			// current letter is lower case

			permuteStringWithDigits(withDigit, ds + (char) ((withDigit.charAt(index) - 32)), index + 1);
			permuteStringWithDigits(withDigit, ds + (char) (withDigit.charAt(index)), index + 1);

		} else if (Character.isUpperCase(ch)) {
			// current character is upper
			permuteStringWithDigits(withDigit, ds + (char) ((withDigit.charAt(index) + 32)), index + 1);
			permuteStringWithDigits(withDigit, ds + (char) (withDigit.charAt(index)), index + 1);

		} else {
			// assuming current char is digit
			permuteStringWithDigits(withDigit, ds + (char) (withDigit.charAt(index)), index + 1);

		}
		return;
	}

}
