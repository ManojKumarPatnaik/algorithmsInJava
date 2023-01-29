package My_Learning.Arrays2;

import java.util.ArrayList;

public class IntervalListIntersectionLeetcode986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

		int i = 0, j = 0;
		ArrayList<int[]> a = new ArrayList<>();

		while (i < firstList.length && j < secondList.length) {
			int[] x = new int[2];
			if (secondList[j][0] <= firstList[i][1] && secondList[j][0] >= firstList[i][0]) {
				x[0] = secondList[j][0];
				x[1] = Math.min(secondList[j][1], firstList[i][1]);
				a.add(x);
			} else if (secondList[j][0] <= firstList[i][0] && secondList[j][1] >= firstList[i][0]) {
				x[0] = firstList[i][0];
				x[1] = Math.min(secondList[j][1], firstList[i][1]);
				a.add(x);
			}
			if (secondList[j][1] >= firstList[i][1]) {
				i++;
			} else {
				j++;
			}
		}
		return a.toArray(new int[a.size()][]);
	}
}
