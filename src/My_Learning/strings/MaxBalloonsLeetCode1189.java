package My_Learning.strings;

public class MaxBalloonsLeetCode1189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxNumberOfBalloons(String text) {
		String s = "ballon";
		int ballonCharCount = 0;

		for (char ch : text.toCharArray()) {
			if (s.contains(ch + "")) {
				ballonCharCount += 1;
			}
		}

		return ballonCharCount / 7;
	}

	public int maxNumberOfBalloons2(String text) {
		int[] chars = new int[26]; // count all letters
		for (char c : text.toCharArray()) {
			chars[c - 'a']++;
		}
		int min = chars[1];// for b
		min = Math.min(min, chars[0]);// for a
		min = Math.min(min, chars[11] / 2);// for l /2
		min = Math.min(min, chars[14] / 2);// similarly for o/2
		min = Math.min(min, chars[13]);// for n
		return min;
	}
}
