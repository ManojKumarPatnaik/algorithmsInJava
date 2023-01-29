package My_Learning.bitManipulation;

public class MinFlipToMakeAORBToCLeetcode1318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minFlips(int a, int b, int c) {
		int count = 0;
		while (a > 0 || b > 0 || c > 0) {
			if (((a & 1) | (b & 1)) != (c & 1)) {
				count += (c & 1) == 1 ? 1 : (a & 1) + (b & 1);
			}
			a >>= 1;
			b >>= 1;
			c >>= 1;
		}
		return count;

	}

}
