package My_Learning.recusrion;

public class CountOperationToObtainZeroLeetCode2169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countOperationsRecursive(int num1, int num2) {

		if (num1 == 0 || num2 == 0)
			return 0;

		if (num1 >= num2) {
			return 1 + countOperations(num1 - num2, num2);
		} else {
			return 1 + countOperations(num1, num2 - num1);
		}

	}

	/*
	 * We can observe that if n1is m times greater than n2, we will perform the
	 * subtraction m times, and after that n1 would be equal n1 % n2.
	 * 
	 * This is, pretty much, the Euclidean Algorithm. The complexity of this
	 * algorithm is O(log(min(a, b)).
	 */
	public int countOperations(int a, int b) {
		return a * b == 0 ? 0 : a / b + countOperations(b, a % b);
	}

}
