package My_Learning.strings;

public class CheckIfTwoStringAreEqualLeetcode1662 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		int idx1 = 0, idx2 = 0, arrIdx1 = 0, arrIdx2 = 0;
		while (arrIdx1 < word1.length && arrIdx2 < word2.length) {
			if (word1[arrIdx1].charAt(idx1) != word2[arrIdx2].charAt(idx2))
				return false;
			idx1 = (++idx1) % word1[arrIdx1].length();
			idx2 = (++idx2) % word2[arrIdx2].length();
			if (idx1 == 0)
				arrIdx1++;
			if (idx2 == 0)
				arrIdx2++;
		}
		return arrIdx1 == word1.length && arrIdx2 == word2.length;
	}

}
