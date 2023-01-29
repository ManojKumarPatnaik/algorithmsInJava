package My_Learning.Arrays3;

import java.util.Arrays;

public class LargestPerimeterTriangleLeetcode976 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// For a >= b >= c, a,b,c can form a triangle if a < b + c
	public int largestPerimeter(int[] A) {
		Arrays.sort(A);
		for (int i = A.length - 1; i > 1; --i)
			if (A[i] < A[i - 1] + A[i - 2])
				return A[i] + A[i - 1] + A[i - 2];
		return 0;
	}

}
