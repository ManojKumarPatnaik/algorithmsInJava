package My_Learning.bitManipulation;

public class ReverseBitLeetcode190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int lsb = n & 1;
			int reverseLsb = lsb << (31 - i);
			result = result | reverseLsb;
			n = n >> 1;
		}
		return result;
	}

}
