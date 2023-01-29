package My_Learning.Arrays3;

public class SmallestValueOfRearrangedNumberLeetcode2165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long smallestNumber(long num) {
		int[] count = new int[10];
		long tempNum = num > 0 ? num : num * -1;
		int min = 10;
		// get the count of each digit
		while (tempNum > 0) {
			int rem = (int) (tempNum % 10);
			if (rem != 0) {
				min = Math.min(min, rem);
			}
			count[rem]++;
			tempNum = tempNum / 10;
		}

		long output = 0;
		// positive number
		if (num > 0) {

			output = output * 10 + min; // add the min non zero digit first in the output
			count[min]--; // decrement the count of that digit
			// iterate all the digits from ) to 9 and get the count value to form the number
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < count[i]; j++) {
					output = output * 10 + i;
				}
			}
		} else { // negative number
			// iterate in reverse order (from 9 to 0)
			for (int i = 9; i >= 0; i--) {
				for (int j = 0; j < count[i]; j++) {
					output = output * 10 + i;
				}
			}
			output = output * -1; // multiply with -1 to make output negative
		}
		return output;
	}

}
