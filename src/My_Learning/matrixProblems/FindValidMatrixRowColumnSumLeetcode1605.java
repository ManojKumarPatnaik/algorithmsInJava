package My_Learning.matrixProblems;

public class FindValidMatrixRowColumnSumLeetcode1605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int[][] output = new int[rowSum.length][colSum.length];

		int[] newSumCol = new int[colSum.length];
		newSumCol[newSumCol.length - 1] = fillRows(output, rowSum);

		int lastR = rowSum.length - 1;
		for (int j = newSumCol.length - 2; j >= 0; j--) {
			int missing = colSum[j];
			if (missing == 0) {
				continue;
			}
			if (output[lastR][newSumCol.length - 1] >= missing) {
				output[lastR][newSumCol.length - 1] -= missing;
				output[lastR][j] = missing;
			} else {
				while (missing > 0) {
					if (output[lastR][newSumCol.length - 1] < missing) {
						output[lastR][j] = output[lastR][newSumCol.length - 1];
						missing -= output[lastR][newSumCol.length - 1];
						output[lastR][newSumCol.length - 1] = 0;
						lastR--;
					} else {
						output[lastR][newSumCol.length - 1] -= missing;
						output[lastR][j] = missing;
						missing = 0;
					}
				}
			}
		}

		return output;
	}

	private int fillRows(int[][] output, int[] rowSum) {
		int sum = 0;
		for (int i = 0; i < output.length; i++) {
			output[i][output[i].length - 1] = rowSum[i];
			sum += rowSum[i];
		}
		return sum;
	}

}
