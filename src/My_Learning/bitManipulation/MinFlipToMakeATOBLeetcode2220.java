package My_Learning.bitManipulation;

public class MinFlipToMakeATOBLeetcode2220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }

}
