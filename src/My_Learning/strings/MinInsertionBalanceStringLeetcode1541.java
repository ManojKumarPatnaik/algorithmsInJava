package My_Learning.strings;

public class MinInsertionBalanceStringLeetcode1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minInsertions(String s) {

		int conClosed = 0, opened = 0, total = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == ')') {
				// increment consective closed count
				conClosed++;

				// found 2 consective brackets
				if (conClosed == 2) {
					conClosed = 0;
					// check for opened bracket, which is missing 2 closed bracket
					if (opened > 0) {
						// don't need any new bracket . because we already have atleast one opened
						// bracket.
						opened--;
					} else {
						// require one open bracket for current consective 2 closed bracket
						total++;
					}
				}
			} else {
				// check if we have any closed single closed bracket
				// before this open bracket
				if (conClosed == 1) {
					// check any opened bracket, which don't have closed
					// 2 bracket before this opened bracket
					if (opened > 0) {
						opened--;
						total += 1; // only need to add one close bracket.
					} else {
						total += 2; // need to add one open and a closed bracket
					}
					conClosed = 0;
				}
				opened += 1;
			}
		}

		// edge case, check for single closed bracket
		if (conClosed == 1) {
			if (opened > 0) {
				opened--;
				total += 1;
			} else {
				total += 2;
			}
		}

		// add two closed bracket for each remaining open bracket.
		total += opened * 2;
		return total;

	}

}
