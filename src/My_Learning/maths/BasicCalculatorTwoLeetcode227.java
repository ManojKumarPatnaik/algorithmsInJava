package My_Learning.maths;

public class BasicCalculatorTwoLeetcode227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to caluclate given string expression
	public int calculate(String s) {
		if (s == null)
			return 0;
		s = s.trim().replaceAll(" +", "");
		int length = s.length();

		int res = 0;
		long preVal = 0; // initial preVal is 0
		char sign = '+'; // initial sign is +
		int i = 0;
		while (i < length) {
			long curVal = 0;
			while (i < length && (int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48) { // int
				curVal = curVal * 10 + (s.charAt(i) - '0');
				i++;
			}
			if (sign == '+') {
				res += preVal; // update res
				preVal = curVal;
			} else if (sign == '-') {
				res += preVal; // update res
				preVal = -curVal;
			} else if (sign == '*') {
				preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
			} else if (sign == '/') {
				preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
			}
			if (i < length) { // getting new sign
				sign = s.charAt(i);
				i++;
			}
		}
		res += preVal;
		return res;
	}

}
