package My_Learning.matrixProblems;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrixLeetcode1380 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> luckyNumbers(int[][] matrix) {
		int min, max;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			int index = 0;
			min = Integer.MAX_VALUE;
			for (int j = 0; j < matrix[0].length; j++) {
				if (min > matrix[i][j]) { // find the minimum in the row
					min = matrix[i][j];
					index = j; // store the column number of the minimum element of Matrix
				}
			}
			max = Integer.MIN_VALUE;
			for (int j = 0; j < matrix.length; j++) // // find the maximum number of the column which column are take
													// minimum number of a particular row
				max = Math.max(max, matrix[j][index]);
			if (min == max)
				list.add(min); // at the last check if this max and min value is same or not if both are same
								// then store it in the list. because its the lucky number;
		}
		return list;
	}

}
