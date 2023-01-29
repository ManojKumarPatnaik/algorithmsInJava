package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumBuildingHeightLeetcode1840 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxBuilding(int n, int[][] restrictions) {
		Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));
		// first updata restrictions from left to right
		// this is because there is case that the restriction height cannot be achieved.
		// example
		// H: 0 3 9
		// ind: 1 2 3
		// because the gap between 2-1 and 3-2 is too small, so the maximum height
		// cannot be achieved,
		// can only achieved:
		// H: 0 1 2
		// ind: 1 2 3
		int prevInd = 1, prevH = 0;
		for (int i = 0; i < restrictions.length; i++) {
			restrictions[i][1] = Math.min(restrictions[i][1], prevH + (restrictions[i][0] - prevInd));
			prevInd = restrictions[i][0];
			prevH = restrictions[i][1];
		}

		// similar but updata restrictions from right to left
		for (int i = restrictions.length - 2; i >= 0; i--) {
			restrictions[i][1] = Math.min(restrictions[i][1],
					restrictions[i + 1][1] + (restrictions[i + 1][0] - restrictions[i][0]));
		}

		int ph = 0, pInd = 1, highest = 0;
		for (int i = 0; i < restrictions.length; i++) {
			int ind = restrictions[i][0];
			int h = restrictions[i][1];
			if (ph < h) {
				h = Math.min(h, ph + (ind - pInd));
				// if we have remains steps we can achieve a higher height by doing the
				// following
				// example: pInd = 1, ph = 1, ind = 6, h = 2
				// reaching height 1 to height 2 only needs 1 step, but we have (6-1) - 1 = 4
				// remaing steps
				// we can use the 4 remaining steps to go higher first then back down.
				// The steps are, first move up to 2, then we have 4 steps, go 2 up to height 4,
				// then 2 down back to 2, so highest is 4
				// H 1 2 3 4 3 2
				// ind 1 6
				int remains = Math.max(0, (ind - pInd) - (h - ph));
				highest = Math.max(highest, h + remains / 2);
			} else {
				// after the above preprocessing, we must be able to go down from ph to h.
				int remains = (ind - pInd) - (ph - h);
				highest = Math.max(highest, ph + remains / 2);
			}
			ph = h;
			pInd = ind;
			;
		}
		highest = Math.max(highest, ph + (n - pInd));
		return highest;
	}

}
