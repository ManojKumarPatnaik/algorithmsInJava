package My_Learning.bitManipulation;

public class LongerContinuousSegmentOnesZerosLeetcode1869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkZeroOnes(String s) {
		int longestZeros = 0, longestOnes = 0, currentZeros = 0, currentOnes = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '0') {
				longestZeros = Math.max(longestZeros, ++currentZeros);
				currentOnes = 0;
			} else {
				longestOnes = Math.max(longestOnes, ++currentOnes);
				currentZeros = 0;
			}
		return longestOnes > longestZeros;
	}

}
