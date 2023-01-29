package My_Learning.maths;

public class CheckSumIfNumberSumThreeLeetcode1780 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static final int[] powersOf3 = new int[15];
	// public boolean checkPowersOfThree(int n) {
	// if (powersOf3[0] == 0) {
	// for (int i = 0, p = 1; i < 15; ++i, p *= 3) {
	// powersOf3[i] = p;
	// }
	// }
	// for (int i = 14; i >= 0 && n > 0; --i) {
	// if (n >= 2 * powersOf3[i]) {
	// return false;
	// }else if (n >= powersOf3[i]) {
	// n -= powersOf3[i];
	// }
	// }
	// return true;
	// }

	public boolean checkPowersOfThree(int n) {
		while (n > 0) {
			if (n % 3 == 2) {
				return false;
			} else {
				n /= 3;
			}
		}
		return true;
	}

}
