package My_Learning.maths;

public class SumOfEvenNumberAfterQueriesLeetcode985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode solution 
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int sum = 0;
		for (int n : A) {
			if (n % 2 == 0)
				sum += n; // calculate sum of even numbers
		}
		int q = queries.length;
		int[] ret = new int[q];
		for (int i = 0; i < q; i++) {
			int val = queries[i][0], pos = queries[i][1];
			if (A[pos] % 2 == 0) {
				sum -= A[pos];
			} // subtract old value
			A[pos] += val;
			if (A[pos] % 2 == 0) {
				sum += A[pos];
			}
			ret[i] = sum;
		}
		return ret;
	}

}
