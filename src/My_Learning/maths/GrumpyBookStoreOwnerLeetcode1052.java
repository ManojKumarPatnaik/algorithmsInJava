package My_Learning.maths;

public class GrumpyBookStoreOwnerLeetcode1052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int satisfy = 0;
		for (int i = 0; i < grumpy.length; i++) {
			if (grumpy[i] == 0)
				satisfy += customers[i]; // directly sum the satisfy customers
			customers[i] = grumpy[i] * customers[i]; // collect the unsatisfy customers
		}
		return satisfy + getMax(customers, X);
	}

	public int getMax(int[] arr, int X) { // X is window size
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (i >= X) {
				sum -= arr[i - X];
			}
			max = Math.max(max, sum);
		}
		return max;
	}

}
