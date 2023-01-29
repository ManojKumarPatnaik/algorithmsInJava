package My_Learning.matrixProblems;

public class SparseMatrixTwoLeetcode59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[][] generateMatrix1(int n) {
		int[][] ret = new int[n][n];
		int left = 0, top = 0;
		int right = n - 1, down = n - 1;
		int count = 1;
		while (left <= right) {
			for (int j = left; j <= right; j++) {
				ret[top][j] = count++;
			}
			top++;
			for (int i = top; i <= down; i++) {
				ret[i][right] = count++;
			}
			right--;
			for (int j = right; j >= left; j--) {
				ret[down][j] = count++;
			}
			down--;
			for (int i = down; i >= top; i--) {
				ret[i][left] = count++;
			}
			left++;
		}
		return ret;
	}

	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int left = 0, right = n - 1, top = 0, bottom = n - 1;
		int count = 0;
		while (count < n * n) {
			for (int i = left; i <= right && count < n * n; i++)
				res[top][i] = ++count;
			for (int i = top + 1; i < bottom && count < n * n; i++)
				res[i][right] = ++count;
			for (int i = right; i >= left && count < n * n; i--)
				res[bottom][i] = ++count;
			for (int i = bottom - 1; i > top && count < n * n; i--)
				res[i][left] = ++count;
			left++;
			right--;
			top++;
			bottom--;
		}
		return res;
	}

}
