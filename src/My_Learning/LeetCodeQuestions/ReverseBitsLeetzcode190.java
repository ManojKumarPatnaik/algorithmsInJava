package My_Learning.LeetCodeQuestions;

public class ReverseBitsLeetzcode190 {

//	Input:n=00000010100101000001111010011100 Output:964176192(00111001011110000010100101000000)Explanation:
//	The input
//	binary string 00000010100101000001111010011100
//	represents the
//	unsigned integer 43261596,so return 964176192
//	which its
//	binary representation is 00111001011110000010100101000000.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
