package My_Learning.Arrays;

import java.util.PriorityQueue;

public class MaxSumAfterKNegationLeetcode1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// either we have all positive number then do k opration on minimum one
	// either we have one -ve and all positive then first do operation on negative
	// then on min
	// either we have multiple -ve so do operation on abs(-ve) max value then if k
	// left then on min value

	public int largestSumAfterKNegations(int[] A, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int x : A)
			pq.add(x);
		// System.out.println("Initial = "+pq.toString());

		while (K-- > 0)
			pq.add(-pq.poll());
		// System.out.println("After k op = "+pq.toString());

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += pq.poll();
		}
		return sum;
	}

}
