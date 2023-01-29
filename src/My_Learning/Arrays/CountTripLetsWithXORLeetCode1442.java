package My_Learning.Arrays;

public class CountTripLetsWithXORLeetCode1442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countTriplets(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			for (int k = i + 1; k < arr.length; k++) {
				val = val ^ arr[k];
				if (val == 0)
					count += (k - i);
			}
		}
		return count;
	}
}
