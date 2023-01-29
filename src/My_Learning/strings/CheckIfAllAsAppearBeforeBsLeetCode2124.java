package My_Learning.strings;

public class CheckIfAllAsAppearBeforeBsLeetCode2124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkString1(String s) {
		int lastOccuranceOfA = Integer.MIN_VALUE;
		int firstOccuranceOfB = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				lastOccuranceOfA = Math.max(lastOccuranceOfA, i);
			} else if (s.charAt(i) == 'b') {
				firstOccuranceOfB = Math.min(firstOccuranceOfB, i);
			}
		}

		return lastOccuranceOfA < firstOccuranceOfB;
	}

	// we can't have a after b so "ba" substring is not allowed
	public boolean checkString(String s) {
		for (int i = 1; i < s.length(); ++i)
			if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a')
				return false;
		return true;
	}

}
