package My_Learning.maths;

public class PowerOfTwoLeetcode342 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added power of 2, 4 method
	public boolean isPowerOfFour(int num) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (((num >>> i) & 1) != 0) {
				count++;
				if (i % 2 == 1)
					return false;
			}
		}
		if (count == 1)
			return true;
		else
			return false;
	}

}
