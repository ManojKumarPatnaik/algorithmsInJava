package My_Learning.bitManipulation;

public class MaxXORAfterOperationLeetcode2317 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumXOR(int[] nums) {
		int res = 0;
		for (int a : nums)
			res |= a;
		return res;
	}

}
