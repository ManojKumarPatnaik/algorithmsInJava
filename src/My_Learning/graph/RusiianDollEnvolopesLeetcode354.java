package My_Learning.graph;

import java.util.Arrays;

public class RusiianDollEnvolopesLeetcode354 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}

			return b[1] - a[1];
		});

		int[] tops = new int[envelopes.length];
		int numPiles = 0;
		for (int i = 0; i < tops.length; i++) {
			int height = envelopes[i][1];

			// find pile
			int pile = Arrays.binarySearch(tops, 0, numPiles, height);
			if (pile < 0) {
				pile = -(pile + 1);
			}

			// update pile top height
			tops[pile] = height;

			// if pile == numPiles, means it's out of index
			if (pile == numPiles) {
				numPiles++;
			}
		}

		return numPiles;
	}

}
