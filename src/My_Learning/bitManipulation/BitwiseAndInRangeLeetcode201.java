package My_Learning.bitManipulation;

public class BitwiseAndInRangeLeetcode201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rangeBitwiseAnd1(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int moveFactor = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;
		}
		return m * moveFactor;
	}

	// Kernighans algo
	public int rangeBitwiseAnd(int left, int right) {
		while (right > left) {
			right = right & (right - 1);
		}
		return right;
	}

}
