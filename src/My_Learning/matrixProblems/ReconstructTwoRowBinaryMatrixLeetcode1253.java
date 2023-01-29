package My_Learning.matrixProblems;

import java.util.ArrayList;
import java.util.List;

public class ReconstructTwoRowBinaryMatrixLeetcode1253 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> result = new ArrayList<>();

		if (colsum == null || colsum.length <= 0) {
			return result;
		}
		int[] upperRow = new int[colsum.length];
		int[] lowerRow = new int[colsum.length];
		int upperSum = 0;
		int lowerSum = 0;

		List<Integer> index = new ArrayList<>();

		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 2) {
				upperRow[i] = 1;
				lowerRow[i] = 1;
				upperSum++;
				lowerSum++;
			} else if (colsum[i] == 1) {
				index.add(i);
			}
			// validate did we execeed the rowsum properties
			if (upperSum > upper || lowerSum > lower) {
				return new ArrayList<>();
			}
		}

		for (int k : index) {
			if (upper > upperSum) {
				upperRow[k] = 1;
				upperSum++;
			} else if (lower > lowerSum) {
				lowerRow[k] = 1;
				lowerSum++;
			} else {
				return new ArrayList<>();
			}
		}

		if (upperSum != upper || lowerSum != lower) {
			return new ArrayList<>();
		}

		result.add(getList(upperRow));
		result.add(getList(lowerRow));
		return result;
	}

	public List<Integer> getList(int[] array) {
		// return Arrays.stream(array).boxed()).toList();
		return null;
	}

}
