package My_Learning.maths;

import java.util.LinkedList;
import java.util.List;

public class AddIntegerWithArrayLeetcode989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> res = new LinkedList<>();

		for (int i = A.length - 1; i >= 0; --i) {

			res.add(0, (A[i] + K) % 10);

			K = (A[i] + K) / 10;
		}

		// for checking the last position if carry is not equal to zero
		while (K > 0) {
			res.add(0, K % 10);
			K /= 10;
		}

		return res;

	}

}
