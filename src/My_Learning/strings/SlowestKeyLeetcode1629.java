package My_Learning.strings;

public class SlowestKeyLeetcode1629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int n = releaseTimes.length;
		int maxDifference = releaseTimes[0];
		char bestChar = keysPressed.charAt(0);
		for (int i = 1; i < n; i++) {
			int difference = releaseTimes[i] - releaseTimes[i - 1];

			if (difference > maxDifference || (difference == maxDifference && keysPressed.charAt(i) > bestChar)) {
				maxDifference = difference;
				bestChar = keysPressed.charAt(i);
			}
		}
		return bestChar;
	}

}
