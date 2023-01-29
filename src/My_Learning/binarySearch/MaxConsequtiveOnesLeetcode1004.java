package My_Learning.binarySearch;

public class MaxConsequtiveOnesLeetcode1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestOnes(int[] A, int K) {
		int zeroCount = 0, start = 0, res = 0;
		for (int end = 0; end < A.length; end++) {
			if (A[end] == 0)
				zeroCount++;
			while (zeroCount > K) {
				if (A[start] == 0)
					zeroCount--;
				start++;
			}
			res = Math.max(res, end - start + 1);
		}
		return res;
	}

}
